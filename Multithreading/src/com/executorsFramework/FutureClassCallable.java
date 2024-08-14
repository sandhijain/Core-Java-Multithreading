package com.executorsFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureClassCallable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<String> runnable = () -> "Hello";
		Future<String> future = executorService.submit(runnable);

		System.out.println(future.get());
		if(future.isDone()) {
			System.out.println("Task is done !");
		}
		executorService.shutdown();
	}

}


