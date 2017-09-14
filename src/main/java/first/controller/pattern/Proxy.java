package first.controller.pattern;

public class Proxy implements Subject{
	
	private RealSubject realSubject;
	
	public Proxy(RealSubject realSubject) {
		this.realSubject=realSubject;
	}
	@Override
	public void request() {
		System.out.println("before");
		try{
			realSubject.request();
		}catch(Exception e){
			System.out.println("ex:"+e.getMessage());
			throw e;
		}finally{
			System.out.println("after");
		}
	}
	@Override
	public void hello() {
		System.out.println("before");
		try{
			realSubject.hello();
		}catch(Exception e){
			System.out.println("ex:"+e.getMessage());
			throw e;
		}finally{
			System.out.println("after");
		}
		
	}

}
