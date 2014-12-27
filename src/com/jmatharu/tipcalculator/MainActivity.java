package com.jmatharu.tipcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText amount;
	TextView textView, textView1, texViewTip, txtTotal;
	SeekBar seekBarTip, seekNumPeople;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initializeVariables();
		seekBarTip.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (TextUtils.isEmpty(amount.getText())) {
					texViewTip.setText("Enter Bill Amount");
					txtTotal.setText("Enter Bill Amount");
				}

				return false;
			}
		});
		seekBarTip.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int progressChanged = 0;

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				progressChanged = progress;
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

				// TODO Auto-generated method stub
				String tipPercent = String.valueOf(progressChanged);
				textView.setText("Tip % : " + tipPercent + " %");
			}
		});

		seekNumPeople.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (TextUtils.isEmpty(amount.getText())) {
					texViewTip.setText("Enter Bill Amount");
					txtTotal.setText("Enter Bill Amount");
				}else {
					texViewTip.setText("");
					txtTotal.setText("");
				}

				return false;
			}
		});
		seekNumPeople.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int progressChangedPeople = 0;

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				progressChangedPeople = progress;
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				String person = String.valueOf(progressChangedPeople);
				textView1.setText("Number Of People : " + person);
			}
		});
	}

	private void initializeVariables() {
		// TODO Auto-generated method stub
		amount = (EditText) findViewById(R.id.editText1);
		amount.setFilters(new InputFilter[] { new InputFilter.LengthFilter(6) });

		seekBarTip = (SeekBar) findViewById(R.id.seekBar1);
		seekBarTip.setMax(40);

		seekNumPeople = (SeekBar) findViewById(R.id.seekBar2);
		seekNumPeople.setMax(20);

		textView = (TextView) findViewById(R.id.textView1);
		textView.setText("Tip % : 0 %");

		textView1 = (TextView) findViewById(R.id.textView2);
		textView1.setText("Number Of People : 0");

		texViewTip = (TextView) findViewById(R.id.textView3);
		txtTotal = (TextView) findViewById(R.id.textView4);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {

			return true;
		} else if (id == R.id.about_me) {

		} else if (id == R.id.contact_me) {
			Intent activityIntent = new Intent(MainActivity.this,
					ContactMe.class);
			MainActivity.this.startActivity(activityIntent);
		}
		return super.onOptionsItemSelected(item);
	}

	public void calculate(View view) {

		if (TextUtils.isEmpty(amount.getText())) {
			Toast.makeText(this, "sas", Toast.LENGTH_SHORT).show();
		}
	}
}
