package com.ncs.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",9999);
		InputStream is = socket.getInputStream();
		byte[] readByte = new byte[1024];
		int length = 0;
		while( -1 != (length = is.read(readByte))){
			System.out.println("server :"+new String(readByte,0,length));
		}
		
		SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));
		ByteBuffer bf = ByteBuffer.allocate(1024);
		byte[] data = new byte[1024];
		int i=0;
		while(sc.read(bf)!= -1){
			bf.flip();
			while(bf.hasRemaining()){
				data[i++] = bf.get();
			}
			bf.clear();
		}
		
		System.out.println("server :"+new String(data));
	}
}
