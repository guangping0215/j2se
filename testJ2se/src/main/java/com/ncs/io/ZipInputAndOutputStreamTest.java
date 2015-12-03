package com.ncs.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipInputAndOutputStreamTest {

	public static void main(String[] args) throws IOException {
		//zip("D:/test","d:/test.zip");
		unZip("D:","d:/test.zip");
	}
	
	private static void zip(String folderName,String zipFileName){
		ZipOutputStream zos = null;
		
		try{
			File folder = new File(folderName);
			zos = new ZipOutputStream(new FileOutputStream(zipFileName));
			zipFile("",folder,zos);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				zos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static void zipFile(String folder,File file, ZipOutputStream zos) throws IOException{
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File tmpFile : files){
				String folderName = "".equals(folder) ? file.getName() : folder+File.separator+file.getName();
				zipFile(folderName,tmpFile,zos);
			}
		}else{
			FileInputStream fis = new FileInputStream(file);
			ZipEntry zie = new ZipEntry(folder+File.separator+file.getName()); //按文件夹树的形式压缩
			zos.putNextEntry(zie);
			byte[] buff = new byte[1024];
			int length = 0;
			while((length = fis.read(buff)) != -1){
				zos.write(buff, 0, length);
			}
			zos.flush();
			fis.close();
		}
	}
	
	
	private static void unZip(String folderName,String zipFileName) throws IOException{
		ZipFile zipFiles = new ZipFile(zipFileName);
		ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFileName)); //通过ZipInputStream来获取 ZipEntry 或者通过zipFiles的entries()方法获取
		InputStream is = null;
		ZipEntry zipEntry = null;
		while( (zipEntry = zis.getNextEntry()) != null){
			File tmpFile = new File(folderName+File.separator+zipEntry.getName());
			if(!tmpFile.getParentFile().exists()){
				tmpFile.getParentFile().mkdirs();
			}
			is = zipFiles.getInputStream(zipEntry);
			FileOutputStream fos = new FileOutputStream(folderName+File.separator+zipEntry.getName());
			byte[] buff = new byte[1024];
			int length = 0;
			while((length = zis.read(buff)) != -1){
				fos.write(buff, 0, length);
			}
			fos.flush();
			fos.close();
			is.close();
		}
		zipFiles.close();
		zis.close();
	}
}
