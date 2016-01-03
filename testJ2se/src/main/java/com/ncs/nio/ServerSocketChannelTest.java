package com.ncs.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class ServerSocketChannelTest {

	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false); //非阻塞
		ServerSocket sc = ssc.socket();
		sc.bind(new InetSocketAddress(9999));//绑定地址
		ssc.register(selector, SelectionKey.OP_ACCEPT);//相当于使用accept接收
		int keyAdd = 0;
		while((keyAdd = selector.select()) > 0){ //接收一组键，相应的通道已为IO做准备
			System.out.println(keyAdd);
			Set<SelectionKey> sks = selector.selectedKeys();
			Iterator<SelectionKey> itsks =  sks.iterator();
			while(itsks.hasNext()){
				SelectionKey key = itsks.next();
				if(key.isAcceptable()){
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel client = server.accept();
					client.configureBlocking(false);
					ByteBuffer bb = ByteBuffer.allocate(1024);
					bb.put(("当前时间为："+new Date()).getBytes());
					bb.flip();
					client.write(bb);
					client.close();
				}
			}
			sks.clear();
		}
	}
}
