package com.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class DependentService implements Callable<String>{

	private final CountDownLatch latch;

	public DependentService(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+ " service started.");
		Thread.sleep(2000);
		return "ok";
	}
	
}
public class CountDownLatchExample {
	public static void main(String[] args) throws InterruptedException {
		
		int numberOfServices = 3;
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
		CountDownLatch latch = new CountDownLatch(numberOfServices);
		executorService.submit(new DependentService(latch));
		executorService.submit(new DependentService(latch));
		executorService.submit(new DependentService(latch));
		latch.await(5, TimeUnit.SECONDS);
		System.out.println("Main");
		executorService.shutdown();
	}

}
