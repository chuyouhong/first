package first.controller.test;

public class Test15 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("qqqqq");
		AThread at = new AThread();
		Thread t = new Thread(at);
		t.start();
		Thread.sleep(10000);
		System.out.println("qqqqq");
	}

}

class AThread implements Runnable {
	int num = 100;

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
