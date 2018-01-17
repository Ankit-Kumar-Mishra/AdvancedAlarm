package com.example.ankit.advancedalarm;

/**
 * Created by ankit on 17/1/18.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver
{
    public static final String ALARM_ALERT_ACTION = "com.android.alarmclock.ALARM_ALERT";
    public static final String ALARM_INTENT_EXTRA = "intent.extra.alarm";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Intent in = new Intent(Intent.ACTION_MAIN);
        in.setClass(context, alarmnotification.class);

        in.putExtra("REQUEST CODE", intent.getIntExtra("REQUEST CODE", 0));
        in.putExtra("MOTIVE",intent.getStringExtra("MOTIVE"));
        in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(in);
    }
}
