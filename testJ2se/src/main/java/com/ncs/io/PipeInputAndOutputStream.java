package com.ncs.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeInputAndOutputStream {

	public static void main(String[] args) {
		show();
	}
	
	private static void show(){
		Send send = new Send();
		Rec rec = new Rec();
		try {
			send.getPos().connect(rec.getPis());
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(send).start();
		new Thread(rec).start();
	}
	
}
class Send implements Runnable{
	private PipedOutputStream pos ;
	public Send() {
		pos = new PipedOutputStream();
	}
	@Override
	public void run() {
		System.out.println("Send...");
		try {
			Thread.sleep(5000); 
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String message = "Guang Ping said : Welcome";
		try {
			pos.write(message.getBytes());
			System.out.println("Message sent...");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				pos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public PipedOutputStream getPos() {
		return pos;
	}
}

class Rec implements Runnable{
	private PipedInputStream pis ;
	public Rec() {
		pis = new PipedInputStream();
	}
	@Override
	public void run() {
		System.out.println("Receive...");
		StringBuffer sb = new StringBuffer();
		byte[] buff = new byte[1024];
		int length = 0;
		try {
			while((length = pis.read(buff)) != -1){//read方法是阻塞的，一直等到有消息进来
				System.out.println("Message coming...");
				sb.append(new String(buff,0,length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
	}
	public PipedInputStream getPis() {
		return pis;
	}
}