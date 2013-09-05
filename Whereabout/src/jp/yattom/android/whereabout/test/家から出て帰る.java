package jp.yattom.android.whereabout.test;

import jp.yattom.android.whereabout.MainService;
import android.test.ServiceTestCase;

public class 家から出て帰る extends ServiceTestCase<MainService> {

	public 家から出て帰る(Class<MainService> serviceClass) {
		super(serviceClass);
	}

	public void test_家から出て帰る() throws Exception {
		家にいる();
		RingerModeをNormalにする();
		家を離れる();
		assertTrue(RingerModeがバイブレーション());
		家に戻る();
		assertTrue(RingerModeがNormal());
	}
}
