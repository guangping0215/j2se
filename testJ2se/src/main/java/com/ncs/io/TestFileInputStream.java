package com.ncs.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestFileInputStream {

	public static void main(String[] args) {
		print("/Users/guangping/test/test.txt");
	}
	
	public static void print(String path){
		InputStream is = null;
		try {
			 is = new FileInputStream(new File(path));
			 int length = 0;
			 byte[] buff = new byte[200];
			 while( -1 != (length = is.read(buff, 0, 200))){
				 String result = new String(buff,0,length);
				 System.out.println(result);
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
