package first.controller.test;

/**
 * 静态方法调用内部类，必须通过外部类调用
 * @author Administrator
 *
 */
class Outer {
	
	class Inner{}

	public static void foo(){new Outer().new Inner();}
	
	public void bar(){new Inner();}
	
	public static void main(String[] args) {
		
		new Outer().new Inner();
	}
}
