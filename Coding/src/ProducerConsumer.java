import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {

	public static void main(String[] args) {
		MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Set<Runnable> runnables = new HashSet<Runnable>();
		
		Runnable producer = () -> {
			try {
				for (int i = 0; i < 30; i++) {
					queue.put(i);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Runnable producer1 = () -> {
			try {
				for (int i = 31; i < 60; i++) {
					queue.put(i);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Runnable producer2 = () -> {
			try {
				for (int i = 60; i < 100; i++) {
					queue.put(i);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Runnable consumer = () -> {
			Integer value;
			try {
				for (int i = 0; i < 100; i++) {
					value = queue.take();	
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		};
		
		executorService.submit(producer);
		executorService.submit(producer1);
		executorService.submit(producer2);
		executorService.submit(consumer);
	}

}
