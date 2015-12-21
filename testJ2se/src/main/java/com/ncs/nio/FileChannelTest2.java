package com.ncs.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest2 {

	public static void main(String[] args) throws IOException {
		String fromPath = "/Users/guangping/test/fileChannel.txt";
		String toPath = "/Users/guangping/test/fileChannel2.txt";
		
		FileInputStream fis = new FileInputStream(fromPath);
		FileOutputStream fos = new FileOutputStream(toPath);
		FileChannel fisChannel = fis.getChannel();
		FileChannel fosChannel = fos.getChannel();
		
		ByteBuffer bf = ByteBuffer.allocate(1024);
		while(fisChannel.read(bf) != -1){
			bf.flip();
			fosChannel.write(bf);
			bf.clear();
		}
		fisChannel.close();
		fosChannel.close();
		fis.close();
		fos.close();
	}
}
