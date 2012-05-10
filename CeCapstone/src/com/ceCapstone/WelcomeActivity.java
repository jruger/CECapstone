package com.ceCapstone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class WelcomeActivity extends Activity {

	private String WelcomeLogTag = "Rugers-Welcome";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		Log.i(WelcomeLogTag, "In Welcome Activity");
		startTheMap();
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

	private void startTheMap() {
		Log.i(WelcomeLogTag, "In Start the Map");
		Intent intent = new Intent(WelcomeActivity.this,
				MapViewActivity.class);
		WelcomeActivity.this.startActivity(intent);
	}

}
