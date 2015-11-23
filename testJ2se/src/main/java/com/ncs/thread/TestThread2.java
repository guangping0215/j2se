package com.ncs.thread;

public class TestThread2 {

	public static void main(String[] args) {
//		Thread thread3 = new Thread(new Thread3(),"Thread3...");
//		System.out.println(thread3.getName());
//		thread3.start();
//		
//		Thread thread4 = new Thread(new Thread4(),"Thread4...");
//		System.out.println(thread4.getName());
//		thread4.start();
		
		
		Thread5 thread5 = new Thread5();
		
		Thread thread55 = new Thread(thread5);
		Thread thread555 = new Thread(thread5);
		thread55.start();
		thread555.start();
	}
}

class Thread3 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("Thread3 : " + i);
		}
	}
}

class Thread4 implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("Thread4 : " + i);
		}
	}
}

class Thread5 implements Runnable{
	
	int i = 0;
	
	@Override
	public void run() {
		
		while(true){
			System.out.println("i : "+ i++);
			
			try {
				Thread.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(50 == i)
				break;
		}
	}
}