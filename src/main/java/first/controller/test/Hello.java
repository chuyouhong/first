package first.controller.test;

/**
 * 类加载的时候先加载方法块，在加载父类构造方法，再加载自己的方法
 * @author Administrator
 *
 */
public class Hello {

	public static void main(String[] args) {
		A a=new B();
		a=new B();
	}
}

class A {
	public static String aaa="aaa";
	static{
		System.out.println(1);
	}
	public A(){
		System.out.println(2);
	}
}

class B extends A{
	public static String bbb="bbb";
	static {
		System.out.println("a");
	}
	public B(){
		System.out.println("b");
	}
}