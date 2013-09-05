package jp.yattom.android.whereabout;

import android.content.Context;
import android.media.AudioManager;
import android.test.AndroidTestCase;
import android.util.Log;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

public class WifiScanHandlerTest extends AndroidTestCase {
	private AudioManager audioMgr;
	
	public void setUp() throws Exception {
		audioMgr = mock(AudioManager.class);
	}

	public void testContextがあること() {
		Context context = getContext();
		Log.d("Test", "context: " + context);
		assertNotNull(context);
	}

	public void test指定のアクセスポイントから離れたらバイブレーションにする() throws Exception {
		WifiScanHandler target = new WifiScanHandler(audioMgr);
		target.handle();
		verify(audioMgr).setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	}
}
