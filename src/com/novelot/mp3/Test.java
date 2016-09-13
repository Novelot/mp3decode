package com.novelot.mp3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {

	private static int MASK_SYNC = 0xfff00000;

	public static void main(String[] args) throws Exception {
		File file = new File(args[0]);
		System.out.println("path=" + file.getAbsolutePath());
		//
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		sysnHeader(raf, 0);
		// sysnHeader(raf, 1);
		// sysnHeader(raf, 83);
		// sysnHeader(raf, 84);

	}

	private static void sysnHeader(RandomAccessFile raf, long offset) throws Exception {
		raf.seek(offset);
		byte[] buffer = new byte[4];
		int reached = raf.read(buffer, 0, 4);
		if (reached < 0)
			return;
		int h = 0;
		for (int i = 0; i < 4; i++) {
			h = h | ((buffer[i] & 0xff) << (8 * (3 - i)));
		}

		if ((h & MASK_SYNC) == MASK_SYNC) {
			System.out.println("找到同步字,起始位置在：" + offset);
			System.out.println(Integer.toHexString(h));
			System.out.println("寻找下一个...");
			offset++;
			sysnHeader(raf, offset);
		} else {
			System.out.println("未找到同步字，继续寻找...");
			offset++;
			sysnHeader(raf, offset);
		}
	}

}
