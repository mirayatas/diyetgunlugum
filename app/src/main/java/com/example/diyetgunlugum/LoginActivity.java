package com.example.diyetgunlugum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private Toolbar actionbarLogin;
    private EditText txtEmail,txtPassword;
    private Button btnLogin;
    private FirebaseAuth auth;
    private FirebaseUser currentUser;

    public void init(){
        actionbarLogin = (Toolbar) findViewById(R.id.action_barLogin);
        setSupportActionBar(actionbarLogin);
        getSupportActionBar().setTitle("Giriş Yap");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        auth=FirebaseAuth.getInstance();
        currentUser=auth.getCurrentUser();

        txtEmail=(EditText) findViewById(R.id.txtEmailLogin);
        txtPassword=(EditText) findViewById(R.id.txtPasswordLogin);
        btnLogin=(Button) findViewById(R.id.btnLogin);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser(){

        String Email = txtEmail.getText().toString();
        String Password = txtPassword.getText().toString();

        if(TextUtils.isEmpty(Email)){
            Toast.makeText(this,"Email Alanı Boş Olamaz",Toast.LENGTH_LONG);


        }
        else if(TextUtils.isEmpty(Password)){

            Toast.makeText(this,"Şifre Alanı Boş Olamaz",Toast.LENGTH_LONG);
        }

        else{
            auth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){

                       Toast.makeText(LoginActivity.this,"Giriş Başarılı",Toast.LENGTH_LONG);
                       Intent mainIntent = new Intent(LoginActivity.this,MainappActivity.class);
                       startActivity(mainIntent);
                       finish();

                }
                   else{

                       Toast.makeText(LoginActivity.this,"Giriş Başarısız",Toast.LENGTH_LONG);

                   }
                }
            });
        }
    }
}
