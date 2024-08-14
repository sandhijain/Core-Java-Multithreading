package com.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class DependentService implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+ " service started.");
		Thread.sleep(1000);
		return "ok";
	}
	
}
public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException   {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Future<String> future1 = executorService.submit(new DependentService());
		Future<String> future2 = executorService.submit(new DependentService());
		Future<String> future3 = executorService.submit(new DependentService());
		
		future1.get();
		future2.get();
		future3.get();
		
		System.out.println("All dependent services finished. Starting main service...");
		executorService.shutdown();
		
	}

}
