package jp.yattom.android.whereabout;

public class StubAudioStatus extends AudioStatus {
	private int ringerMode;

	public StubAudioStatus() {
		super(null);
	}

	public void setRingerMode(int ringerMode) {
		this.ringerMode = ringerMode;
	}

	public int getRingerMode() {
		return ringerMode;
	}
}
