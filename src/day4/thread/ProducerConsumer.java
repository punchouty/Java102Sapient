package day4.thread;

import java.util.LinkedList;

public class ProducerConsumer {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		Producer producer = new Producer(list);
		Consumer consumer = new Consumer(list);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		t1.start();
		t2.start();
	}

}

class Producer implements Runnable {
	
	private final LinkedList<Integer> list;
	
	public Producer(LinkedList<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		try {
			produce();
			System.out.println("Going to sleep");
			Thread.sleep(1000);
			produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void produce() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			synchronized (list) {
				list.add(i);
				list.notify();
				System.out.println("Produced data : " + i);
			}
			
		}
	}
	
}

class Consumer implements Runnable {
	
	private final LinkedList<Integer> list;
	
	public Consumer(LinkedList<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		try {
			consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void consume() throws InterruptedException {
		while(true) {
			synchronized (list) {
				while(list.isEmpty()) {
					System.out.println("Waiting for data, it is empty");
					list.wait();
					System.out.println("Somthing got added");
				}
				int i = list.removeFirst();
				System.out.println("Consumed data : " + i);
			}
			Thread.sleep(1000);
		}
	}
	
}
