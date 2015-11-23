package com.ncs.innerclass;

import com.ncs.innerclass.MemberInnerClass.InnerClass;

public class testMemberInnerClass {

	public static void main(String[] args) {
		InnerClass innerClass = new MemberInnerClass().new InnerClass();
		innerClass.test();
	}
	
}

class MemberInnerClass{
	
	private String name = "Guang Ping";
	
	class InnerClass{
		
		public void test(){
			System.out.println(name);
		}
	}
}