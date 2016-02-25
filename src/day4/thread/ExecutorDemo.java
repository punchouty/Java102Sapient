package day4.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 40; i++) {
			MyTask task = new MyTask("Name : " + i);
			fixedThreadPool.execute(task);
		}
		fixedThreadPool.shutdown();
	}

}

class MyTask implements Runnable {
	
	private String name;

	public MyTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread() + " : " + name);
		
	}
	
}
