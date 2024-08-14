package com.threadmethods;

public class MyThread1 extends Thread{
	

	@Override
	public void run() {
		
		for(int i=0; i<5;i++) {
			System.out.println(Thread.currentThread().getName() + " is running...");
			Thread.yield();
		}
		
//		 try {
//			Thread.sleep(1000);
//			System.out.println("Thread is running ...");
//		} catch (InterruptedException e) {
//			 System.out.println("Thread interrupted: "+e);
//		}
	}


	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		MyThread1 t2 = new MyThread1();
		t1.start();
		//t1.interrupt(); //Thread interrupted: java.lang.InterruptedException: sleep interrupted
	    t2.start();
		
		
	}
}
