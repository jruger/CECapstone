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

public class CeCapstoneGoogleMapsActivity extends MapActivity {

	// globals
	private MapView mapView;
	private MyLocationOverlay myLocOverlay;
	private MapController controller;
	private String LogCatTag = "Rugers";
	private MyLocationListener mlocListener;

	// Required by google maps must be overridden
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initializeMap();
		initializeMyLocation();
		initializeLocationManager();
		Log.i(LogCatTag, "In onCreate");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		mapView.setSaveEnabled(true);
		super.onSaveInstanceState(savedInstanceState);

	}

	protected void onStart() {
		super.onStart();
		// initializeMyLocation();
	}

	protected void onRestart() {
		super.onRestart();
	}

	protected void onResume() {
		super.onResume();
		/*
		 * initializeMap(); controller = mapView.getController();
		 * Log.i(LogCatTag, "In Resume"); if(controller == null){
		 * Log.e(LogCatTag, "Controller is null"); }else{
		 * controller.setZoom(17);
		 * controller.animateTo(myLocOverlay.getMyLocation()); }
		 */

	}

	protected void onPause() {
		super.onPause();
	}

	protected void onStop() {
		super.onStop();
	}

	protected void onDestroy() {
		super.onDestroy();
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
		LocationManager mlocManager =

		(LocationManager) getSystemService(Context.LOCATION_SERVICE);

		LocationListener mlocListener = new MyLocationListener(this, controller);

		mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				mlocListener);

	}

}