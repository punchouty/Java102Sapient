package day4.thread;

public class FactorialDemo implements Runnable{
	
	private final int i;

	public FactorialDemo(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println("Start : " + Thread.currentThread() + " : " + System.nanoTime());
		int result = calculate(i);
		System.out.println("Start : " + Thread.currentThread() + " : " + System.nanoTime());
		System.out.println(Thread.currentThread() + " : " + result);
		
	}

	int calculate(int n) {
		int result;
		if (n == 0 || n == 1)
			return 1;

		result = calculate(n - 1) * n;
		return result;
	}

	public static void main(String[] args) {
		FactorialDemo demo = new FactorialDemo(100);
		demo.run();
	}

}
