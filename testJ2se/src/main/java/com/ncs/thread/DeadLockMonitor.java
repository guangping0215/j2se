package com.ncs.thread;

public class DeadLockMonitor {

	public static void main(String[] args) {
		DeadLockThread bookThread = new DeadLockThread();
		DeadLockThread picThread = new DeadLockThread();
		picThread.setFlag(true);
		Thread t1 = new Thread(bookThread);
		Thread t2 = new Thread(picThread);
		
		t1.start();
		t2.start();
	}
}

class BookHolder{
	public void say(String name){
		System.out.println(name + "Give me Pic first...");
	}
	public void get(String name){
		System.out.println(name + "Get Pic...");
	}
}

class PicHolder{
	public void say(String name){
		System.out.println(name + "Give me Book first...");
	}
	public void get(String name){
		System.out.println(name + "Get Book...");
	}
}

class DeadLockThread implements Runnable{
	private static BookHolder book = new BookHolder();
	private static PicHolder pic = new PicHolder();
	private boolean flag = false;
	@Override
	public void run() {
		if(flag){
			synchronized (book) {
				book.say(Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (pic) {
					book.get(Thread.currentThread().getName());
				}
			}
		}else{
			synchronized (pic) {
				pic.say(Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (book) {
					pic.get(Thread.currentThread().getName());
				}
			}
		}
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}