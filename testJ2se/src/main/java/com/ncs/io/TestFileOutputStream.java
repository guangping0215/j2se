package com.ncs.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestFileOutputStream {

	public static void main(String[] args) {
		writetoFile("/Users/guangping/test/test2.txt");
	}
	
	public static void writetoFile(String path){
		OutputStream os = null;
		try {
			 os = new FileOutputStream(new File(path));
			 String test = "WELCOME\n";
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
