package first.controller.pattern;

public class Client {

	public static void main(String[] args) {
		Subject subject=new Proxy(new RealSubject("張三"));
		subject.request();
	}

}
