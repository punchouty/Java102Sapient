package day4.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import day4.thread.SychThread.Type;

public class SynchronizeDemo {

	public static void main(String[] args) throws InterruptedException {
		Data data = new Data();
		SychThread st1 = new SychThread(data, Type.INCREMENTING);
		SychThread st2 = new SychThread(data, Type.DECREMENTING);
		Thread t1 = new Thread(st1);
		Thread t2 = new Thread(st2);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(data.getI());
	}

}

class Data {
	int i = 0;
	private Object o = new Object();
	private Lock lock = new ReentrantLock();
	
	public void increment() {
		lock.lock();
		i++;
		lock.unlock();
	}

	public void decrement() {
		lock.lock();
		i--;
		lock.unlock();
	}

//	public synchronized void increment() {
//		i++;
//	}
//
//	public synchronized void decrement() {
//		i--;
//	}

	public int getI() {
		return i;
	}
}

class SychThread implements Runnable {
	
	public enum Type {
		INCREMENTING, DECREMENTING
	}

	private final Data data;
	private final Type type;
	
	SychThread(Data data, Type type) {
		this.data = data;
		this.type = type;
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			if(type == Type.INCREMENTING) data.increment();
			else data.decrement();
			
		}
		
	}
}
