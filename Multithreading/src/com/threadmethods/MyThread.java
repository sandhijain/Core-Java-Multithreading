package com.threadmethods;

public class MyThread extends Thread {
	
	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		 System.out.println("Thread is Running...");
		 for(int i=1;i<=5;i++) {
//			 String a = "";
			 for(int j=0; j<5; j++) {
//				 a += a;
				 System.out.println(Thread.currentThread().getName()+ " - Priority: "+ Thread.currentThread().getPriority() + " - count: " + i);
				 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		}
			  
		 }
	

	public static void main(String[] args) throws InterruptedException {
		 
		MyThread l = new MyThread("Low Priority Thread");
		MyThread m  = new MyThread("Medium Priority Thread");
		MyThread n = new MyThread("High Priority Thread");
		
		l.setPriority(Thread.MIN_PRIORITY);
		m.setPriority(Thread.NORM_PRIORITY);
		n.setPriority(Thread.MAX_PRIORITY);
		l.start();
		m.start();
		n.start();
		 
	}
}
