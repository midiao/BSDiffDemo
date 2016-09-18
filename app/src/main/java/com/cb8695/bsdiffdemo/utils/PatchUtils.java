package com.cb8695.bsdiffdemo.utils;

/**
 * Created by cb8695 on 2016/8/3.
 */

public class PatchUtils {
    static {
        System.loadLibrary("patch");
    }
    public static native int patch(String oldApkPath, String newApkPath, String patchPath);
}
