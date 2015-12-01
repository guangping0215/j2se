package com.ncs.io;

import java.io.File;

public class FolderListUtil {

	public static void main(String[] args) {
		File file = new File("D:/gitworkspace");
		listFiles(file);
	}
	
	private static void listFiles(File file){
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File tmpFile : files){
				listFiles(tmpFile);
			}
		}else{
			System.out.println(file);
		}
	}
}
