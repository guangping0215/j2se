package com.ncs.commonclass;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
		BigDecimal test = new BigDecimal(2);
		//使用BigDecimal(double xx)有一定的不可预知性，因为该1.20实际上是一个近似于1.20的数
		BigDecimal test1 = new BigDecimal(1.20); 
		System.out.println(test1.multiply(test));
		
		//推荐使用一String构造
		BigDecimal test2 = new BigDecimal("1.20"); 
		System.out.println(test2.multiply(test));
		
		//推荐使用二String构造,但是通过double类型转换的
		BigDecimal test3 = new BigDecimal(Double.toString(1.20)); 
		System.out.println(test3.multiply(test));
		
		//推荐使用三BigDecimal.valueOf()通过double类型转换的
		BigDecimal test4 = BigDecimal.valueOf(1.20); 
		System.out.println(test4.multiply(test));
	}
}
