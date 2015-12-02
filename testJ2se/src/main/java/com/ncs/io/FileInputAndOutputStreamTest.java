package com.ncs.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInputAndOutputStreamTest {

	public static void main(String[] args) {
		writetoFile("/Users/guangping/test/test.txt");
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
	
	public static void writetoFile(String path){
		OutputStream os = null;
		try {
			 os = new FileOutputStream(new File(path));
			 String test = "Guang Ping said : WELCOME\n";
			 byte[] byteResult = test.getBytes();
			 os.write(byteResult);
			 os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
