package com.dgmong.compass;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import org.apache.cordova.PluginResult;
import java.io.IOException;
import java.io.InputStream;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

//public class compass extends CordovaPlugin{
////public class compass extends CordovaPlugin implements SensorEventListener {
//
//	@Override
//	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException
//	{
//		callbackContext.success(action);
//		return true;
//	}
//}

public class compass extends CordovaPlugin implements SensorEventListener {
	// record the compass picture angle turned
    private float currentDegree = 0f;
    // device sensor manager
    private SensorManager mSensorManager;
    private Sensor msensor;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        mSensorManager = (SensorManager) cordova.getActivity().getSystemService(Context.SENSOR_SERVICE);
        msensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        mSensorManager.registerListener(this, msensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
    	currentDegree = Math.round(event.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }


	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException
	{
		callbackContext.success(action+" : "+currentDegree);
		return true;
	}
}