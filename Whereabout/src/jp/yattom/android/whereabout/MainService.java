package jp.yattom.android.whereabout;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;

public class MainService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null; // disallow binding
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

		Thread thread = new Thread() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				} catch (InterruptedException e) {
					// ignore
				}
			}
		};
		thread.start();
		return START_STICKY;
	}
}
