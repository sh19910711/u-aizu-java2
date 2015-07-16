package com.mamezou.android.bmicalc3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {
	private int height = 0;
	private String gender = "";
	private double sw = 0;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.result);
		TextView swValue = (TextView) findViewById(R.id.label_swvalue);
		TextView status = (TextView) findViewById(R.id.label_status);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			height = extras.getInt("HEIGHT");
			gender = extras.getString("GENDER");
			if (gender.equals("M")) {
				sw = height * height * 22.0 / 10000;
			} else {
				sw = height * height * 21.0 / 10000;
			}
			swValue.setText(String.valueOf(sw));
		}
		Button saveResult = (Button) findViewById(R.id.button_save_result);
		Button close = (Button) findViewById(R.id.button_close_current_activity);
		saveResult.setOnClickListener(saveResultListener);
		close.setOnClickListener(closeListener);
	}

	private View.OnClickListener saveResultListener = new View.OnClickListener() {
		public void onClick(View view) {
			SharedPreferences preferences = getSharedPreferences("PREVIOUS_RESULT", MODE_PRIVATE);
			SharedPreferences.Editor editor = preferences.edit();
			editor.putInt("PREVIOUS_HEIGHT", height);
			editor.putString("PREVIOUS_GENDER", gender);
			editor.commit();
			setResult(RESULT_OK);
			finish();
		}
	};
	private View.OnClickListener closeListener = new View.OnClickListener() {
		public void onClick(View view) {
			setResult(RESULT_CANCELED);
			finish();
		}
	};
}
