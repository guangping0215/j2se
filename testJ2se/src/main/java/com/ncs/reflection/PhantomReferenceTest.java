package com.ncs.reflection;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {

	public static void main(String[] args) {
		//创建一个字符串对象
		String test = new String("PhantomReference Test...");
		//系统使用常量池来管理这个字符串直接量(会使用强引用)，系统不会回收这个字符串直接量。
		//String test = "PhantomReference Test...";
		
		//创建一个ReferenceQueue对象
		ReferenceQueue<String> req = new ReferenceQueue<String>();
		
		//创建一个虚引用，让虚引用引用到PhantomReference Test...字符串
		PhantomReference<String> pf = new PhantomReference<String>(test,req);
		System.out.println(pf.get());//打印null，类似于没有引用
		System.out.println(req.poll() == pf);//false 还没有被回收
		test = null;//切断字符串对象的引用，此时只有虚引用引用字符串
		System.out.println(pf.get());//打印null
		System.out.println(req.poll() == pf);//false 还没有被回收
		System.gc();//强制垃圾回收
		System.runFinalization();
		System.out.println(pf.get());//打印null
		System.out.println(req.poll() == pf);//true 可以看到被回收
	}
}
