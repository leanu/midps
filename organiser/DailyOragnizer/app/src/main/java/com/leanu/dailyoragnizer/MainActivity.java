package com.leanu.dailyoragnizer;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private long pomodoro_time = 25 * 60 * 1000;//25 minutes in milliseconds
    private long rest_time = 5 * 60 * 1000; //5 minutes in milliseconds
    private boolean isPomodoroStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onStartPomodoro(View view){
        if(isPomodoroStarted) return; //actually I may try to remove button while pomodoro goes:)
        final TextView countdown_display= (TextView)findViewById(R.id.countdown_display);
        new CountDownTimer(pomodoro_time,1000){
            public void onTick(long millisUntilFinished){
                long minutes = millisUntilFinished/(60*1000);
                long seconds = (millisUntilFinished/1000) % 60;
                countdown_display.setText(String.format("%d:%02d",minutes, seconds));
            }
            public void onFinish() {
                countdown_display.setText("00:00");
            }
        }.start();
        isPomodoroStarted=true;
    }


}
