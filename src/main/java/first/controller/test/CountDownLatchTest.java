package first.controller.test;

import java.util.concurrent.CountDownLatch;

/**
 * 工人类
 * 
 * @author 骆昊
 *
 */
class Worker {
	private String name; // 名字
	private long workDuration; // 工作持续时间

	/**
	 * 构造器
	 */
	public Worker(String name, long workDuration) {
		this.name = name;
		this.workDuration = workDuration;
	}

	/**
	 * 完成工作
	 */
	public void doWork() {
		System.out.println(name + " begins to work...");
		try {
			Thread.sleep(workDuration); // 用休眠模拟工作执行的时间
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println(name + " has finished the job...");
	}
}

/**
 * 测试线程
 * 
 * @author 骆昊
 *
 */
class WorkerTestThread implements Runnable {
	private Worker worker;
	private CountDownLatch cdLatch;

	public WorkerTestThread(Worker worker, CountDownLatch cdLatch) {
		this.worker = worker;
		this.cdLatch = cdLatch;
	}

	@Override
	public void run() {
		worker.doWork(); // 让工人开始工作
		cdLatch.countDown(); // 工作完成后倒计时次数减1
	}
}

class CountDownLatchTest {

	private static final int MAX_WORK_DURATION = 5000; // 最大工作时间
	private static final int MIN_WORK_DURATION = 1000; // 最小工作时间

	// 产生随机的工作时间
	private static long getRandomWorkDuration(long min, long max) {
		return (long) (Math.random() * (max - min) + min);
	}

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(9); // 创建倒计时闩并指定倒计时次数为2
		Worker w1 = new Worker("骆昊", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		Worker w2 = new Worker("王大锤1", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		Worker w3 = new Worker("王大锤2", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		Worker w4 = new Worker("王大锤3", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		Worker w5 = new Worker("王大锤4", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		Worker w6 = new Worker("王大锤5", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		Worker w7 = new Worker("王大锤6", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		Worker w8 = new Worker("王大锤7", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		Worker w9 = new Worker("王大锤8", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		new Thread(new WorkerTestThread(w1, latch)).start();
		new Thread(new WorkerTestThread(w2, latch)).start();
		new Thread(new WorkerTestThread(w3, latch)).start();
		new Thread(new WorkerTestThread(w4, latch)).start();
		new Thread(new WorkerTestThread(w5, latch)).start();
		new Thread(new WorkerTestThread(w6, latch)).start();
		new Thread(new WorkerTestThread(w7, latch)).start();
		new Thread(new WorkerTestThread(w8, latch)).start();
		new Thread(new WorkerTestThread(w9, latch)).start();
		

		try {
			latch.await(); // 等待倒计时闩减到0
			System.out.println("All jobs have been finished!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}