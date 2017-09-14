package first.controller.pattern;

public class RealSubject implements Subject{

	@Override
	public void request() {
		System.out.println("request");
		
	}

	@Override
	public void hello() {
		System.out.println("hello");
		
	}

}
