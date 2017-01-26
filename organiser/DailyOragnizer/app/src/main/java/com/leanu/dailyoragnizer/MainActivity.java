package com.leanu.dailyoragnizer;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private long pomodoro_time = 25 * 60 * 1000;//25 minutes in milliseconds
    private long rest_time = 5 * 60 * 1000; //5 minutes in milliseconds
    private boolean isPomodoroStarted = false;
    private int consecutive_pomodors = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onStartPomodoro(View view){
        if(isPomodoroStarted) return; //actually I may try to remove button while pomodoro goes:)
        final TextView countdown_display= (TextView)findViewById(R.id.countdown_display);
        final TextView app_status = (TextView)findViewById(R.id.appStatus);
        app_status.setText("Time to work");
        new CountDownTimer(pomodoro_time,1000){
            public void onTick(long millisUntilFinished){
                long minutes = millisUntilFinished/(60*1000);
                long seconds = (millisUntilFinished/1000) % 60;
                countdown_display.setText(String.format("%d:%02d",minutes, seconds));
            }
            public void onFinish() {
                notifyPomodoro();
                finishPomodoro();
            }
        }.start();
        isPomodoroStarted=true;
    }

    private void finishPomodoro(){
        //TODO store somewhere pomodoro(by tag/name)
        //TODO some notification
        isPomodoroStarted = false;
        consecutive_pomodors++;
        int m = 1;//multiplier
        if(consecutive_pomodors==4) {
            m = 4;
            consecutive_pomodors = 0;
        }
        final TextView countdown_display= (TextView)findViewById(R.id.countdown_display);
        final TextView app_status = (TextView)findViewById(R.id.appStatus);
        app_status.setText("Relax time!");
        new CountDownTimer(m*rest_time,1000){
            public void onTick(long millisUntilFinished){
                long minutes = millisUntilFinished/(60*1000);
                long seconds = (millisUntilFinished/1000) % 60;
                countdown_display.setText(String.format("%d:%02d",minutes, seconds));
            }
            public void onFinish() {
                countdown_display.setText("00:00");
                app_status.setText("Time to work");
            }
        }.start();

    }

    private void notifyPomodoro(){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.tomato)
                .setContentTitle("Pomodoro finished")
                .setContentText("Have a break")
                .setAutoCancel(true);
        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0,mBuilder.build());

    }


}
