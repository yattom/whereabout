package jp.yattom.android.whereabout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.test.AndroidTestCase;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

public class WifiStatusTest extends AndroidTestCase {
	public void testGetId() throws Exception {
		WifiManager wifiMgr = mock(WifiManager.class);
		List<ScanResult> mockedResult = new ArrayList<ScanResult>();
		ScanResult aResult = mock(ScanResult.class);
		aResult.BSSID = "BSSID";
		mockedResult.add(aResult);
		when(wifiMgr.getScanResults()).thenReturn(mockedResult);

		WifiStatus target = new WifiStatus(wifiMgr);
		assertEquals(1, target.getId().size());
		assertEquals(Arrays.asList(new String[] { "BSSID" }), target.getId());
	}
}
