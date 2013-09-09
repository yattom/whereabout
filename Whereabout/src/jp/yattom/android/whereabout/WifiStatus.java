package jp.yattom.android.whereabout;

import java.util.ArrayList;
import java.util.List;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

public class WifiStatus {

	private WifiManager wifiManager;

	public WifiStatus(WifiManager wifiManager) {
		this.wifiManager = wifiManager;
	}

	public List<String> getId() {
		List<ScanResult> scanResults = wifiManager.getScanResults();
		List<String> ids = new ArrayList<String>();
		for (ScanResult result : scanResults) {
			ids.add(result.BSSID);
		}
		return ids;
	}

}
