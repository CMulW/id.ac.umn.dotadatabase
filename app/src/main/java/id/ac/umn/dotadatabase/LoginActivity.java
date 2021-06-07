package id.ac.umn.dotadatabase;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
    protected EditText loginEtEmail;
    protected EditText loginEtPassword;
    protected Button loginBtnLogin;
    protected Button loginBtnRegister;
    //firebase singletons
    protected FirebaseAnalytics firebaseAnalytics;
    protected FirebaseAuth firebaseAuth;

    //Log tags
    protected static final String LOG_TAG_WARNING = "LoginActivity_Warning";

    //setup sharedPreference
    protected static final String loginSharedPreferenceFileName= "loginSharedPreference";
    protected static SharedPreferences loginSharedPreference;

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
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
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

        //setup sharedPreference
        loginSharedPreference = getSharedPreferences(loginSharedPreferenceFileName, MODE_PRIVATE);

        //firebase singletons
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAuth = FirebaseAuth.getInstance();

        //fill in loginEtEmail with data from sharedPreference
        loginEtEmail.setText(loginSharedPreference.getString("email", null));
        //DEBUGGING, fill in the pasword to speed up development
        loginEtPassword.setText(loginSharedPreference.getString("password", null));
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
    protected void onPause(){
        super.onPause();
        //put the email that user used to login into sharedPreference
        loginSharedPreference.edit().putString("email", loginEtEmail.getText().toString()).apply();
        //DEBUGGING, save password too, just to speed things up in development
        loginSharedPreference.edit().putString("password", loginEtPassword.getText().toString()).apply();
    }

    protected void FirebaseUserLogin(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
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