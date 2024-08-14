package com.basics;

public class Main {

	public static void main(String[] args) {
		 
		
		World1 impl = new World1();
//		impl.start(); 
	/* 
	 * impl.start() will not work as runnable interface does not
	 * have start() method. Hence we create an instance of thread class.
	 * start() method is present in Thread class.
	 */
		
	Thread t1 = new Thread(impl);
	t1.start();
	for(;;) {
//			System.out.println(Thread.currentThread().getName());
			System.out.println("Hello");
		}
	}

}
