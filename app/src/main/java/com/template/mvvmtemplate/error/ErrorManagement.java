package com.template.mvvmtemplate.error;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.template.mvvmtemplate.BuildConfig;

/**
 * Created by diegonovati on 18/04/2018.
 */

/**
 * Class that manages the errors raised by the App. On the debug version the errors are displayed to
 * the user, on the production version the error are sent to Crashlytics.
 */
public final class ErrorManagement {

    private static final String TAG = "ErrorManagement";

    public static void logError(Context context, Throwable ex) {
        logError(context, ex, true);
    }

    public static void logError(Context context, Throwable ex, boolean showMessage) {
        Log.e(TAG, "logError: ", ex);

        try {
            if (showMessage && BuildConfig.displayErrorMessage) {
                Toast.makeText(context.getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                return;
            }
            // Add here the code to send the error to Crashlytics
        } catch (Exception e) {
            Log.e(TAG, "******** logError: ", e);
        }
    }
}
