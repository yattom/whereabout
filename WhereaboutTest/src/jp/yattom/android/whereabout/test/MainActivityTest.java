package jp.yattom.android.whereabout.test;

import jp.yattom.android.whereabout.MainActivity;
import android.content.Intent;
import android.test.ActivityUnitTestCase;

public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {
	public MainActivityTest() {
		super(MainActivity.class);
	}

	public void test起動する() {
		Intent intent = new Intent();
		startActivity(intent, null, null);
		assertNotNull(getActivity());
		assertFalse(isFinishCalled());
	}
}
