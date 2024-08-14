package com.executorsFramework;

import java.util.concurrent.Callable;

public class CallableTask implements Callable {

	@Override
	public Object call() throws Exception {
		 Thread.sleep(100);
		return null;
	}
 

}
