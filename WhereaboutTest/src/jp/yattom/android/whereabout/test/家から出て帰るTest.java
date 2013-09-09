package jp.yattom.android.whereabout.test;

import java.util.ArrayList;
import java.util.Arrays;

import jp.yattom.android.whereabout.AudioStatus;
import jp.yattom.android.whereabout.GivenLocationStatus;
import jp.yattom.android.whereabout.Location;
import jp.yattom.android.whereabout.StubAudioStatus;
import jp.yattom.android.whereabout.WhereaboutStatus;
import jp.yattom.android.whereabout.WifiStatus;
import android.media.AudioManager;
import android.test.AndroidTestCase;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

public class 家から出て帰るTest extends AndroidTestCase {
	private Location home = new Location();
	private AudioStatus audioStatus = new StubAudioStatus();
	final static String DUMMY_HOME_BSSID = "HomeBSSID";

	public WhereaboutStatus createTarget() {
		WhereaboutStatus target = new WhereaboutStatus();

		WifiStatus wifiStatus = mock(WifiStatus.class);
		when(wifiStatus.getId()).thenReturn(new ArrayList<String>());
		target.setWifiStatus(wifiStatus);

		GivenLocationStatus givenLocationStatus = mock(GivenLocationStatus.class);
		when(givenLocationStatus.getCurrent()).thenReturn(null);
		target.setGivenLocationStatus(givenLocationStatus);

		target.setAudioStatus(audioStatus);
		
		target.setBssid(DUMMY_HOME_BSSID);

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
		when(wifiStatus.getId()).thenReturn(Arrays.asList(new String[] { DUMMY_HOME_BSSID }));
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
