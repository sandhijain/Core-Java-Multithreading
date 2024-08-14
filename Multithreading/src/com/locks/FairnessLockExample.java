package com.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {
	
	private final Lock lock = new ReentrantLock();
	
	public void accessResource() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() +" acquired the lock" );
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}finally {
			System.out.println(Thread.currentThread().getName()+ " released the lock");
			lock.unlock();
		}
	}

	
	public static void main(String[] args) {
		FairnessLockExample example = new FairnessLockExample();
		
		Runnable taskRunnable = new Runnable() {
			@Override
			public void run() {
				 example.accessResource();
	}
};

	Thread thread1 = new Thread(taskRunnable, "Thread1");
	Thread thread2 = new Thread(taskRunnable, "Thread2");
	Thread thread3 = new Thread(taskRunnable, "Thread3");
	
	try {
		thread1.start();
		Thread.sleep(500);
		thread2.start();
		Thread.sleep(500);
		thread3.start();
		 
	}catch (Exception e) {
		 
	}
	}
}
