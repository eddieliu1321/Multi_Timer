package com.example.eddie.multi_timer;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * The SecondsTimer counts down by seconds and resets the input Textview accordingly
 * Created by Evan on 12/19/2016.
 */

public class SecondsTimer extends CountDownTimer {

    private TextView view;
    private long timeLeft;

    public SecondsTimer (int seconds, int interval, TextView text) {
        super(seconds * 1000, interval * 1000);
        view = text;
        timeLeft = seconds;
    }

    public SecondsTimer (int seconds, int interval, TextView text, Button start, Button stop) {
        super(seconds * 1000, interval * 1000);
        view = text;
        timeLeft = seconds;
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }


    public void onFinish()  {
        view.setText("Completed.");
    }

    public void onTick (long millis) {
        timeLeft = millis;
        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millis)));
        view.setText(hms);
    }

}
