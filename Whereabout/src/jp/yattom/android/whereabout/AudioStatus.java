package jp.yattom.android.whereabout;

import android.media.AudioManager;

public class AudioStatus {

	private AudioManager audioManager;

	public AudioStatus(AudioManager audioManager) {
		this.audioManager = audioManager;
	}

	public void setRingerMode(int ringerMode) {
		audioManager.setRingerMode(ringerMode);
	}

	public int getRingerMode() {
		return audioManager.getRingerMode();
	}

}
