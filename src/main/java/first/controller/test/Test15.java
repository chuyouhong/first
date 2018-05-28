package first.controller.test;

import java.util.ArrayList;
import java.util.List;

public class Test15 {

	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList();
		list.add("123");
		list.add("456");
		list.add("789");
		Object[] arr = list.toArray(new String[list.size()]);

		System.out.println("qqqqq");
		AThread at = new AThread(10);
		Thread t = new Thread(at);
		t.start();
		Thread.sleep(100);
		System.out.println("qqqqq");
	}

}

class AThread implements Runnable {
	private int num;

	AThread(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		while (num > 0) {
			System.out.println(num--);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
