package com.executorsFramework;
//Threads are not reused

public class Main {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis(); //Milliseconds from 1 JAN 1970
		Thread[] threads = new Thread[9];
		for(int i=1;i<10;i++) {
			int finalI = i;
			threads[i-1] = new Thread(
					
					() -> {
						long result = factorial(finalI); //Value should be effectively final, this means that i should not change.
						System.out.println(result);
					}
	);
			threads[i-1].start();
			
			 
		}
		
		for(Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				 Thread.currentThread().interrupt();
			}
		}
		
		System.out.println("Total time: "+ (System.currentTimeMillis() - startTime));
	}
	
	private static long factorial(int n) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		throw new RuntimeException(e);
		}
		long result = 1;
		for(int i=1;i<=n;i++) {
			result *=i;
		}
		return result;
	}

}
