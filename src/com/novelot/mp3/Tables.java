package com.novelot.mp3;

public class Tables {

	/**
	 * 比特率表
	 */
	public static final int[][][] BitrateTable = {
			// MPEG 1
			{

					// Layer I
					{ 0, 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448 },
					// Layer II
					{ 0, 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384 },
					// Layer III
					{ 0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320 } },
			// MPEG 2.0/2.5
			{

					// Layer I
					{ 0, 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256 },
					// Layer II
					{ 0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 },
					// Layer III
					{ 0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 } } };

	/**
	 * 采样率表
	 */
	public static final int[][] SamplingRateTable = { 
			{ 11025, 12000, 8000, 0 },
			// MPEG
			// Version
			// 2.5
			{ 0, 0, 0, 0, }, // reserved
			{ 22050, 24000, 16000, 0 }, // MPEG Version 2 (ISO/IEC 13818-3)
			{ 44100, 48000, 32000, 0 } // MPEG Version 1 (ISO/IEC 11172-3)
	};
}
