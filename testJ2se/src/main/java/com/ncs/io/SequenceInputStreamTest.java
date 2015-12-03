package com.ncs.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceInputStreamTest {

	public static void main(String[] args) {
		try {
			show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void show() throws IOException{
		String test1 = "Guang Ping said...";
		String test2 = "Welcome...";
		ByteArrayInputStream b1 = new ByteArrayInputStream(test1.getBytes());
		ByteArrayInputStream b2 = new ByteArrayInputStream(test2.getBytes());
		SequenceInputStream sis = new SequenceInputStream(b1,b2); //combine the two inputstream
		
		byte[] result = new byte[1240];
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int length = 0;
		while( (length = sis.read(result)) != -1){
			bos.write(result, 0, length);
		}
		
		System.out.println(bos.toString());
	}
}
