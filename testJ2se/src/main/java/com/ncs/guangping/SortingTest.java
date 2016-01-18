package com.ncs.guangping;

import java.util.Arrays;

public class SortingTest {
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
		for(int j=1;j<total;j++){
			for (int i = 0; i  < total-j; i++) {
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
	
	//归并排序，算法将数组分为两半，对每个部分进行递归调用归并排序
    public static void mergeSort(int[] data, int left, int right) {  
        if (left >= right)  
            return;  
        int center = (left + right) / 2;  
        mergeSort(data, left, center);  
        mergeSort(data, center + 1, right);  
        merge(data, left, center, right);  
    }  
   
    public static void merge(int[] data, int left, int center, int right) {  
        int[] tmpArr = new int[data.length];  
        int mid = center + 1;  
        int third = left;  
        int tmp = left;  
        while (left <= center && mid <= right) {  
            if (data[left] <= data[mid]) {  
                tmpArr[third++] = data[left++];  
            } else {  
                tmpArr[third++] = data[mid++];  
            }  
        }  
        while (mid <= right) {  
            tmpArr[third++] = data[mid++];  
        }  
        while (left <= center) {  
            tmpArr[third++] = data[left++];  
        }  
        while (tmp <= right) {  
            data[tmp] = tmpArr[tmp++];  
        }  
    }  

	public static void main(String[] args) {
		int[] ori = new int[] { 5,4,3,2,1,1 };
		mergeSort(ori, 0, ori.length - 1);;
		for (int i : ori) {
			System.out.println(i);
		}
	}
}
