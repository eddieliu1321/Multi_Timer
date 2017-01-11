package com.example.eddie.multi_timer;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class EditTimer extends AppCompatActivity {


    TextView textViewTime;
    NumberPicker hours, mins, secs;
    SecondsTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_timer);

        Button btnSave = (Button) findViewById(R.id.btnSave);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);

        hours = (NumberPicker) findViewById(R.id.hourscroll);
        mins = (NumberPicker) findViewById(R.id.minsscroll);
        secs = (NumberPicker) findViewById(R.id.secscroll);

        /*String[] dispHrs = {"00","01","02","03"};
        String[] dispMins = new String[60];
        String[] dispSecs = new String[60];
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                dispMins[i] = "0" + i;
                dispSecs[i] = "0" + i;
            }
            else {
                dispMins[i] = Integer.toString(i);
                dispSecs[i] = Integer.toString(i);
            }
        }

        hours.setDisplayedValues(dispHrs);
        mins.setDisplayedValues(dispMins);
        secs.setDisplayedValues(dispSecs); */

        hours.setMinValue(0);
        hours.setMaxValue(10);
        mins.setMinValue(0);
        mins.setMaxValue(59);
        secs.setMinValue(0);
        secs.setMaxValue(59);

        hours.setWrapSelectorWheel(true);
        mins.setWrapSelectorWheel(true);
        secs.setWrapSelectorWheel(true);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int timeInSecs = hours.getValue() * 3600 + mins.getValue() * 60 + secs.getValue();
                timer = new SecondsTimer(timeInSecs, 1, textViewTime);
                timer.start();
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });

    }
}