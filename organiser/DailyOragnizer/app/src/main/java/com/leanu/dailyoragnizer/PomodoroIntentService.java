package com.leanu.dailyoragnizer;

import android.app.IntentService;
import android.content.Intent;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class PomodoroIntentService extends IntentService {
    public static final String CHECK_TIME = "com.leanu.dailyoragnizer.action.CHECK_TIME";
    public static final String START_TIMER = "com.leanu.dailyorganizer.action.START_TIMER";

    public static final String POMODORO_TIME = "com.leanu.dailyoragnizer.extra.POMODORO_TIME";


    public PomodoroIntentService() {
        super("PomodoroIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (START_TIMER.equals(action)) {
                final String pomodoro_time = intent.getStringExtra(POMODORO_TIME);
                handleActionStartTimer(pomodoro_time);
            } else if(CHECK_TIME.equals(action)){
                handleActionCheckTime();
            }

        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionStartTimer(String pomodoro_time) {
        // TODO: Start background countdown
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void handleActionCheckTime() {
        // TODO: Send back to activity current time left
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
