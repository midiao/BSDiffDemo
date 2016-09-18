package com.cb8695.bsdiffdemo.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by cb8695 on 2016/8/3.
 */

public class ApkUtils {
    public static String getSourceApkPath(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(packageName, 0);
            return appInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void installApk(Context context, String apkPath){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://" + apkPath), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }
}
