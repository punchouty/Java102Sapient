package day4.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ArrayList<Future<String>> futures = new ArrayList<>();
		ArrayList<MyCallable> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			MyCallable c = new MyCallable(i + "");
			list.add(c);
		}
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (MyCallable myCallable : list) {
			futures.add(fixedThreadPool.submit(myCallable));
		}
		int k = 0;
		for (Future<String> future : futures) {
			if(k%2 == 0) System.out.println(future.get());
			else future.cancel(true);
		}
		fixedThreadPool.shutdown();
	}
}

class MyCallable implements Callable<String> {
	
	private String name;
	
	public MyCallable(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);;
		return "Name : " + name + " Date" + new Date();
	}
	
}
