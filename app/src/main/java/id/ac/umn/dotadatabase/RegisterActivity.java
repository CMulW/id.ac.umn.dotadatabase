package id.ac.umn.dotadatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class RegisterActivity extends AppCompatActivity {
    protected EditText registerEtUsername;
    protected EditText registerEtEmail;
    protected EditText registerEtPassword;
    protected EditText registerEtConfirmPassword;
    protected Button registerBtnRegister;

    protected Profile newProfile;

    //firebase singletons
    protected FirebaseAnalytics firebaseAnalytics;
    protected FirebaseAuth firebaseAuth;
    protected FirebaseFirestore firestore;
    protected FirebaseStorage firebaseStorage;

    //request code for those who need to launch this activity
    public static final int REQUEST_CODE_REGISTER_SUCCESS = 90;
    public static final int REQUEST_CODE_REGISTER_CANCEL = 91;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerEtUsername = findViewById(R.id.registerEtUsername);
        registerEtEmail = findViewById(R.id.registerEtEmail);
        registerEtPassword = findViewById(R.id.registerEtPassword);
        registerEtConfirmPassword = findViewById(R.id.registerEtConfirmPassword);
        registerBtnRegister = findViewById(R.id.registerBtnRegister);

        //firebase singletons
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
    }

    @Override
    protected void onStart(){
        super.onStart();
        registerBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = registerEtUsername.getText().toString();
                String email = registerEtEmail.getText().toString();
                String password = registerEtPassword.getText().toString();
                String confirmPassword = registerEtConfirmPassword.getText().toString();
                if(
                    TextUtils.isEmpty(username)
                    || TextUtils.isEmpty(email)
                    || TextUtils.isEmpty(password)
                    || TextUtils.isEmpty(confirmPassword)
                ){
                    Toast.makeText(
                            RegisterActivity.this,
                            "Mustn't be empty!",
                            Toast.LENGTH_SHORT
                    ).show();
                }else if( ! TextUtils.equals(password, confirmPassword) ) {
                    Toast.makeText(
                            RegisterActivity.this,
                            "Passwords don't match!",
                            Toast.LENGTH_SHORT
                    ).show();
                }else{
                    FirebaseRegisterUser(username, email, password);
                }
            }
        });
    }

    protected void FirebaseRegisterUser(String username, String email, String password){
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    setResult(REQUEST_CODE_REGISTER_SUCCESS, new Intent().putExtra("username", username));
                }
                //generate basic profile
                newProfile = new Profile(
                        username,
                        email,
                        0,
                        1,
                        2,
                        3,
                        0,
                        1
                );
                //upload profile data to firestore
                firestore
                        .collection(getString(R.string.firestore_user_profile_data_path))
                        .document(email)
                        .set(newProfile);
                //put default images into internal storage
                newProfile.SavePictureIntoInternal(
                        ((BitmapDrawable)getDrawable(R.drawable.dota_2)).getBitmap(),
                        Profile.PICTURE_TYPE.DISPLAY_PICTURE,
                        RegisterActivity.this
                );
                newProfile.SavePictureIntoInternal(
                        ((BitmapDrawable)getDrawable(R.drawable.dota_2)).getBitmap(),
                        Profile.PICTURE_TYPE.BANNER_PICTURE,
                        RegisterActivity.this
                );
                //upload the images into firebase storage
                newProfile.SyncPictureUp(Profile.PICTURE_TYPE.DISPLAY_PICTURE, RegisterActivity.this);
                newProfile.SyncPictureUp(Profile.PICTURE_TYPE.BANNER_PICTURE, RegisterActivity.this);
                finish();
            }
        });
    }
}