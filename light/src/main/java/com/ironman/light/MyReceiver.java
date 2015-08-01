package com.ironman.light;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.util.Log;

import java.security.Key;

/**
 * Created by ironman.li on 2015/8/1.
 */
public class MyReceiver extends BroadcastReceiver {
    public static final String File_Name = "m_light_time";
    public static final String KEY_TIME = "keyTime";
    public static final String KEY_COUNT = "keyCount";
    public static final long DEFAULT_GAP_TIME = 1000;
    private boolean isLight = false;
    private String Tag = "fffffffffffff";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("receiver", intent.getAction());
        SharedPreferences preferences = context.getSharedPreferences(File_Name, Context.MODE_PRIVATE);
        int count  = preferences.getInt(KEY_COUNT, 0);
        long preTime = preferences.getLong(KEY_TIME, 0);
        long now  = System.currentTimeMillis();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(KEY_TIME, now);
        editor.apply();
        Log.e(Tag, preTime + "");
        if(isLight){
            switchLight(false, context);
        }else{
            Log.e("receiver-count", count + "");
            Log.e("receiver-time", now - preTime + "");
            if(now - preTime <= DEFAULT_GAP_TIME){
                if(++count == 2){
                    switchLight(true, context);
                    editor.putInt(KEY_COUNT, 0);
                }else{
                    editor.putInt(KEY_COUNT,count);
                }
            }else {
                editor.putInt(KEY_COUNT, 0);
            }
            editor.commit();
        }
    }

    private void switchLight(boolean isTurnOn, Context context){
        Log.e("switch-light", isTurnOn?"true":"false");
        Log.e("light-status", isLight?"true":"false");
        if(context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
            Camera camera = Camera.open();
            if(isTurnOn){
                Camera.Parameters parameters = camera.getParameters();
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                camera.startPreview();
                isLight = true;
            }else{
                camera.stopPreview();
                camera.release();
                isLight = false;
            }
        }

    }
}
