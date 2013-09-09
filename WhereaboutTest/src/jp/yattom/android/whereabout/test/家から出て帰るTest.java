package jp.yattom.android.whereabout.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import jp.yattom.android.whereabout.KnownLocationStatus;
import jp.yattom.android.whereabout.Location;
import jp.yattom.android.whereabout.WhereaboutStatus;
import jp.yattom.android.whereabout.WifiStatus;
import android.content.Context;
import android.media.AudioManager;
import android.test.AndroidTestCase;
import static org.mockito.Matchers.*;

public class 家から出て帰るTest extends AndroidTestCase {
	private Location home = new Location();

	public void test_家から出て帰る() throws Exception {
		家にいる();
		RingerModeをNormalにする();
		家を離れる();
		assertTrue(RingerModeがバイブレーション());
		家に入る();
		assertTrue(RingerModeがNormal());
	}

	private void 家に入る() {
		WhereaboutStatus status = new WhereaboutStatus();
		WifiStatus wifiStatus = mock(WifiStatus.class);
		when(wifiStatus.getId()).thenReturn(new String[] { "HomeBSSID" });
		status.setWifiStatus(wifiStatus);
		status.update();
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
		WhereaboutStatus status = new WhereaboutStatus();
		WifiStatus wifiStatus = mock(WifiStatus.class);
		when(wifiStatus.getId()).thenReturn(new String[0]);
		status.setWifiStatus(wifiStatus);
		status.update();
	}

	private void RingerModeをNormalにする() {
		AudioManager audioManager = (AudioManager) getContext()
				.getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	}

	private void 家にいる() {
		WhereaboutStatus status = new WhereaboutStatus();
		KnownLocationStatus locationStatus = mock(KnownLocationStatus.class);
		when(locationStatus.getCurrent()).thenReturn(home);
		status.setKnownLocationStatus(locationStatus);
		status.update();
	}
}
