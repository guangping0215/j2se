package com.ncs.thread;

public class ThreadExtend {
	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		MyThread mt2 = new MyThread();
		MyThread mt3 = new MyThread();
		
		mt1.start();
		mt2.start();
		mt3.start();
	}
}

class MyThread extends Thread{
	private int ticket = 5;
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			if(ticket > 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("current ticket : "+ticket-- );
			}
		}
	}
}