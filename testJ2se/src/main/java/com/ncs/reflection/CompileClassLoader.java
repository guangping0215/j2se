package com.ncs.reflection;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CompileClassLoader extends ClassLoader{
	
	@SuppressWarnings("rawtypes")
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class clazz = null;
		String filePath = name.replace(".", File.separator);
		String javaFileName =  filePath+".java";
		String classFileName = filePath+".class";
		File javaFile = new File(javaFileName);
		System.out.println(javaFile.getAbsolutePath());
		File classFile = new File(classFileName);
		//如果java文件存在但同时class文件不存在或者java文件的更新时间在class文件之后，就需要重新编译
		if(javaFile.exists()&&(!classFile.exists() || javaFile.lastModified()>classFile.lastModified())){
			if(!compile(javaFileName)||(!classFile.exists())){
				throw new ClassNotFoundException("ClassNotFoundException: "+javaFileName);
			}
		}
		if(classFile.exists()){
			byte[] raw = getBytes(classFile);
			clazz = defineClass(name,raw, 0, raw.length);
		}
		if(null == clazz){
			throw new ClassNotFoundException(name);
		}
		return clazz;
	}
	
	private boolean compile(String javaFileName){
		System.out.println("Compiling..."+javaFileName);
		int returnCode = -1;
		try {
			Process process = Runtime.getRuntime().exec("javac "+ javaFileName);
			process.waitFor();
			returnCode = process.exitValue();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return returnCode == 0;
	}
	
	private byte[] getBytes(File classFile){
		BufferedInputStream bis = null;
		ByteArrayOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(classFile));
			bos = new ByteArrayOutputStream();
			byte[] buff = new byte[1024];
			int length = 0;
			while((length = bis.read(buff)) != -1){
				bos.write(buff, 0, length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(bis != null){
					bis.close();
				}
				if(bis != null){
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bos.toByteArray();
	}
	
	public static void main(String[] args) {
		if(args.length<0){
			System.out.println("No class to compile...");
			return;
		}
		String className = args[0];
		Object[] classParameters = new String[args.length - 1];
		System.arraycopy(args, 1, classParameters, 0, classParameters.length);
		CompileClassLoader ccl = new CompileClassLoader();
		try {
			Class<?> clazz = ccl.loadClass(className);
			Method print = clazz.getMethod("print", new Class[]{String.class});
			print.invoke(clazz.newInstance(), classParameters);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
