package com.example.eddie.multi_timer;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
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

    /**
     * Constructor for a seconds timer that binds a timer to the TextView parameter text
     * @param seconds : Desired time in seconds
     * @param interval : Interval at which the timer counts down
     * @param text : The TextView to which the timer is to be bound
     */
    public SecondsTimer (int seconds, int interval, TextView text) {
        super(seconds * 1000, interval * 1000);
        view = text;
        timeLeft = seconds;
    }

    /**
     * Constructor that binds a seconds timer to TextView, start and stop buttons. Time must be
     * predefined in this case.
     * @param seconds : Desired time in seconds
     * @param interval : Interval at which the timer counts down
     * @param text : The TextView to which the timer is to be bound
     * @param start : The start Button to which the timer is to be bound
     * @param stop : The stop Button to which the timer is to be bound
     */
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


    /**
     * Sets the bound TextView to "Completed" upon timer conclusion
     */
    public void onFinish()  {
        view.setText("Completed.");
    }

    /**
     * This method modifies the TextView at every tick of the timer.
     * @param millis: Time until timer completion in milliseconds
     * BUG: the first "time" displayed on the TextView is 1 second after the set time.
     */
    public void onTick (long millis) {
        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millis)));
        view.setText(hms);
    }

}
