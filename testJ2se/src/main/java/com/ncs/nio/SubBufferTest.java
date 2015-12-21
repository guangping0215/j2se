package com.ncs.nio;

import java.nio.IntBuffer;

public class SubBufferTest {

	public static void main(String[] args) {
		IntBuffer ib = IntBuffer.allocate(10);
		ib.put(new int[]{1,2,3,4,5,6,7,8,9,10});
		ib.flip();
		ib.position(2);
		ib.limit(5);
		IntBuffer subIb = ib.slice();
		
		for(int i=0;i<subIb.capacity();i++){
			int tmp = subIb.get(i);
			subIb.put(tmp + 10);
		}
		
		ib.flip();//重设缓冲区
		ib.limit(ib.capacity());//设置limit
		while(ib.hasRemaining()){
			System.out.print(ib.get()+",");
		}
	}
}
