package com.ncs.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket socServer = new ServerSocket(5001);
		while(true){
			Socket soc = socServer.accept();
			System.out.println(soc);
			new ServerInputThread(soc).start();
			new ServerOutputThread(soc).start();
		}
	}
}

class ServerInputThread extends Thread{
	
	private Socket socket;
	
	public ServerInputThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
//			BufferedReader bwr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			while(true){
//				String line = bwr.readLine();
//				System.out.println("Client : "+ line);
//			}
			InputStream is = socket.getInputStream();
			while(true){
				byte[] buff = new byte[1024];
				int length = is.read(buff);
				String line = new String(buff,0,length);
				System.out.println("Client : "+ line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}

class ServerOutputThread extends Thread{
	
	private Socket socket;
	
	public ServerOutputThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			OutputStream outstream = socket.getOutputStream();
			while(true){
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
				outstream.write(bf.readLine().getBytes());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}