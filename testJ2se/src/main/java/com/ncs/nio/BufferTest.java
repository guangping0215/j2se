package com.ncs.nio;

import java.nio.IntBuffer;

public class BufferTest {

	public static void main(String[] args) {
		IntBuffer ib = IntBuffer.allocate(1024); //分配缓冲区空间
		System.out.println("1.position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
		while(ib.hasRemaining()){
			System.out.print(ib.get());
		}
		ib.flip(); //get会导致游标移动
		System.out.println();
		ib.put(3);
		ib.put(new int[]{5,4,3,1,2});
		System.out.println("2.position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
		ib.flip(); //重设缓冲区
		System.out.println("3.position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
		while(ib.hasRemaining()){
			System.out.print(ib.get());
		}
		System.out.println();
		System.out.println("4.position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
		ib.clear(); //清空缓冲区
		System.out.println("5.position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
		while(ib.hasRemaining()){
			System.out.print(ib.get());
		}
		System.out.println();
		System.out.println("6.position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
	}
}
