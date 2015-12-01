package com.ncs.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	private String sourceFile;
	private String destFile;
	public RandomAccessFileTest(String sourceFile, String destFile) {
		this.sourceFile = sourceFile;
		this.destFile = destFile;
	}
	
	private void normalUpload(){
		FileInputStream fr = null;
		FileOutputStream bw = null;
		try{
			File source = new File(sourceFile);
			File dest = new File(destFile);
			fr = new FileInputStream(source);
			bw = new FileOutputStream(dest);
			byte[] bytes = new byte[1024];
			while( fr.read(bytes) != -1){
				bw.write(bytes);
			}
			bw.flush();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				if(fr != null){
					fr.close();
				}
				if(bw != null){
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void randomAccessFileUpload(){
			for(int i=0;i<5;i++){
				Thread t = new Thread(new MyThread());
				t.setName(i+"");
				t.start();
			}
	}
	
	class MyThread implements Runnable{
		
		@Override
		public void run() {
			RandomAccessFile radRead = null;
			RandomAccessFile radWrite = null;
			try {
				radRead  = new RandomAccessFile(sourceFile,"rw");
				radWrite = new RandomAccessFile(destFile,"rw");
				int currentThreadNum = Integer.parseInt(Thread.currentThread().getName());
				long begin = radRead.length() / 5 * currentThreadNum;
				long length = currentThreadNum == 4 ? radRead.length() - (radRead.length()/5 * 4) : radRead.length() / 5;
				radRead.seek(begin);
				radWrite.seek(begin);
				long leftLength = length;
				byte[] bytes = new byte[1024 * 1024];
				while( length - 1024 * 1024 > 0){
					radRead.read(bytes);
					radWrite.write(bytes);
					leftLength = length -= 1024 * 1024;
				}
				if(leftLength > 0){
					radRead.read(bytes,0,(int)leftLength);
					radWrite.write(bytes,0,(int)leftLength);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(radWrite != null)
						radWrite.close();
					if(radRead != null)
						radRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		//new RandomAccessFileTest("d:/source.pdf","d:/dest.pdf").normalUpload();
		new RandomAccessFileTest("d:/source.pdf","d:/dest.pdf").randomAccessFileUpload();
	}
}


