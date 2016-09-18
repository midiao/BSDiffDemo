package com.cb8695.bsdiffdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cb8695.bsdiffdemo.utils.ApkUtils;
import com.cb8695.bsdiffdemo.utils.PatchUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String PATH = Environment.getExternalStorageDirectory() + File.separator;
    private static final String NEW_APK_PATH = PATH + "bsdiff.apk";
    private static final String PATCH_PATH = PATH + "bsdiff.patch";

    private Button mButtonPatch;
    private Button mButtonTest;
    private String oldApkPath;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oldApkPath = ApkUtils.getSourceApkPath(this, this.getPackageName());

        mButtonPatch = (Button) findViewById(R.id.bspatch);
        mButtonPatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int patchResult = PatchUtils.patch(oldApkPath, NEW_APK_PATH, PATCH_PATH);
                ApkUtils.installApk(MainActivity.this, NEW_APK_PATH);
            }
        });
        mButtonTest = (Button) findViewById(R.id.test);
        mButtonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "TEST 2", Toast.LENGTH_SHORT).show();
            }
        });
        Log.d(TAG, "oldApkPath = " + oldApkPath);
        Log.d(TAG, "path = " + Environment.getExternalStorageDirectory());
    }
}
