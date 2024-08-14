package com.executorsFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureClass {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<?> future = executorService.submit(()->System.out.println("Hello"));

		System.out.println(future.get()); //waits for the computation to complete
		if(future.isDone()) {
			System.out.println("Task is done !");
		}
		executorService.shutdown();
	}

}
