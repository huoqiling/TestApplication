package com.example.testing.myapplication.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.example.testing.myapplication.util.LogUtil;

public class TestIntentService extends IntentService {
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.testing.myapplication.service.action.FOO";
    private static final String ACTION_BAZ = "com.example.testing.myapplication.service.action.BAZ";


    public TestIntentService() {
        super("TestIntentService");
    }

    @Override public void onCreate() {
        super.onCreate();
        LogUtil.d("onCreate");
    }

    @Override public void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context) {
        Intent intent = new Intent(context, TestIntentService.class);
        intent.setAction(ACTION_FOO);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context) {
        Intent intent = new Intent(context, TestIntentService.class);
        intent.setAction(ACTION_BAZ);
        context.startService(intent);
    }

    @Override protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                handleActionFoo();
            } else if (ACTION_BAZ.equals(action)) {
                handleActionBaz();
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo() {
        LogUtil.d("handleActionFoo");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz() {
        LogUtil.d("handleActionBaz");
    }
}
