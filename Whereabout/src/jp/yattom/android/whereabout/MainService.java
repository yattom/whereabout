package jp.yattom.android.whereabout;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

public class MainService extends IntentService {

	public MainService() {
		super("MainService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

		try {
			Thread.sleep(1000);
			audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		} catch (InterruptedException e) {
			// ignore
		}
	}
}
