package com.ncs.guangping;

import java.io.File;

public class testRecursion {

	//阶乘
	public int computation( int num ){
		if( num == 1 ){
			return 1;
		}else{
			return num * computation( num - 1 );
		}
	}
	
	//斐波那契数列
	public int fibonacii( int position ){
		if( 1 == position || 2 == position ){
			return 1;
		}else{
			return fibonacii(position - 1)+fibonacii(position - 1);
		}
	}
	
	public void recursionDelete( String filePath ){
		File file = new File(filePath);
		if(!file.isDirectory()){
			file.delete();
		}  else {
			File[] files = file.listFiles();
			for(File tmpFile : files){
				recursionDelete(tmpFile.getAbsolutePath());
				tmpFile.delete();
			}
			
		}
	}
	String fileInd = "+";
	int level = 1;
	public void testFileList( int level,File file ){
		
		if( file.isFile() || file.listFiles().length == 0 ){
			System.out.println( patchLevel(level,fileInd) + file.getName() );
		}else{
			System.out.println(patchLevel(level,fileInd) + file.getName());
			File[] files = file.listFiles();
			level++;
			for(File tmpFile : files){
				testFileList(level,tmpFile);
			}
		}
	}
	
	private String patchLevel(int level,String fileInd){
		for(int i=0;i<level ;i++){
			fileInd =  fileInd+"-";
		}
		return fileInd;
	}
	
	public static void main(String[] args) {
		testRecursion test = new testRecursion();
//		System.out.println(test.computation(5));
//		System.out.println(test.fibonacii(5));
//		test.recursionDelete("/Users/guangping/test");
		test.testFileList(1,new File("/Users/guangping/test"));
	}
	
}
