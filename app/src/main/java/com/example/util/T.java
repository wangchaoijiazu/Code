package com.example.util;

import android.widget.Toast;

import com.example.App;


/**
 * Created by Administrator on 2015-08-28.
 */
public class T {

    /**
     * 是否打开谈词功能
     */
    public static boolean is_show = true;

    public static void showShort(String msg) {

        if (is_show) {
            Toast.makeText(App.getApp(), msg, Toast.LENGTH_SHORT).show();
            L.e(msg);
        }

    }

    public static void showShort(int msgId) {

        if (is_show) {
            Toast.makeText(App.getApp(), msgId, Toast.LENGTH_SHORT).show();

        }

    }

    public static void showLong(String msg) {

        if (is_show) {
            Toast.makeText(App.getApp(), msg, Toast.LENGTH_LONG).show();
            L.e(msg);
        }

    }

    public static void showLong(int msgId) {

        if (is_show) {
            Toast.makeText(App.getApp(), msgId, Toast.LENGTH_LONG).show();
        }

    }


    public static void Debugshow(String msg) {
        if (is_show) {
            Toast.makeText(App.getApp(), msg, Toast.LENGTH_LONG).show();
            L.e(msg);
        }
    }


}
