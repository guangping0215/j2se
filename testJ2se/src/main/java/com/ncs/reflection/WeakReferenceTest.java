package com.ncs.reflection;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

	public static void main(String[] args) {
		
		//创建一个字符串对象
		String test = new String("WeakReference Test...");
		//系统使用常量池来管理这个字符串直接量(会使用强引用)，系统不会回收这个字符串直接量。
		//String test = "WeakReference Test...";
		
		//创建一个弱引用，让弱引用引用到WeakReference Test...字符串
		WeakReference<String> wf = new WeakReference<String>(test);
		System.out.println(wf.get());//打印WeakReference Test...
		
		test = null;//切断字符串对象的引用，此时只有弱引用引用字符串
		System.out.println(wf.get());//此时字符串对象还未被回收，打印WeakReference Test...
		System.gc();//强制垃圾回收
		System.runFinalization();
		System.out.println(wf.get());//弱引用wf会被回收,打印null
	}
}

