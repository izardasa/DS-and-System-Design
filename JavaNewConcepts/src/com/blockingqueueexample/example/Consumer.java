package com.blockingqueueexample.example;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue queue;

	public Consumer(BlockingQueue queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true){
			try {
				System.out.println("Consumed :"+(String)queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
