package day4.thread;

import java.util.ArrayList;

public class ThreadPriority implements Runnable{

	private final int min; 
	private final int max;
	private boolean print = false;
	private static long startTime = 0;
	private static long endTime = 0;
	
	private static int poolSize = 100;
	
	public ThreadPriority(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	public void run() {
		long start = System.nanoTime();
		int i = 0;
		int num = 0;
		String  primeNumbers = "";
		for (i = min; i <= max; i++) {
			int counter = 0;
			for (num = i; num >= 1; num--) {
				if (i % num == 0) {
					counter = counter + 1;
				}
			}
			if (counter == 2) {
				if(print) primeNumbers = primeNumbers + i + " ";
			}
			Thread.yield();
		}
		long end = System.nanoTime();
		System.out.println(Thread.currentThread() + " - Time taken in milliseconds : " + ((end - start)/1000000));
		System.out.println(primeNumbers);
	}

	public static void main(String[] args) {
		startTime = System.nanoTime();
		ArrayList<Thread> list = new ArrayList<>();
		for (int i = 0; i < poolSize; i++) {
			ThreadPriority t = new ThreadPriority(0, 20000);
			Thread thread = new Thread(t);
			thread.setName("Thread : " + i);
			if(i<(poolSize/3)) thread.setPriority(Thread.MIN_PRIORITY);
			else if(i>=(poolSize/3) && i<((poolSize * 2)/3)) thread.setPriority(Thread.NORM_PRIORITY);
			else thread.setPriority(Thread.MAX_PRIORITY);
			//System.out.println(thread.getName() + " : " + thread.getPriority());
			list.add(thread);
		}
		for (Thread thread : list) {
			thread.start();
		}
		for (Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.nanoTime();
		System.out.println("TOTAL TIME : " + ((endTime - startTime)/1000000));
	}

}
