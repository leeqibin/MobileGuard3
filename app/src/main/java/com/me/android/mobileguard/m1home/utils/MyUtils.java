package com.me.android.mobileguard.m1home.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by 10255 on 2017/9/21.
 */

public class MyUtils {
    public static String getVersion(Context context) {
        PackageManager packageManger = context.getPackageManager();
        try{
            PackageInfo packageInfo = packageManger.getPackageInfo(context.getPackageName(),0);
                        return packageInfo.versionName;
        }catch (PackageManager.NameNotFoundException e){
                       e.printStackTrace();
                       return "";
        }
    }

}
