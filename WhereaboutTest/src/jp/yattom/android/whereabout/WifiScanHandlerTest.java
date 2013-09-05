package jp.yattom.android.whereabout;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.test.AndroidTestCase;
import android.util.Log;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

public class WifiScanHandlerTest extends AndroidTestCase {
	private AudioManager audioMgr;
	private WifiManager wifiMgr;

	public void setUp() throws Exception {
		audioMgr = mock(AudioManager.class);
		wifiMgr = mock(WifiManager.class);
	}

	public void testContextがあること() {
		Context context = getContext();
		Log.d("Test", "context: " + context);
		assertNotNull(context);
	}

	public void test指定のアクセスポイントから離れたらバイブレーションにする() throws Exception {
		List<ScanResult> mockedResult = new ArrayList<ScanResult>();
		when(wifiMgr.getScanResults()).thenReturn(mockedResult);

		WifiScanHandler target = new WifiScanHandler(audioMgr, wifiMgr);
		target.setBssid("BSSID");
		target.handle();
		verify(audioMgr).setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	}

	public void test指定のアクセスポイントに近づいたらバイブレーションをやめる() throws Exception {
		List<ScanResult> mockedResult = new ArrayList<ScanResult>();
		ScanResult aResult = mock(ScanResult.class);
		aResult.BSSID = "BSSID";
		mockedResult.add(aResult);
		when(wifiMgr.getScanResults()).thenReturn(mockedResult);

		WifiScanHandler target = new WifiScanHandler(audioMgr, wifiMgr);
		target.setBssid("BSSID");
		target.handle();
		verify(audioMgr).setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	}
}
