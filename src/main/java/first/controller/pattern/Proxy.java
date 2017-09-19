package first.controller.pattern;

public class Proxy implements Subject{
	
	private Subject subject;
	
	public Proxy(Subject subject) {
		this.subject=subject;
	}
	
	
	@Override
	public void request() {
		System.out.println("before");
		try{
			subject.request();
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
			subject.hello();
		}catch(Exception e){
			System.out.println("ex:"+e.getMessage());
			throw e;
		}finally{
			System.out.println("after");
		}
		
	}

}
