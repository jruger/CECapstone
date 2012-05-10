package com.ceCapstone;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class MapViewActivity extends MapActivity {

	// globals
	private MapView mapView;
	private MyLocationOverlay myLocOverlay;
	private MapController controller;
	private String MapActivityLogTag = "Rugers Map Activity";
	private MyLocationListener mlocListener;
	private LocationManager mlocManager;

	// Required by google maps must be overridden
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapview);
		initializeMap();
		initializeMyLocation();
		initializeLocationManager();
		Log.i(MapActivityLogTag, "In onCreate");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		Log.i(MapActivityLogTag, "saved bundle");
		mapView.setSaveEnabled(true);
		super.onSaveInstanceState(savedInstanceState);

	}

	protected void onStart() {
		super.onStart();
		Log.i(MapActivityLogTag, "onRestart");
		// initializeMyLocation();
	}

	protected void onRestart() {
		Log.i(MapActivityLogTag, "onRestart");
		super.onRestart();
	}

	protected void onResume() {
		Log.i(MapActivityLogTag, "onResume");
		super.onResume();
		mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				mlocListener);
		myLocOverlay.enableMyLocation();
	}

	protected void onPause() {
		super.onPause();
		Log.i(MapActivityLogTag, "onPause");
		mlocManager.removeUpdates(mlocListener);
		myLocOverlay.disableMyLocation();
	}

	protected void onStop() {
		Log.i(MapActivityLogTag, "onStop");
		super.onStop();
	}

	protected void onDestroy() { 
		super.onDestroy();
		Log.i(MapActivityLogTag, "onDestroy");
		mlocManager.removeUpdates(mlocListener);
		myLocOverlay.disableMyLocation();

	}

	private void initializeMap() {
		mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(true);
		mapView.setSaveEnabled(true);
	}

	private void initializeMyLocation() {
		myLocOverlay = new MyLocationOverlay(this, mapView);
		myLocOverlay.enableMyLocation();
		mapView.getOverlays().add(myLocOverlay);
		controller = mapView.getController();
		myLocOverlay.runOnFirstFix(new Runnable() {
			public void run() {
				controller.setZoom(17);
				controller.animateTo(myLocOverlay.getMyLocation());
			}
		});

	}

	private void initializeLocationManager() {
		mlocManager =

		(LocationManager) getSystemService(Context.LOCATION_SERVICE);

		mlocListener = new MyLocationListener(this, controller);

		mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				mlocListener);

	}

}