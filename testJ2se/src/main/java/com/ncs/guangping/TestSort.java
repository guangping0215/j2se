package com.ncs.guangping;

public class TestSort {
	//冒泡排序  对n个数据进行n-1次比较，每次前后两个数进行比较，小的放前面，大的放后面。
	private static void bubbleSort(int[] ori) {
		int total = ori.length;
		while (--total> 0) {
			for (int i = 0; i  < total; i++) {
				int tmp = 0;
				if (ori[i] > ori[i + 1]) {
					tmp = ori[i];
					ori[i] = ori[i + 1];
					ori[i + 1] = tmp;
				}
			}
		}
	}
	
	private static void bubbleSort2(int[] ori) {
		int total = ori.length;
		for(int j=0;j<total-1;j++){
			for (int i = 0; i  < total-j-1; i++) {
				int tmp = 0;
				if (ori[i] > ori[i + 1]) {
					tmp = ori[i];
					ori[i] = ori[i + 1];
					ori[i + 1] = tmp;
				}
			}
		}
	}
	
	//直接选择排序 对n个数据进行n-1次比较，同时每次找出最小的那个数，并放到本趟的第一位。
	private static void DirectSelectSort(int[] ori) {
		int total = ori.length;
		for(int j=0;j<total-1;j++){
			int tmp = ori[j] ;
			int index = j;
			for (int i = j+1; i  < total; i++) {
				if(tmp > ori[i]) {
					tmp = ori[i];
					index = i ;
				}
			}
			ori[index] = ori[j];
			ori[j] =tmp;
		}
	}

	public static void main(String[] args) {
		int[] ori = new int[] { 5,4,3,2,1,1 };
		DirectSelectSort(ori);
		for (int i : ori) {
			System.out.println(i);
		}
	}
}
