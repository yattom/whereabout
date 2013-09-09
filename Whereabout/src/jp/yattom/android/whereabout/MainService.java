package jp.yattom.android.whereabout;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.net.wifi.WifiManager;

public class MainService extends IntentService {

	public MainService() {
		super("MainService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		final AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
		final WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
		SharedPreferences sp = getSharedPreferences("whereabout", MODE_PRIVATE);

		WhereaboutStatus whereabout = new WhereaboutStatus();
		whereabout.setAudioStatus(new AudioStatus(audioManager));
		whereabout.setWifiStatus(new WifiStatus(wifiManager));
		whereabout.setGivenLocationStatus(new GivenLocationStatus());
		whereabout.setBssid(sp.getString("bssid", ""));
		whereabout.update();
	}
}
