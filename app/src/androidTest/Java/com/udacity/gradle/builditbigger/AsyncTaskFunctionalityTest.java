package com.udacity.gradle.builditbigger;

import android.test.ActivityUnitTestCase;
import android.util.Log;


public class AsyncTaskFunctionalityTest extends ActivityUnitTestCase<MainActivity> implements
        EndpointAsyncTask.OnTaskCompleted,
        EndpointAsyncTask.OnTaskBegin {

    private static final String LOG_TAG = "Async Task Test";

    public AsyncTaskFunctionalityTest() {
        super(MainActivity.class);
    }

    public void testVerifyEmptyString (){
        Log.v(LOG_TAG, "Running Async Task test");
        String result = null;

        EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(this, this);
        endpointAsyncTask.execute();
        try {
            result = endpointAsyncTask.get();
            Log.d(LOG_TAG, "Retrieved string: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }

    @Override
    public void onTaskCompleted(String joke) {

    }

    @Override
    public void onTaskBegin() {

    }
}
