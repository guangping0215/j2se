package com.ncs.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) throws InterruptedException {
		final String path = "/Users/guangping/test/fileChannel.txt";
		final File file = new File(path);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				FileOutputStream fis = null;
				FileChannel fc = null;
				try {
					fis = new FileOutputStream(file,true);
					System.out.println(Thread.currentThread().getName()+"线程读取文件");
					fc = fis.getChannel();
					FileLock fl = fc.lock();
					if(fl != null){
						System.out.println("文件被锁10秒");
						Thread.sleep(10000);
						fl.release();
						System.out.println("文件解锁");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					try {
						fc.close();
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		}).start();
		Thread.sleep(3000);
		FileInputStream fis = null;
		FileChannel fc = null;
		try {
			fis = new FileInputStream(file);
			System.out.println(Thread.currentThread().getName()+"线程读取文件");
			fc = fis.getChannel();
			int length = fis.available();
			ByteBuffer data = ByteBuffer.allocate(length);
			fc.read(data);
			data.flip();
			byte[] bytedata = new byte[length];
			int i=0;
			while(data.hasRemaining()){
				bytedata[i++] = data.get();
			}
			System.out.println(new String(bytedata));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}
