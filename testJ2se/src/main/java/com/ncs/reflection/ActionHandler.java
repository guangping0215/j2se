package com.ncs.reflection;

import java.lang.reflect.Method;

public class ActionHandler {
	
	private boolean checkMethodWithTestAnnotation(Method method){
		return method.isAnnotationPresent(Test.class);
	}
	
	private boolean checkMethodWithoutParameter(Method method){
		return method.getParameterTypes().length == 0;
	}
	
	private boolean checkMethodWithVoidReturn(Method method){
		Class<?> returnType = method.getReturnType();
		if("void".equals(returnType.getName())){
			return true;
		}else
			return false;
	}

	public void run(String className) throws Exception{
		try {
			Class<?> clazz = Class.forName(className);
			Object object = clazz.newInstance();
			
			Method[] methods = clazz.getMethods();
			for(Method method : methods){
				if(checkMethodWithTestAnnotation(method) 
						&& checkMethodWithoutParameter(method)
						&& checkMethodWithVoidReturn(method)){
					method.invoke(object, new Object[]{});
				}
			}
		} catch (ClassNotFoundException e) {
			throw new Exception("Class not found in System");
		}
	}
	
	public static void main(String[] args) throws Exception {
		ActionHandler actionHandler = new ActionHandler();
		actionHandler.run("com.ncs.guangping.reflection.Client");
	}
}
