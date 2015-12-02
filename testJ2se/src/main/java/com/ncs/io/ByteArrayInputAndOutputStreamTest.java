package com.ncs.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayInputAndOutputStreamTest {

	public static void main(String[] args) {
		String content = "Guang Ping said : Welcome!!!";
		show(content);
	}

	public static void show(String content) {
		ByteArrayOutputStream os = null;
		ByteArrayInputStream is = null;
		try {
			os = new ByteArrayOutputStream();
			is = new ByteArrayInputStream(content.getBytes());
			
			byte[] buff = new byte[1024];
			int length = 0;
			while(-1 != (length = is.read(buff, 0, buff.length))){
				os.write(buff, 0, length);
			}
			System.out.println(os.toString());
			byte[] result = os.toByteArray();
			System.out.println(new String(result));
		} finally {
			try {
				os.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
