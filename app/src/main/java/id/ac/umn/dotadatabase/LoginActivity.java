package id.ac.umn.dotadatabase;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText loginEtEmail;
    EditText loginEtPassword;
    Button loginBtnLogin;
    Button loginBtnRegister;

    //firebase singletons
    FirebaseAnalytics firebaseAnalytics;
    FirebaseAuth firebaseAuth;

    //Log tags
    private static final String LOG_TAG_WARNING = "LoginActivity_Warning";

    //multipurpose launcher to launch activities for results
    protected ActivityResultLauncher<Intent> LaunchActivityForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            switch(result.getResultCode()){
                case RegisterActivity.REQUEST_CODE_REGISTER_SUCCESS:
                    Toast.makeText(
                            LoginActivity.this,
                            "Successfully registered " + result.getData().getStringExtra("username"),
                            Toast.LENGTH_LONG
                    ).show();
                    break;
                case RegisterActivity.REQUEST_CODE_REGISTER_CANCEL:
                    Toast.makeText(
                            LoginActivity.this,
                            "Canceled registration",
                            Toast.LENGTH_LONG
                    ).show();
                    break;
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEtEmail = findViewById(R.id.loginEtEmail);
        loginEtPassword = findViewById(R.id.loginEtPassword);
        loginBtnLogin = findViewById(R.id.loginBtnLogin);
        loginBtnRegister = findViewById(R.id.loginBtnRegister);

        //firebase singletons
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart(){
        super.onStart();
        loginBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEtEmail.getText().toString();
                String password = loginEtPassword.getText().toString();
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(
                            LoginActivity.this,
                            "Credentials empty!",
                            Toast.LENGTH_SHORT
                    ).show();
                }else{
                    FirebaseUserLogin(email, password);
                }
            }
        });
        loginBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchActivityForResult.launch(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        //save email to saved preference
    }

    protected void FirebaseUserLogin(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(
                            LoginActivity.this,
                            "Wrong email or password",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }

}