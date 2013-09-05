package jp.yattom.android.whereabout.test;

import jp.yattom.android.whereabout.MainService;
import android.content.Context;
import android.media.AudioManager;
import android.test.ServiceTestCase;

public class 家から出て帰るTest extends ServiceTestCase<MainService> {
	public 家から出て帰るTest() {
		super(MainService.class);
	}

	public void setUp() throws Exception {
	}

	public void test_家から出て帰る() throws Exception {
		家にいる();
		RingerModeをNormalにする();
		家を離れる();
		startService(null);
		assertTrue(RingerModeがバイブレーション());
		家にいる();
		assertTrue(RingerModeがNormal());
	}

	private boolean RingerModeがNormal() {
		AudioManager audioManager = (AudioManager) getContext()
				.getSystemService(Context.AUDIO_SERVICE);
		return audioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL;
	}

	private boolean RingerModeがバイブレーション() {
		AudioManager audioManager = (AudioManager) getContext()
				.getSystemService(Context.AUDIO_SERVICE);
		return audioManager.getRingerMode() == AudioManager.RINGER_MODE_VIBRATE;
	}

	private void 家を離れる() {
	}

	private void RingerModeをNormalにする() {
		AudioManager audioManager = (AudioManager) getContext()
				.getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	}

	private void 家にいる() {
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			// ignore
		}
	}
}
