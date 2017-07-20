package com.uhf.handsetapp.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/20 12:07
 * Good Luck
 */

public class ToastUtils {
    // TODO: UIThread
    private static Handler handler = new Handler(Looper.getMainLooper());
    private static Toast toast = null;
    // TODO: lock
    private static Object synObj = new Object();

    public static void showMessage(final Context act, final String msg) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (synObj) {
                            if (toast != null) {
                                toast.cancel();
                                toast.setText(msg);
                                toast.setDuration(Toast.LENGTH_SHORT);
                            } else {
                                toast = Toast.makeText(act, msg, Toast.LENGTH_SHORT);
                            }
                            toast.show();
                        }
                    }
                });
            }
        }).start();
    }

    /**
     * close current Toast
     */
    public static void cancelCurrentToast() {
        if (toast != null) {
            toast.cancel();
        }
    }
}
