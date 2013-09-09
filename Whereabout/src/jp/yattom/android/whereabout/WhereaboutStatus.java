package jp.yattom.android.whereabout;

import android.media.AudioManager;

public class WhereaboutStatus {
	private WifiStatus wifiStatus;
	private GivenLocationStatus givenLocationStatus;
	private AudioStatus audioStatus;

	public void setWifiStatus(WifiStatus wifiStatus) {
		this.wifiStatus = wifiStatus;
	}

	public void setGivenLocationStatus(GivenLocationStatus locationStatus) {
		this.givenLocationStatus = locationStatus;
	}

	public void update() {
		Location current = givenLocationStatus.getCurrent();
		if (current != null) {
			audioStatus.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			return;
		}

		String[] bssids = wifiStatus.getId();
		for(int i = 0; i < bssids.length; i++) {
			if(bssids[i].equals("HomeBSSID")) {
				audioStatus.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				return;
			}
		}
		audioStatus.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	}

	public void setAudioStatus(AudioStatus audioStatus) {
		this.audioStatus = audioStatus;
	}
}
