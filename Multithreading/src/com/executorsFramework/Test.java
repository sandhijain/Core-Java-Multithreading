package com.executorsFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis(); //Milliseconds from 1 JAN 1970
		 ExecutorService executorService = Executors.newFixedThreadPool(9);
		 
		for(int i=1;i<10;i++) {
			int finalI = i;
			executorService.submit(
			 
					() -> {
						long result = factorial(finalI); //Value should be effectively final, this means that i should not change.
						System.out.println(result);
					}
	);
}
		executorService.shutdown(); //Since threads are being reused, so we need to shutdown.
		
		 
		try {
			while(!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {
			System.out.println("Waiting...");
		}} catch (InterruptedException e) {
			
			e.printStackTrace();
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
