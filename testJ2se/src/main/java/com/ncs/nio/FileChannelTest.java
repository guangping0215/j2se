package com.ncs.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

	public static void main(String[] args) throws IOException {
		String content = "Guang Ping's file channel test...";
		String path = "/Users/guangping/test/fileChannel.txt";
		
		ByteBuffer bf = ByteBuffer.allocate(content.length());
		bf.put(content.getBytes());
		bf.flip();
		FileOutputStream fos = new FileOutputStream(path);
		FileChannel fc = fos.getChannel();
		fc.write(bf);
		fc.close();
		fos.close();
	}
}
