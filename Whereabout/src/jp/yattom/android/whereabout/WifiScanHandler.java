package jp.yattom.android.whereabout;

import android.media.AudioManager;

public class WifiScanHandler {
	private AudioManager audioMgr;

	public WifiScanHandler(AudioManager audioMgr) {
		this.audioMgr = audioMgr;
	}

	public void handle() {
		audioMgr.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	}

}
