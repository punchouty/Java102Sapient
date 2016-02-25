package day4.thread;

public class PrimeCalculator implements Runnable {

	private final int min; 
	private final int max;
	private boolean print = false;
	private static long startTime = 0;
	private static long endTime = 0;

	public PrimeCalculator(int min, int max) {
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
		}
		long end = System.nanoTime();
		System.out.println(Thread.currentThread() + " - Time taken in milliseconds : " + ((end - start)/1000000));
		System.out.println(primeNumbers);
	}

	public static void main(String[] args) {
		//singleThread();
		multithreaded();
	}

	private static void multithreaded() {
		startTime = System.nanoTime();
		PrimeCalculator c1 = new PrimeCalculator(0, 50000);
		Thread thread1 = new Thread(c1);
		thread1.setName("Thread 1");
		PrimeCalculator c2 = new PrimeCalculator(50000, 75000);
		Thread thread2= new Thread(c2);
		thread2.setName("Thread 2");
		PrimeCalculator c3 = new PrimeCalculator(75000, 100000);
		Thread thread3 = new Thread(c3);
		thread3.setName("Thread 3");
		thread1.start();
		thread2.start();
		thread3.start();
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endTime = System.nanoTime();
		System.out.println("TOTAL TIME : " + ((endTime - startTime)/1000000));
	}

	private static void singleThread() {
		startTime = System.nanoTime();
		PrimeCalculator c1 = new PrimeCalculator(0, 50000);
		c1.run();
		
		PrimeCalculator c2 = new PrimeCalculator(50000, 75000);
		c2.run();
		
		PrimeCalculator c3 = new PrimeCalculator(75000, 100000);
		c3.run();
		endTime = System.nanoTime();
		System.out.println("TOTAL TIME : " + ((endTime - startTime)/1000000));
	}
	
	private static void multithreadedWithPriority() {
		startTime = System.nanoTime();
		PrimeCalculator c1 = new PrimeCalculator(0, 50000);
		Thread thread1 = new Thread(c1);
		thread1.setName("Thread 1");
		PrimeCalculator c2 = new PrimeCalculator(50000, 75000);
		Thread thread2= new Thread(c2);
		thread2.setName("Thread 2");
		PrimeCalculator c3 = new PrimeCalculator(75000, 100000);
		Thread thread3 = new Thread(c3);
		thread3.setName("Thread 3");
		thread1.start();
		thread2.start();
		thread3.start();
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endTime = System.nanoTime();
		System.out.println("TOTAL TIME : " + ((endTime - startTime)/1000000));
	}

}
