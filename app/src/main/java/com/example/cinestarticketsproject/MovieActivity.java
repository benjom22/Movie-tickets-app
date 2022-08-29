package com.example.cinestarticketsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieActivity extends AppCompatActivity {

    Button button1,button2;
    ImageView movieBgImage;
    TextView movieName;
    TextView movieStory;
    TextView movieGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        movieBgImage = findViewById(R.id.movieBgImage);
        movieName = findViewById(R.id.movieTitle);
        movieStory = findViewById(R.id.movieStory);
        movieGrade = findViewById(R.id.movieGrade);

        Intent intent = getIntent();
        String selectedName = intent.getStringExtra("moviename");

        if(intent.getExtras() != null) {
            // String selectedName = intent.getStringExtra("moviename");
            int selectedBgImage = intent.getIntExtra("moviebgimage", 0);
            String selectedStory = intent.getStringExtra("moviestory");
            String selectedGrade = intent.getStringExtra("moviegrade");

            movieName.setText(selectedName);
            movieBgImage.setImageResource(selectedBgImage);
            movieStory.setText(selectedStory);
            movieGrade.setText(selectedGrade);

        }

        button1 = (Button) findViewById(R.id.gobackbutton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = getIntent().getStringExtra("username");
                Intent intent = new Intent(MovieActivity.this, MainScreen.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.reservation_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieActivity.this, MovieReservation.class);
                intent.putExtra("selectedMovieName",selectedName);
                startActivity(intent);
            }
        });
    }
}