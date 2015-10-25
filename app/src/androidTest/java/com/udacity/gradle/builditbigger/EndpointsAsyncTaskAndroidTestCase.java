package com.udacity.gradle.builditbigger;

import android.test.InstrumentationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Project: Build-It-Bigger
 * Package: com.udacity.gradle.builditbigger
 * Created by Simone Masini on 19/10/2015 at 23.54.
 */
public class EndpointsAsyncTaskAndroidTestCase extends InstrumentationTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testVerifyAsyncTaskResponse() throws Throwable {

        final CountDownLatch signal = new CountDownLatch(1);

        final EndpointsAsyncTask task = new EndpointsAsyncTask(null, new EndpointsAsyncTask.Callback() {
            @Override
            public void onResult(String string) {
                assertNotNull(string);
                assertFalse(string.equals(""));
                signal.countDown();
            }
        });

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
