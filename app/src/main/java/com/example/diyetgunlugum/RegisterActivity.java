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

public class RegisterActivity extends AppCompatActivity {

    private Toolbar actionbarRegister;
    private EditText txtusername,txtemail,txtpassword;
    private Button btnRegister;
    private FirebaseAuth auth;

    public void init(){
        actionbarRegister = (Toolbar) findViewById(R.id.actionbarRegister);
        setSupportActionBar(actionbarRegister);
        getSupportActionBar().setTitle("Hesap Oluştur");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth = FirebaseAuth.getInstance();

        txtusername = (EditText) findViewById(R.id.txtusernameRegister);
        txtemail = (EditText) findViewById(R.id.txtemailRegister);
        txtpassword = (EditText) findViewById(R.id.txtpasswordRegister);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount();
            }
        });
    }


    private void createNewAccount(){

        String username = txtusername.getText().toString();
        String email = txtemail.getText().toString();
        String password = txtpassword.getText().toString();

        if(TextUtils.isEmpty(email)){

            Toast.makeText(this,"Email Alanı Boş Olamaz",Toast.LENGTH_LONG).show();


        }
        else if (TextUtils.isEmpty(password)){

            Toast.makeText(this,"Parola Alanı Boş Olamaz",Toast.LENGTH_LONG).show();

        }
        else{

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this,"Hesabınız Başarılı Bir Şekilde Oluşturuldu",Toast.LENGTH_LONG).show();
                        Intent loginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else {

                        Toast.makeText(RegisterActivity.this,"Bir Sorun Oluştu Lütfen Tekrar Deneyiniz",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }


    }
}
