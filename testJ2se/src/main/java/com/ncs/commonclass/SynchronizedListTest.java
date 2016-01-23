package com.ncs.commonclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedListTest {
	public static void main(String[] args) {
		List<String> list = Collections.synchronizedList(new ArrayList<String>());
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		new Thread(new synchronizedCollectionIter(list)).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.add("a");
		list.add("b");
	}
}

class synchronizedCollectionIter implements Runnable{
	private List<String> list;
	public synchronizedCollectionIter(List<String> list) {
		this.list = list;
	}
	@Override
	public void run() {
			synchronized (list) {
				for(int i=0;i<50;i++){
					Iterator<String> it = list.iterator();
					while(it.hasNext()){
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(it.next());
					}
					
				}
			}
	}
}
