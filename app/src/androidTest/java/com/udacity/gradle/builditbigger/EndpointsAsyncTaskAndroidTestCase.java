package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.InstrumentationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Project: Build-It-Bigger
 * Package: com.udacity.gradle.builditbigger
 * Created by Simone Masini on 19/10/2015 at 23.54.
 */
public class EndpointsAsyncTaskAndroidTestCase extends InstrumentationTestCase {

    public void testVerifyAsyncTaskResponse() throws Throwable {
        final Context context = getInstrumentation().getTargetContext();
        final CountDownLatch signal = new CountDownLatch(1);

        final EndpointsAsyncTask task = new EndpointsAsyncTask(context){
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                assertFalse(result.equals(""));
                signal.countDown();
            }
        };

        runTestOnUiThread(new Runnable() {
            public void run() {
                task.execute();
            }
        });

        /* The testing thread will wait here until the UI thread releases it
         * above with the countDown() or 30 seconds passes and it times out.
         */
        signal.await(30, TimeUnit.SECONDS);
    }
}
