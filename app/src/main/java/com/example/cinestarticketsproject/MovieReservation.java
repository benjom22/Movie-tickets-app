package com.example.cinestarticketsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MovieReservation extends AppCompatActivity {

    String fname, laname, em;
    EditText firstname, lastname, email;
    Button button1;
    TextView movieName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_reservation);

        firstname = findViewById(R.id.inputFirstName);
        fname = firstname.getText().toString();
        lastname = findViewById(R.id.inputLastName);
        laname = lastname.getText().toString();
        email = findViewById(R.id.inputEmailTicket);
        em = email.getText().toString();


        Intent intent = getIntent();

        movieName = findViewById(R.id.reservationmovie);
        String selectedName = intent.getStringExtra("selectedMovieName");
        movieName.setText(selectedName);

        button1 = (Button) findViewById(R.id.ConfirmTicket);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*if (fname.isEmpty() || laname.isEmpty() || em.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                } else {*/
                    Intent intent = new Intent(MovieReservation.this, FinalTicket.class);
                    startActivity(intent);
                    finish();
                }
            //}
        });

    }
}