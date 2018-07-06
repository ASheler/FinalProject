package com.glaserproject.jokedisplaylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



/*This class is default class for Show Joke library
* You have to pass intent extra with String
* and key 'joke key' into activity on start to create it
*
* */



public class ShowJokeActivity extends AppCompatActivity {


    TextView mainTextView;
    String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        //check if intent gets data
        if (getIntent() == null){
            finish();
        }
        //hide Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //check if message is null, if not, set dummy string
        if (!getIntent().hasExtra("joke key")){
            joke = getString(R.string.no_joke_message);
        } else {
            //set joke String from Intent
            joke = getIntent().getStringExtra("joke key");
        }

        //set joke to TextView
        mainTextView = findViewById(R.id.mainTextView);
        mainTextView.setText(joke);

    }
}
