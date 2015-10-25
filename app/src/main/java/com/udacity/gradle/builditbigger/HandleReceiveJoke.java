package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.androidjokes.JokerActivity;

/**
 * Project: Build-It-Bigger
 * Package: com.udacity.gradle.builditbigger
 * Created by Simone Masini on 25/10/2015 at 11.47.
 */
public class HandleReceiveJoke {

    public void loadJoke(final Context context){
        new EndpointsAsyncTask(context, new EndpointsAsyncTask.Callback() {
            @Override
            public void onResult(String string) {
                Log.d("RESULT", string);
                Intent intent = new Intent(context, JokerActivity.class);
                intent.putExtra(context.getString(R.string.extra_joke), string);
                context.startActivity(intent);
            }
        }).execute();
    }
}
