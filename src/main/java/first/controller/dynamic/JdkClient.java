package first.controller.dynamic;


import java.lang.reflect.Proxy;

import first.controller.pattern.RealSubject;
import first.controller.pattern.Subject;

public class JdkClient {

	public static void main(String[] args) {
		Subject subject=(Subject) Proxy.newProxyInstance(JdkClient.class.getClassLoader(),
				new Class[]{Subject.class},new JdkProxySubject(new RealSubject()));
		subject.hello();
	}

}
