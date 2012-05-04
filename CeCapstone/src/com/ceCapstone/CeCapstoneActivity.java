package com.ceCapstone;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import android.os.Bundle;

public class CeCapstoneActivity extends MapActivity {
    
	//Required by google maps must be overridden
	@Override
	protected boolean isRouteDisplayed(){
		return false;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //creates map view by calling Main.xml mapview id
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
    }
    
}