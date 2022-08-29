package com.example.cinestarticketsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView password;
    private UserEntity user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        String username = getIntent().getStringExtra("username");

        user = UserDatabase.getUserDatabase(this).userDao().getUserByUsername(username);


        name = findViewById(R.id.u_username);
        email = findViewById(R.id.u_email);
        password = findViewById(R.id.u_password);
        name.setText(username);
        email.setText(user.getEmail().toString());
        password.setText(user.getPassword().toString());


        // Initializie variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setSelectedItemId(R.id.nav_settings);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.nav_home:
                        Intent intent = new Intent(getApplicationContext()
                                ,MainScreen.class);
                        intent.putExtra("username", username);
                        overridePendingTransition(0,0);
                        startActivity(intent);
                        return true;
                    case R.id.nav_settings:
                        return true;
                    case R.id.nav_logut:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                }
                return false;
            }
        });
    }
}