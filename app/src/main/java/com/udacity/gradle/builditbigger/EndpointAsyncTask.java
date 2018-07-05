package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {

    //setup testing url for emulator
    private String testingUrl = "http://10.0.2.2:8080/_ah/api/";

    //listeners for PreExecute and PostExecute
    private OnTaskCompleted endListener;
    private OnTaskBegin startListener;

    private MyApi myApiService = null;


    //constructor with listeners
    EndpointAsyncTask(OnTaskBegin startListener, OnTaskCompleted endListener) {
        this.endListener = endListener;
        this.startListener = startListener;

    }





    @Override
    protected void onPreExecute() {
        //call listener on beginning
        startListener.onTaskBegin();
    }

    @Override
    protected String doInBackground(Void... params) {
        //check if ApiService is running
        //if not, build it
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)

                    .setRootUrl(testingUrl)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        //try to get the joke from ApiService
        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        //call Listener on the end
        endListener.onTaskCompleted(joke);

    }



    //listeners interfaces
    public interface OnTaskCompleted{
        void onTaskCompleted(String joke);
    }

    public interface OnTaskBegin{
        void onTaskBegin();
    }


}
