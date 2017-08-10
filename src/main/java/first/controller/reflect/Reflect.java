package first.controller.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import first.model.HospitalInfo;

public class Reflect {

	public static void main(String[] args) throws Exception {
		test1();
		test2();
		HospitalInfo ha=new HospitalInfo();
		test3(ha,"setName","zhangsan");
		test4();
	}
	
	public static void test1(){
		Class c = HospitalInfo.class;
		Method[] m = c.getMethods();
		for(int i=0,len=m.length;i<len;i++){
			System.out.println(m[i].getName());
		}
		Field[] fs=c.getFields();
		for(Field f:fs){
			System.out.println(f.getName()+""+f.getType());
		}
	}
	
	public static void test2() throws Exception{
		Class e=Class.forName("first.model.HospitalInfo");
		HospitalInfo h = (HospitalInfo) e.newInstance();
		h.setUrl("www.baidu.com");
		h.setName("hospital");
		h.show();
	}
	
	public static void test3(HospitalInfo h,String setName,String name) throws Exception{
		Class c=h.getClass();
		Method set=c.getMethod(setName, new Class[]{String.class});
		set.invoke(h, new Object[]{name});
		h.show();
	}
	
	public static void test4(){
		try {
			Class cls=Class.forName("first.model.HospitalInfo");
			Object arr= Array.newInstance(cls, 10);
			HospitalInfo a = new HospitalInfo();
			a.setName("this is a test");
			Array.set(arr, 5, a);
			HospitalInfo s=(HospitalInfo) Array.get(arr, 5);
			System.out.println(s.getName());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
