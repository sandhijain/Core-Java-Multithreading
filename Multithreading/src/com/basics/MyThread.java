package com.basics;

public class MyThread extends Thread {
	

	@Override
	public void run() {
		/*
		 * Why using try/catch block instead of throws declaration??
		 * We are overriding already declared run method
		 * Original run method is:
		 *
		 @Override
           public void run() {
           if (target != null) {
            target.run();
            }
            }
		 Since it originally does not throw any exception we use try/catch
		 * 
		 */
		System.out.println("RUNNING"); //RUNNING
		try {
			Thread.sleep(2000); //t1 ke execution ko pause karwana
		} catch (InterruptedException e) {
		 System.out.println(e);
		 
		}
		 
	}

	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		System.out.println(t1.getState()); //NEW
		t1.start();
		System.out.println(t1.getState()); //RUNNABLE
		Thread.sleep(100); //Run method ko chalne ka mauka and time dena. Main method is paused.
		System.out.println(t1.getState()); //TIMED_WAITING
		
		
		t1.join(); //Jis thread par join method call kiya jata hai
				  //uske finish hone ka wait kar raha hai main method
		         //join method ko chalane wala is main method
		
		System.out.println(t1.getState()); //TERMINATED
		
	}
	
}
