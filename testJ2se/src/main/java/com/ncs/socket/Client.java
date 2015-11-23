package com.ncs.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket soc = new Socket("127.0.0.1",5001);
		new ClientInputThread(soc).start();
		new ClientOutputThread(soc).start();
	}
}
class ClientInputThread extends Thread{
	
	private Socket socket;
	
	public ClientInputThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			while(true){
				byte[] readByte = new byte[1024];
				int length = 0;
				while( -1 != (length = is.read(readByte))){
					System.out.println("server :"+new String(readByte,0,length));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}

class ClientOutputThread extends Thread{
	
	private Socket socket;
	
	public ClientOutputThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			OutputStream outstream = socket.getOutputStream();
			while(true){
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
				String line = bf.readLine();
				outstream.write(line.getBytes());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}