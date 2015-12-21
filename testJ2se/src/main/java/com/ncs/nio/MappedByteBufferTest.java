package com.ncs.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class MappedByteBufferTest {

	public static void main(String[] args) throws IOException {
		String path = "/Users/guangping/test/fileChannel.txt";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		FileChannel fc = fis.getChannel();
		MappedByteBuffer mbf = fc.map(MapMode.READ_ONLY, 0, fis.available());
		byte[] data = new byte[fis.available()];
		int i=0;
		while(mbf.hasRemaining()){
			data[i++] = mbf.get();
		}
		System.out.println(new String(data));
		fis.close();
		fis.close();
	}
}
