package jp.yattom.android.whereabout.test;

import jp.yattom.android.whereabout.MainService;
import android.content.Context;
import android.media.AudioManager;
import android.test.ServiceTestCase;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

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
		assertThat(RingerModeがバイブレーション(), is(true));
		家にいる();
		assertThat(RingerModeがNormal(), is(true));
	}

	private boolean RingerModeがNormal() {
		AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		return audioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL;
	}

	private boolean RingerModeがバイブレーション() {
		AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		return audioManager.getRingerMode() == AudioManager.RINGER_MODE_VIBRATE;
	}

	private void 家を離れる() {
		AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	}

	private void RingerModeをNormalにする() {
		AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	}

	private void 家にいる() {
		AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	}
}
