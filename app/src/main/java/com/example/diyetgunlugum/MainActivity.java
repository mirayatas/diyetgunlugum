package com.example.diyetgunlugum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button btnWelcomeLogin,btnWelcomeRegister;
    private FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWelcomeLogin = (Button) findViewById(R.id.btnWelcomeLogin);
        btnWelcomeRegister = (Button) findViewById(R.id.btnWelcomeRegister);
        btnWelcomeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intentLogin);
            }
        });

        btnWelcomeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intentRegister);
            }
        });
    }
    @Override
    protected void onStart()
    {
        if (currentUser != null){
            Intent WelcomeIntent = new Intent(MainActivity.this,MainappActivity.class);
            startActivity(WelcomeIntent);
            finish();
        }
        super.onStart();
    }


}


