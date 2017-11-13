package cn.edu.gdmec.android.mobileguard.m4appmanager.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import cn.edu.gdmec.android.mobileguard.m4appmanager.entity.AppInfo;

/**
 * Created by Administrator on 2017/11/7.
 */

public class EngineUtils {
    public static void shareApplication(Context context, AppInfo appInfo){
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"推荐您使用一款软件，名称叫："+appInfo.appName+"下载地址：https://play.google.com/store/apps/details?id="+appInfo.packageName);
        context.startActivity(intent);
    }
    public static void startApplication(Context context, AppInfo appInfo){
        PackageManager pm = context.getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(appInfo.packageName);
        if(intent != null){
            context.startActivity(intent);
        }else{
            Toast.makeText(context,"该应用没有启动界面", Toast.LENGTH_SHORT).show();
        }
    }
    public static void SettingAppDetail(Context context, AppInfo appInfo){
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("package:"+appInfo.packageName));
        context.startActivity(intent);
    }
    public static void uninstallApplication(Context context, AppInfo appInfo){
        if(appInfo.isUserApp){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:"+appInfo.packageName));
            context.startActivity(intent);
        }else{
            Toast.makeText(context,"系统应用无法卸载", Toast.LENGTH_LONG).show();
        }
    }
    public static void AboutSign(Context context, AppInfo appInfo) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage("Version："+appInfo.version+
                "\nInstall time："+appInfo.InstallTime+
                "\nCertificate issuer："+appInfo.signature+
                "\n\nPermissions："+appInfo.permissions);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
    public static void ActApp(Context context,AppInfo appInfo){
                try {
                       PackageManager pm = context.getPackageManager();
                       PackageInfo packInfo = pm.getPackageInfo(appInfo.packageName, 0);
                               PackageInfo packinfo2 = pm.getPackageInfo(appInfo.packageName, PackageManager.GET_ACTIVITIES);
                       ActivityInfo[] act =packinfo2.activities;
                        List<ActivityInfo> a=new ArrayList<>();
                        if(act != null){
                                for(ActivityInfo str : act){
                                        a.add(str);
                                    }
                            }
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle(appInfo.appName);
                       String s = Pattern.compile("\\b([\\w\\W])\\b").matcher(a.toString().substring(1,a.toString().length()-1)).replaceAll(".");

                               builder.setMessage(s);
                        builder.show();
                    }catch (Exception e) {
                        e.printStackTrace();
                   }

                   }
}
