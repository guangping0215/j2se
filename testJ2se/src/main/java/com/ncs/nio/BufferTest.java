package com.ncs.nio;

import java.nio.IntBuffer;

public class BufferTest {

	public static void main(String[] args) {
		IntBuffer ib = IntBuffer.allocate(1024);
		System.out.println("position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
		ib.put(3);
		ib.put(new int[]{5,4,3,1,2});
		System.out.println("position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
		ib.flip();
		System.out.println("position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
		while(ib.hasRemaining()){
			System.out.print(ib.get());
		}
		System.out.println();
		System.out.println("position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
		ib.clear();
		System.out.println("position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
		while(ib.hasRemaining()){
			System.out.print(ib.get());
		}
		System.out.println();
		System.out.println("position: "+ ib.position()+" capacity: "+ ib.capacity()+" limit: "+ ib.limit());
	}
}
