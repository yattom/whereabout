package jp.yattom.android.whereabout;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button saveButton = (Button) findViewById(R.id.button1);
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				SharedPreferences sp = getSharedPreferences("whereabout", MODE_PRIVATE);

				TextView text = (TextView) findViewById(R.id.editText1);
				sp.edit().putString("bssid", text.getText().toString()).commit();
			}
		});

		Button loadButton = (Button) findViewById(R.id.button2);
		loadButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				SharedPreferences sp = getSharedPreferences("whereabout", MODE_PRIVATE);
				TextView text = (TextView) findViewById(R.id.editText1);
				text.setText(sp.getString("bssid", ""));
			}
		});
	}
}