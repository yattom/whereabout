package jp.yattom.android.whereabout;

import android.media.AudioManager;
import android.test.AndroidTestCase;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

public class AudioStatusTest extends AndroidTestCase {
	public void testSetRingerMode() throws Exception { 
		AudioManager wrapped = mock(AudioManager.class);
		AudioStatus target = new AudioStatus(wrapped);
		target.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		verify(wrapped).setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	}

	public void testGetRingerMode() throws Exception { 
		AudioManager wrapped = mock(AudioManager.class);
		when(wrapped.getRingerMode()).thenReturn(AudioManager.RINGER_MODE_VIBRATE);
		AudioStatus target = new AudioStatus(wrapped);
		assertEquals(AudioManager.RINGER_MODE_VIBRATE, target.getRingerMode());
	}
}
