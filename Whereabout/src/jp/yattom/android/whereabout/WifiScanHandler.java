package jp.yattom.android.whereabout;

import android.media.AudioManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

public class WifiScanHandler {
	private AudioManager audioMgr;
	private WifiManager wifiMgr;
	private String bssid;

	public WifiScanHandler(AudioManager audioMgr, WifiManager wifiMgr) {
		this.audioMgr = audioMgr;
		this.wifiMgr = wifiMgr;
	}

	public void handle() {
		for (ScanResult result : wifiMgr.getScanResults()) {
			if (result.BSSID.equals(bssid)) {
				audioMgr.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				return;
			}
		}
		audioMgr.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	}

	public void setBssid(String bssid) {
		this.bssid = bssid;
	}

}
