package com.ncs.thread;

public class ProductConsumerResolve2 {
	public static void main(String[] args) {
		Info3 info = new Info3();
		Productor3 productor = new Productor3(info);
		Consumer3 consumer = new Consumer3(info);
		
		new Thread(productor).start();
		new Thread(consumer).start();
	}
}

class Info3{
	private String name;
	private String content;
	boolean flag = false;
	public synchronized void setInfo(String name,String content){
		if(!flag){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.content = content;
		flag = false;
		notify();
	}
	
	public synchronized void getInfo(){
		if(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.name+" said : "+this.content);
		flag = true;
		notify();
	}
}

class Productor3 implements Runnable{
	private Info3 info;
	public Productor3(Info3 info) {
		this.info = info;
	}
	
	@Override
	public void run() {
		boolean flag = false;
		for(int i=0;i<50;i++){
			if(flag){
				info.setInfo("Chen Guang Ping", "Chen Guang Ping hate buffet");
				flag = false;
			}else{
				info.setInfo("Ding Li Ping", "Ding Li Ping hate buffet");
				flag = true;
			}
		}
	}
}

class Consumer3 implements Runnable{
	private Info3 info;
	public Consumer3(Info3 info) {
		this.info = info;
	}
	@Override
	public void run() {
		for(int i=0;i<50;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			info.getInfo();
		}
	}
}