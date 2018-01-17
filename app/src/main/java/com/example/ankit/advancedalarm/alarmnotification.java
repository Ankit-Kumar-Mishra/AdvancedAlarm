package com.example.ankit.advancedalarm;

/**
 * Created by ankit on 17/1/18.
 */

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;

import android.widget.TextView;
import android.net.Uri;
import android.media.Ringtone;
import android.media.RingtoneManager;

public class alarmnotification extends AppCompatActivity {

    TextView Motive;
    Button snoozeButton;
    Button dismissButton;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarmnotification);
        Motive =(TextView)findViewById(R.id.Motive);
        Motive.setText(getIntent().getStringExtra("MOTIVE"));
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), uri);
        ringtone.play();

    }
}
