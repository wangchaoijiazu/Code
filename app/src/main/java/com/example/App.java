package com.example;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;


import com.example.util.L;

import java.util.ArrayList;
import java.util.List;

/**
 * Application
 */
public class App extends Application {

    /**
     * App实例
     */
    public static App app;



    private List<Activity> mOpenActivitesList = new ArrayList<Activity>();

    @Override
    public void onCreate() {
        super.onCreate();

        if (app == null) {
            app = this;
        }
        //设置调试模式
        L.isDebug=true;


    }

    /**
     * 关闭所有的 activity
     */
    public void closeAllActivites() {
        if (mOpenActivitesList.size() > 0) {
            for (int i = 0; i < mOpenActivitesList.size(); i++) {
                if (null != mOpenActivitesList.get(i)) {
                    mOpenActivitesList.get(i).finish();
                }
            }
        }
        System.exit(0);
    }

    public void addActivity(Activity activity) {
        mOpenActivitesList.add(activity);
    }

    public void removeActivity(Activity activity) {
        mOpenActivitesList.remove(activity);
    }

    /**
     * 获取 applicationContext对象
     * @return
     */
    public static App getApp(){
        return app;
    }

    /**
     * 判断activity是否被回收
     * @param name
     * @return
     */
    public boolean isHavaActivity(String name){
        try {
            for (Activity ac : mOpenActivitesList) {
                if (ac != null && ac.getClass().getSimpleName().equals(name))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *  回退到主界面并且显示第一个fargment
     *
     */
    public void backToIndexActivity( ) {
        try {
            for (Activity ac : mOpenActivitesList) {

                if (ac != null && !ac.getClass().getSimpleName().equals("MainActivity"))
                    ac.finish();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 关闭每一个list内的activity
    public void exit() {
        try {
            for (Activity activity : mOpenActivitesList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }




}
