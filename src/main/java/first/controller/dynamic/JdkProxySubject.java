package first.controller.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import first.controller.pattern.Subject;

public class JdkProxySubject implements InvocationHandler{
	
	//被代理的实例
	private Subject subject;
	
	public JdkProxySubject(Subject subject) {
		this.subject=subject;
	}
	
	//调用被代理的方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		System.out.println("before");
		Object result=null;
		try{
			result=method.invoke(subject, args);
		}catch(Exception e){
			System.out.println("ex:"+e.getMessage());
			throw e;
		}finally{
			System.out.println("after");
		}
		return result;
	}

}
