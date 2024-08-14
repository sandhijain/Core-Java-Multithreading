package com.threadmethods;
 

public class UserThread extends Thread {
	
	
	
@Override
	public void run() {
	 
	while(true) {
		System.out.println("Hello world! " + Thread.currentThread().getName());
	 
	}
	}

public static void main(String[] args) {
	UserThread d1 = new UserThread(); 
	d1.setDaemon(true);
//	UserThread d2 = new UserThread(); 
//	d2.start();
	//d1 is User thread - jo useful work karta hai
	// business logic implement karta hai
	d1.start();
	System.out.println("Main Done");
	
	
//DAEMON THREADS - those threads which run in background (for ex. in Java - Garbage collector)
// JVM does not wait for these threads.	
	
	
	
	
}
}
