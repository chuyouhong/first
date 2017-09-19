package first.controller.pattern;

public class RealSubject implements Subject{
	
	private String name;

	public RealSubject(String name) {
		this.name=name;
	}
	@Override
	public void request() {
		System.out.println(name+"request");
		
	}

	@Override
	public void hello() {
		System.out.println(name+"hello");
		
	}

}
