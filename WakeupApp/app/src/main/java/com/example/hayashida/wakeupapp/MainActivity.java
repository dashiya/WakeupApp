package com.example.hayashida.wakeupapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

public class MainActivity extends AppCompatActivity {

    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    PendingIntent pendingIntent = getPendingIntent();
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(alarmTimeMillis, null), pendingIntent);
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTimeMillis, pendingIntent);
    } else {
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTimeMillis, pendingIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
