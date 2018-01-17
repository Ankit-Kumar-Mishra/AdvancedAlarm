package com.example.ankit.advancedalarm;

/**
 * Created by ankit on 17/1/18.
 */
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.ActionBarActivity;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.app.AlarmManager;
        import android.app.PendingIntent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.TextView;
        import android.view.View;
        import android.widget.TimePicker;
        import java.util.Calendar;
        import  java.util.ArrayList;
        import android.content.Intent;
        import android.widget.EditText;
        import android.widget.Toast;

/**
 * Created by Ankit Mishra on 05-10-2017.
 */

public class activity_3 extends AppCompatActivity {
    Button setButton;
    CheckBox checkBox;
    Button cancelButton;
    EditText MotiveText;
    EditText snoozeText;
    public Calendar calendar;
    public Calendar curCalendar;
    Intent AlarmIntent;
    AlarmManager AlMgr;
    PendingIntent sender;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        int hour=this.getIntent().getIntExtra("hour",0);
        int minutes=this.getIntent().getIntExtra("minutes",0);
        calendar= Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minutes);
        setButton=(Button)findViewById(R.id.setButton);
        cancelButton=(Button)findViewById(R.id.cancelButton);
        MotiveText=(EditText)findViewById(R.id.MotiveText);
        snoozeText=(EditText)findViewById(R.id.snoozeText);
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
                AlMgr = (AlarmManager) getSystemService(ALARM_SERVICE);
                int _id = (int) System.currentTimeMillis();
                AlarmIntent.putExtra("REQUEST CODE", _id);
                AlarmIntent.putExtra("IS VIBRATE",checkBox.isChecked());
                AlarmIntent.putExtra("MOTIVE", MotiveText.getText().toString());
                AlarmIntent.putExtra("SNOOZE",Integer.parseInt(snoozeText.getText().toString()));
                sender = PendingIntent.getBroadcast(getApplicationContext(), _id, AlarmIntent, 0);
                curCalendar = Calendar.getInstance();
                curCalendar.set(Calendar.SECOND, 0);
                curCalendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                if (calendar.getTimeInMillis() <= curCalendar.getTimeInMillis()) {
                    calendar.add(Calendar.HOUR, 24);
                }
                AlMgr.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
                String CalendarHourStr;
                String date = (String) calendar.getTime().toString();
                Toast.makeText(getApplicationContext(), "elarm is set for" + date, Toast.LENGTH_LONG).show();

            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

}

