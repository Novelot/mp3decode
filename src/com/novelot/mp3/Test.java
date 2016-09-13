package com.novelot.mp3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Test {

	private static int MASK_SYNC = 0xffe00000;

	public static void main(String[] args) throws Exception {
		File file = new File(args[0]);
		System.out.println("path=" + file.getAbsolutePath());
		//
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		syncHeader(raf);
		// sysnHeader(raf, 1);
		// sysnHeader(raf, 83);
		// sysnHeader(raf, 84);

		for (int i = 1; i < syncWords.size(); i++) {
			System.out.println("差=" + (syncWords.get(i) - syncWords.get(i - 1)));
		}
	}

	private static List<Long> syncWords = new ArrayList<>();

	private static void syncHeader(RandomAccessFile raf) throws Exception {

		long offset = 0L;
		int h = 0;
		int reached;
		byte[] buffer = new byte[4];

		raf.seek(offset);
		do {
			h = 0;
			reached = raf.read(buffer, 0, 4);
			for (int i = 0; i < 4; i++) {
				h = h | ((buffer[i] & 0xff) << (8 * (3 - i)));
			}
			if (((h & MASK_SYNC) == MASK_SYNC)) {
				syncWords.add(offset);
				System.out.println("找到同步字,起始位置在：" + offset);
				System.out.println(Integer.toHexString(h));
				System.out.println("寻找下一个...");
			}
			offset++;
			raf.seek(offset);

		} while ((reached != -1));

		// {
		// System.out.println("找到同步字,起始位置在：" + offset);
		// System.out.println(Integer.toHexString(h));
		// System.out.println("寻找下一个...");
		// offset++;
		// sysnHeader(raf, offset);
		// } else {
		// System.out.println("未找到同步字，继续寻找...");
		// offset++;
		// sysnHeader(raf, offset);
		// }
	}

	public static Header parseHeader(int h) {
		Header header = new Header(h);
		return header;
	}

}
