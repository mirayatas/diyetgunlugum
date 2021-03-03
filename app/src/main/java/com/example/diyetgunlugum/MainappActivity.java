package com.example.diyetgunlugum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;


import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainappActivity extends AppCompatActivity {

    private Toolbar actionbar;
    private ViewPager vpMain;
    private TabLayout tabsMain;
    private TabsAdapterr tabsAdapter ;

    private FirebaseUser auth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainapp);


        actionbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(actionbar);
        getSupportActionBar().setTitle(R.string.app_name);

        vpMain = (ViewPager) findViewById(R.id.vpMain);
        tabsAdapter = new TabsAdapterr(getSupportFragmentManager());
        vpMain.setAdapter(tabsAdapter);

        tabsMain = (TabLayout) findViewById(R.id.tabsMain);
        tabsMain.setupWithViewPager(vpMain);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menumain,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId()==R.id.mainLogout){
            FirebaseAuth.getInstance().signOut();
            Intent loginIntent = new Intent(MainappActivity.this,LoginActivity.class);
            startActivity(loginIntent);
            finish();

        }

        return true;
    }
}
