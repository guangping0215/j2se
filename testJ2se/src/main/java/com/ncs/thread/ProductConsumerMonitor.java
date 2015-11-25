package com.ncs.thread;

public class ProductConsumerMonitor {
	public static void main(String[] args) {
		Info info = new Info();
		Productor productor = new Productor(info);
		Consumer consumer = new Consumer(info);
		
		new Thread(productor).start();
		new Thread(consumer).start();
	}
}

class Info{
	private String name;
	private String content;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

class Productor implements Runnable{
	private Info info;
	public Productor(Info info) {
		this.info = info;
	}
	@Override
	public void run() {
		boolean flag = false;
		for(int i=0;i<50;i++){
			if(flag){
				info.setName("Chen Guang Ping");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				info.setContent("Chen Guang Ping hate buffet");
				flag = false;
			}else{
				info.setName("Ding Li Ping");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				info.setContent("Ding Li Ping hate buffet");
				flag = true;
			}
			
		}
	}
}

class Consumer implements Runnable{
	private Info info;
	public Consumer(Info info) {
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
			System.out.println(info.getName()+" said : "+info.getContent());
		}
	}
}