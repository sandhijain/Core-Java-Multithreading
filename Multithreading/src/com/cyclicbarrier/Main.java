package com.cyclicbarrier;

package com.cyclicbarrier;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class DependentService implements Callable<String> {

    private final CyclicBarrier barrier;

    public DependentService(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started.");
        Thread.sleep(2000);
        
        // Wait at the barrier
        barrier.await();
        
        return "ok";
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        int numberOfServices = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfServices, () -> {
            System.out.println("All dependent services finished. Starting main service...");
        });
        
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        
        // Main thread waits until all tasks have completed
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
    }
}

