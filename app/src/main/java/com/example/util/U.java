package com.example.util;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.bitmap.BitmapGlobalConfig;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类包含 网络请求和 图片下载工具
 */
public class U {
    /**
     * 网络访问工具
     */
    private static HttpUtils httpUtils;


    /**
     * 获取网络请求工具
     */
    public static HttpUtils getHttpUtils() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
            httpUtils.configRequestThreadPoolSize(5);
            httpUtils.configRequestRetryCount(5);
            httpUtils.configTimeout(5000);
            httpUtils.configDefaultHttpCacheExpiry(1000);
        }
        return httpUtils;
    }


    /***
     * 图片获取
     */
    private static BitmapUtils bitmapUtils;

    public static BitmapUtils getBitMapUtils(Context context) {
        if (bitmapUtils == null) {
            BitmapGlobalConfig bitmapGlobalConfig = BitmapGlobalConfig.getInstance(context, context.getCacheDir().getPath());
            bitmapGlobalConfig.setMemoryCacheEnabled(true);
            bitmapGlobalConfig.setDefaultReadTimeout(3000);
            bitmapGlobalConfig.setDiskCacheSize(50 * 1024 * 1024);
            bitmapGlobalConfig.setThreadPoolSize(5);
            bitmapGlobalConfig.setMemoryCacheSize(5 * 1024 * 1024);
            bitmapUtils = new BitmapUtils(context);
        }
        return bitmapUtils;
    }


    /***
       获取md5的字符
     */
    public static String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  获取系统的最新时间 转成成年月日时分秒的格式
     */
    public static String getDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = dateFormat.format(new Date());
        return datetime;
    }

    /**
     *
     * 保存图片到内存卡
     */
    public static boolean SaveBitmap(Bitmap bm, String path, String filename) {
        boolean issave = false;

        File f = new File(path, filename);
        if (f.exists()) {
            f.delete();
        }
        FileOutputStream out;
        try {
            out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
            issave = true;
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return issave;
    }



}
