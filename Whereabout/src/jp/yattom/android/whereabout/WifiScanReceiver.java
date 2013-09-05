package jp.yattom.android.whereabout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class WifiScanReceiver extends BroadcastReceiver {
	static final public String TAG = "WifiScanReceiver";

	@Override
	public void onReceive(Context c, Intent intent) {
		Log.d(TAG, "onReceive: intent=" + intent);
		c.startService(new Intent(c, MainService.class));
	}
}