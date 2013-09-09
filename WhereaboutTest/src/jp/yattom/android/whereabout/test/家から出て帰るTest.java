package jp.yattom.android.whereabout.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import jp.yattom.android.whereabout.AudioStatus;
import jp.yattom.android.whereabout.GivenLocationStatus;
import jp.yattom.android.whereabout.Location;
import jp.yattom.android.whereabout.StubAudioStatus;
import jp.yattom.android.whereabout.WhereaboutStatus;
import jp.yattom.android.whereabout.WifiStatus;
import android.media.AudioManager;
import android.test.AndroidTestCase;
import static org.mockito.Matchers.*;

public class 家から出て帰るTest extends AndroidTestCase {
	private Location home = new Location();
	private AudioStatus audioStatus = new StubAudioStatus();

	public WhereaboutStatus createTarget() {
		WhereaboutStatus target = new WhereaboutStatus();

		WifiStatus wifiStatus = mock(WifiStatus.class);
		when(wifiStatus.getId()).thenReturn(new String[0]);
		target.setWifiStatus(wifiStatus);

		GivenLocationStatus givenLocationStatus = mock(GivenLocationStatus.class);
		when(givenLocationStatus.getCurrent()).thenReturn(null);
		target.setGivenLocationStatus(givenLocationStatus);

		target.setAudioStatus(audioStatus);

		return target;
	}

	public void test_家から出て帰る() throws Exception {
		家にいる();
		RingerModeをNormalにする();
		家を離れる();
		assertTrue(RingerModeがバイブレーション());
		家に入る();
		assertTrue(RingerModeがNormal());
	}

	private void 家に入る() {
		WhereaboutStatus status = createTarget();
		WifiStatus wifiStatus = mock(WifiStatus.class);
		when(wifiStatus.getId()).thenReturn(new String[] { "HomeBSSID" });
		status.setWifiStatus(wifiStatus);
		status.update();
	}

	private boolean RingerModeがNormal() {
		return audioStatus.getRingerMode() == AudioManager.RINGER_MODE_NORMAL;
	}

	private boolean RingerModeがバイブレーション() {
		return audioStatus.getRingerMode() == AudioManager.RINGER_MODE_VIBRATE;
	}

	private void 家を離れる() {
		WhereaboutStatus status = createTarget();
		status.update();
	}

	private void RingerModeをNormalにする() {
		audioStatus.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	}

	private void 家にいる() {
		WhereaboutStatus status = createTarget();
		GivenLocationStatus givenLocationStatus = mock(GivenLocationStatus.class);
		when(givenLocationStatus.getCurrent()).thenReturn(home);
		status.setGivenLocationStatus(givenLocationStatus);
		status.update();
	}
}
