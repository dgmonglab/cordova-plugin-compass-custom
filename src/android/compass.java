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
    private Sensor gsensor;

    float[] rotation = new float[9];
    float[] result_data = new float[3];
    float[] mag_data = new float[3]; //센서데이터를 저장할 배열 생성
    float[] acc_data = new float[3]; //가속도데이터값이 들어갈 배열. 각도를 뽑으려면 가속도와 지자계의 값이 있어야함.



    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        mSensorManager = (SensorManager) cordova.getActivity().getSystemService(Context.SENSOR_SERVICE);
        msensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        gsensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSensorManager.registerListener(this, msensor, SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this, gsensor, SensorManager.SENSOR_DELAY_GAME);
    }
    float[] mGravity;
    float[] mGeomagnetic
    @Override
    public void onSensorChanged(SensorEvent event) {
    	if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
    		   mGravity = event.values;
    		  if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
    		   mGeomagnetic = event.values;
    		  if (mGravity != null && mGeomagnetic != null) {
    		   float R[] = new float[9];
    		   float I[] = new float[9];
    		   /*Computes the inclination matrix I as well as the rotation matrix R transforming a vector from the device coordinate
    		    *  system to the world's coordinate system which is defined as a direct orthonormal basis*/
    		   boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);
    		   if (success) {
    		    float orientation[] = new float[3];
    		    /*Computes the device's orientation based on the rotation matrix*/
    		    SensorManager.getOrientation(R, orientation);
    		    currentDegree = orientation[0]; // orientation contains: azimut, pitch and roll
    		   }
    		  }

//    	if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)   //센서가 읽어들인 값이 마그네틱필드일때
//    		mag_data = event.values.clone();    //데이터를 모두 mag_data 배열에 저장
//    	if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) // 가속도센서값일때
//    		acc_data = event.values.clone();  //마찬가지
//    	if (mag_data != null && acc_data != null) { //널체크
//    		float r[] = new float[9];
//            float i[] = new float[9];
//	       boolean success = SensorManager.getRotationMatrix(r, i, acc_data, mag_data); //회전메트릭스 연산
//	       if(success){
//	    	   	float orientation[] = new float[3];
//	            SensorManager.getOrientation(r, orientation);
////	            currentDegree = orientation[0] * 360 / (2* 3.15159f); // orientation contains: azimut, pitch and roll
//
//	            currentDegree = (float)Math.toDegrees(orientation[0]); // 방향값을 각도로 변환
//
//	            if(currentDegree < 0) currentDegree += 360; //0보다 작을경우 360을더해줌
//	       }
//    	}
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