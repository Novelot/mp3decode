package com.novelot.mp3;

public class Utils {

	private static final int[] SLOT_SIZE = { 4, 1, 1 };

	/**
	 * 得到帧长
	 * 
	 * @return
	 * 
	 */
	public static int getFrameSize(int lay, int version) {
		// LyaerI使用公式：
		// 帧长度（字节） = (( 每帧采样数/ 8 * 比特率 ) / 采样频率 ) + 填充 * 4
		// LyerII和LyaerIII使用公式：
		// 帧长度（字节）= (( 每帧采样数/ 8 * 比特率 ) / 采样频率 ) + 填充

	}

}
