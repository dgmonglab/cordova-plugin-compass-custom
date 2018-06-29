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

public class compass extends CordovaPlugin{
//public class compass extends CordovaPlugin implements SensorEventListener {

	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException
	{
//		PluginResult pr = new PluginResult(PluginResult.Status.OK, azimuth+"");
//		callbackContext.sendPluginResult(pr);
		callbackContext.success(action);
		return true;
	}
//    private static final String TAG = "Compass";
//	public Context context = null;
//	private static final boolean IS_AT_LEAST_LOLLIPOP = Build.VERSION.SDK_INT >= 21;
//
//	public interface CompassListener {
//        void onNewAzimuth(float azimuth);
//    }
//
//    private CompassListener listener;
//
//    private SensorManager sensorManager;
//    private Sensor gsensor;
//    private Sensor msensor;
//
//    private float[] mGravity = new float[3];
//    private float[] mGeomagnetic = new float[3];
//    private float[] R = new float[9];
//    private float[] I = new float[9];
//
//    private float azimuth;
//    private float azimuthFix;
//
//
//
//
//    public compass(Context context) {
//        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
//        gsensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        msensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
//
//        sensorManager.registerListener(this, gsensor,
//                SensorManager.SENSOR_DELAY_GAME);
//        sensorManager.registerListener(this, msensor,
//                SensorManager.SENSOR_DELAY_GAME);
//    }
//
//    public void start() {
//
//    }
//
//    public void stop() {
//        sensorManager.unregisterListener(this);
//    }
//
//    public void setAzimuthFix(float fix) {
//        azimuthFix = fix;
//    }
//
//    public void resetAzimuthFix() {
//        setAzimuthFix(0);
//    }
//
//    public void setListener(CompassListener l) {
//        listener = l;
//    }
//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//        final float alpha = 0.97f;
//
//        synchronized (this) {
//            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
//
//                mGravity[0] = alpha * mGravity[0] + (1 - alpha)
//                        * event.values[0];
//                mGravity[1] = alpha * mGravity[1] + (1 - alpha)
//                        * event.values[1];
//                mGravity[2] = alpha * mGravity[2] + (1 - alpha)
//                        * event.values[2];
//
//                // mGravity = event.values;
//
//                // Log.e(TAG, Float.toString(mGravity[0]));
//            }
//
//            if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
//                // mGeomagnetic = event.values;
//
//                mGeomagnetic[0] = alpha * mGeomagnetic[0] + (1 - alpha)
//                        * event.values[0];
//                mGeomagnetic[1] = alpha * mGeomagnetic[1] + (1 - alpha)
//                        * event.values[1];
//                mGeomagnetic[2] = alpha * mGeomagnetic[2] + (1 - alpha)
//                        * event.values[2];
//                // Log.e(TAG, Float.toString(event.values[0]));
//
//            }
//
//            boolean success = SensorManager.getRotationMatrix(R, I, mGravity,
//                    mGeomagnetic);
//            if (success) {
//                float orientation[] = new float[3];
//                SensorManager.getOrientation(R, orientation);
//                // Log.d(TAG, "azimuth (rad): " + azimuth);
//                azimuth = (float) Math.toDegrees(orientation[0]); // orientation
//                azimuth = (azimuth + azimuthFix + 360) % 360;
//                // Log.d(TAG, "azimuth (deg): " + azimuth);
//                if (listener != null) {
//                    listener.onNewAzimuth(azimuth);
//                }
//            }
//        }
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//    }
//
//
//
//	@Override
//	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException
//	{
////		PluginResult pr = new PluginResult(PluginResult.Status.OK, azimuth+"");
////		callbackContext.sendPluginResult(pr);
//		callbackContext.success("asdasdasdasdasd");
//		return true;
//	}
//

//	public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) throws JSONException{
//		PluginResult result;
//		//This is important if we're using Cordova without using Cordova, but we have the geolocation plugin installed
//		if(context != null) {
//			for (int r : grantResults) {
//				if (r == PackageManager.PERMISSION_DENIED) {
//					LOG.d(TAG, "Permission Denied!");
//					result = new PluginResult(PluginResult.Status.ILLEGAL_ACCESS_EXCEPTION);
//					context.sendPluginResult(result);
//					return;
//				}
//
//			}
//			result = new PluginResult(PluginResult.Status.OK);
//			context.sendPluginResult(result);
//		}
//	}
}
