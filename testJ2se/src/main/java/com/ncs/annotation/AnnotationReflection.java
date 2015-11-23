package com.ncs.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationReflection {

	public static void main(String[] args) throws Exception {
		
		MyClass myClass = new MyClass();
		Class<?> clazz = MyClass.class;
		Method method = clazz.getMethod("test",new Class[]{});
		//Check whether the annotation type is exist for this method or not.
		if(method.isAnnotationPresent(MyAnnotation.class)){ //this only work when the retention type is runtime.
			method.invoke(myClass, new Object[]{});
			//Get the annotation type
			MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
			System.out.println(myAnnotation.name());;
		}
		//Get all annotations for this method
		Annotation[] anns = method.getAnnotations();
		for(Annotation ann : anns){
			System.out.println(ann.annotationType().getName());
		}
	}
	
}
