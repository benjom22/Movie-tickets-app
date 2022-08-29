package com.example.cinestarticketsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class FinalTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_ticket);

        Random addition1 = new Random();
        int additionint1 = addition1.nextInt(100000)+1;
        TextView additionText1 = (TextView) findViewById(R.id.textView7);
        String additionString1 = String.valueOf(additionint1);
        additionText1.setText(additionString1);



    }
}