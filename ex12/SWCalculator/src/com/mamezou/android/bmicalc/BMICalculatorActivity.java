package com.mamezou.android.bmicalc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BMICalculatorActivity extends Activity {
  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    Log.v("EXAMPLE", "onCreate was called.");
    setContentView(R.layout.main);
    Button button = (Button) findViewById(R.id.button_calculate);
    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(R.string.label_bmi_description);
    builder.setPositiveButton(R.string.button_close_dialog, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            setResult(RESULT_OK);
        }
    });
    button.setOnClickListener(new View.OnClickListener() {
      public void onClick(View view) {
        EditText textHeight = (EditText) findViewById(R.id.text_height);
        EditText textWeight = (EditText) findViewById(R.id.text_weight);
        int height = Integer.parseInt(textHeight.getText().toString());
        int weight = Integer.parseInt(textWeight.getText().toString());
        int bmi = 10000 * weight / height / height;
        builder.setMessage(String.valueOf(bmi));
        builder.create();
        builder.show();
      }
    });
  }
  @Override
  protected void onStart() {
    super.onStart();
    Log.v("EXAMPLE", "onStart was called.");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.v("EXAMPLE", "onRestart was called.");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.v("EXAMPLE", "onResume was called.");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.v("EXAMPLE", "onPause was called.");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.v("EXAMPLE", "onStop was called.");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.v("EXAMPLE", "onDestroy was called.");
  }
  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    Log.v("EXAMPLE", "onConfigurationChanged was called.");
  }
}