package com.ceCapstone;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyLocationListener implements LocationListener {

	private Context mContext;
	private Location globalLoc;
	private MapController mControl;

	public MyLocationListener(Context context, MapController controller) {
		mContext = context;
		mControl = controller;
	}

	public void onLocationChanged(Location loc) {

		double lat = loc.getLatitude();

		double lon = loc.getLongitude();

		GeoPoint p = new GeoPoint((int) (lat * 1E6), (int) (lon * 1E6));

		mControl.animateTo(p);
		
		Log.i("Rugers", "onLocChange");


	}

	public void onProviderDisabled(String provider) {

		Toast.makeText(mContext, "GPS Disabled", Toast.LENGTH_SHORT).show();

	}

	public void onProviderEnabled(String provider) {

		Toast.makeText(mContext, "Gps Enabled", Toast.LENGTH_SHORT).show();

	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

}
