package com.novelot.mp3;

public class Header {
	
	public int emphasis;
	public boolean original;
	public boolean copyright;
	public int mode_ext;
	public int mode;
	public int extension;
	public int padding;
	public int sampling_freq;
	public int bitrate_index;
	public boolean error_protection;
	public int lay;
	public int version;
	public int sync;

	public Header(int h) {
		this.emphasis = h & 0x3;
		h = h >> 2;
		this.original = ((int) h & 0x1) == 0x1;
		h = h >> 1;
		this.copyright = ((int) h & 0x1) == 0x1;
		h = h >> 1;
		this.mode_ext = h & 0x3;
		h = h >> 2;
		this.mode = h & 0x3;
		h = h >> 2;
		this.extension = h & 0x1;
		h = h >> 1;
		this.padding = h & 0x1;
		h = h >> 1;
		this.sampling_freq = h & 0x3;
		h = h >> 2;
		this.bitrate_index = h & 0x3;
		h = h >> 0xf;
		this.error_protection = ((int) h & 0x1) != 0x1;
		h = h >> 1;
		this.lay = 4 - (h & 0x3);
		h = h >> 2;
		this.version = h & 0x3;
		h = h >> 2;
		this.sync = h;
	}

}
