package first.controller.dynamic;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import first.controller.pattern.RealSubject;
import first.controller.pattern.Subject;

public class JdkClient {

	public static void main(String[] args) {
//		Subject subject=(Subject) Proxy.newProxyInstance(JdkClient.class.getClassLoader(),
//				new Class[]{Subject.class},new JdkProxySubject(new RealSubject("歷史")));
//		subject.hello();
		
		//要代理的真实对象
		Subject subject =new RealSubject("张三");
		//创建中介类实例
		InvocationHandler  handler = new JdkProxySubject(subject);
		//获取类加载器
		ClassLoader cl = subject.getClass().getClassLoader();
        //动态产生一个代理类
		Subject proxy = (Subject) Proxy.newProxyInstance(cl, subject.getClass().getInterfaces(), handler);
        //通过代理类，执行doSomething方法；
        proxy.request();
		
	}

}
