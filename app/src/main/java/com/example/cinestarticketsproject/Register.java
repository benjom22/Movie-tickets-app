package com.example.cinestarticketsproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText username, email, password;
    public Button button;
    public TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        email = findViewById(R.id.editTextTextPersonName4);
        password = findViewById(R.id.password);

        button =(Button) findViewById(R.id.gobackbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, FirstScreen.class);
                startActivity(i);
                finish();
            }
        });
        button =(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //Creating user entity
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUsername(username.getText().toString());
                    userEntity.setEmail(email.getText().toString());
                    userEntity.setPassword(password.getText().toString());

                    if (!validateInput(userEntity)) {
                        Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();

                    } else {
                        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                        UserDao userDao = userDatabase.userDao();
                        if (validateEmailAddress(email)) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    userDao.registerUser(userEntity);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(), "User Registrated!", Toast.LENGTH_SHORT).show();
                                            Intent i = new Intent(Register.this, RequActivity.class);
                                            startActivity(i);
                                        }
                                    });

                                }
                            }).start();
                        }
                    }
                }

            private  boolean validateEmailAddress(EditText email){

                String emailInput = email.getText().toString();
                if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
                    Toast.makeText(getApplicationContext(), "Email valid!", Toast.LENGTH_SHORT).show();
                    return true;
                }else{
                    Toast.makeText(getApplicationContext(), "Email invalid !", Toast.LENGTH_SHORT).show();
                    return false;
                }

            }

            private Boolean validateInput(UserEntity userEntity){
                if (userEntity.getUsername().isEmpty() ||
                        userEntity.getPassword().isEmpty() ||
                        userEntity.getEmail().isEmpty()){
                    return false;
                }
                return true;
            }
        });

        text =(TextView) findViewById(R.id.signin);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}