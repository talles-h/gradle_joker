package com.udacity.gradle.testing;

import android.content.Intent;
import android.support.test.runner.AndroidJUnit4;

import com.example.jokedisplayer.JokeActivity;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class EchoAndroidTest {

    private String mJoke = null;

    @Test
    public void verifyJokeResponse() {
        final CountDownLatch signal = new CountDownLatch(1);
        new EndpointsAsyncTask().execute(new EndpointsAsyncTask.EndpointsTaskCallback() {
            @Override
            public void onResult(String joke) {
                mJoke = joke;
                signal.countDown();
            }
        });

        try {
            signal.await(10, TimeUnit.SECONDS);
            assertNotNull("Error: Joke is null!", mJoke);
            assertFalse("Error: Joke is empty!", mJoke.isEmpty());

        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }

    }
}