package com.ncs.thread;

public class ProductConsumerResolve {
	public static void main(String[] args) {
		Info2 info = new Info2();
		Productor2 productor = new Productor2(info);
		Consumer2 consumer = new Consumer2(info);
		
		new Thread(productor).start();
		new Thread(consumer).start();
	}
}

class Info2{
	private String name;
	private String content;
	
	public synchronized void setInfo(String name,String content){
		this.name = name;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.content = content;
	}
	
	public synchronized void getInfo(){
		System.out.println(this.name+" said : "+this.content);
	}
}

class Productor2 implements Runnable{
	private Info2 info;
	public Productor2(Info2 info) {
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

class Consumer2 implements Runnable{
	private Info2 info;
	public Consumer2(Info2 info) {
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