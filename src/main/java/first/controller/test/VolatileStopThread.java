package first.controller.test;

public class VolatileStopThread extends Thread {
	private volatile boolean stop = false;

	public void stopMe() {
		stop = true;
	}

	public void run() {
		int i = 0;
		while (!stop) {
			i++;
			System.out.println("i:"+i);
		}
		System.out.println("Stop thread");
	}

	public static void main(String args[]) throws InterruptedException {

		VolatileStopThread t = new VolatileStopThread();
		t.start();
		Thread.sleep(1000);
		t.stopMe();
		Thread.sleep(1000);
		long a = Runtime.getRuntime().totalMemory();
		String b=a/1024.0/1024 +"M";
		System.out.println(b);
	}
}
