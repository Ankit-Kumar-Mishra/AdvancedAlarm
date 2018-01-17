package com.example.ankit.advancedalarm;

/**
 * Created by ankit on 17/1/18.
 */

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.TimePicker;
import java.util.Calendar;
import  java.util.ArrayList;
import android.content.Intent;
/**
 * Created by Ankit Mishra on 03-10-2017.
 */

public class activity_2 extends AppCompatActivity {

    TimePicker timePicker;
    Button proceedButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        proceedButton=(Button)findViewById(R.id.proceedButton);
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle =new Bundle();
                Intent intent1=new Intent(getApplicationContext(),activity_3.class);
                int hour=timePicker.getCurrentHour();
                int minutes=timePicker.getCurrentMinute();
                bundle.putInt("hour",hour);
                bundle.putInt("minutes",minutes);
                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        });
    }

}
