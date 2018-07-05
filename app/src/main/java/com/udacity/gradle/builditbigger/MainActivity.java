package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.glaserproject.jokedisplaylibrary.ShowJokeActivity;


public class MainActivity extends AppCompatActivity implements
        EndpointAsyncTask.OnTaskCompleted,
        EndpointAsyncTask.OnTaskBegin{


    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find views by ID
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        //start asyncTask to fetch joke
        new EndpointAsyncTask(this, this).execute();

    }

    @Override
    public void onTaskCompleted(String joke) {

        //start acivity from JokeDisplayLibrary
        Intent intent = new Intent(this, ShowJokeActivity.class);
        intent.putExtra("joke key", joke);
        startActivity(intent);

        //hide loading indicator and show button
        progressBar.setVisibility(View.GONE);
        button.setVisibility(View.VISIBLE);
    }


    @Override
    public void onTaskBegin() {
        //edit UI to show loading and hide button to prevent more clicks
        progressBar.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
    }
}
