package com.ceCapstone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DepthChartActivity extends Activity {

	private String WelcomeLogTag = "Rugers Depth";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.depth);
		Log.i(WelcomeLogTag, "In Depth Chart Activty");
		initbuttons();
	}

	@Override
	protected void onStart() {
		super.onStart();
		// The activity is about to become visible.
	}

	@Override
	protected void onResume() {
		super.onResume();
		// The activity has become visible (it is now "resumed").
	}

	@Override
	protected void onPause() {
		super.onPause();
		// Another activity is taking focus (this activity is about to be
		// "paused").
	}

	@Override
	protected void onStop() {
		super.onStop();
		// The activity is no longer visible (it is now "stopped")
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// The activity is about to be destroyed.
	}

	private void initbuttons() {
		final Button button = (Button) findViewById(R.id.depthMap);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Log.i(WelcomeLogTag, "MapView Button Clicked");
				Intent intent = new Intent(DepthChartActivity.this,
						MapViewActivity.class);
				DepthChartActivity.this.startActivity(intent);
			}
		});
		
		final Button button2 = (Button) findViewById(R.id.depthCamera);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Log.i(WelcomeLogTag, "Camera Button Clicked");
				Intent intent = new Intent(DepthChartActivity.this,
						CameraActivity.class);
				DepthChartActivity.this.startActivity(intent);
			}
		});

	}
	
}
