package com.blockingqueueexample.example;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	private BlockingQueue queue;
	public Producer(BlockingQueue queue)
	{
		super();
		this.queue = queue;
	}
	@Override
	public void run() {
		for(int i=0;i<=20;i++)
		{
			try {
				System.out.println("produced "+String.valueOf(i));
				queue.put(String.valueOf(i));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
