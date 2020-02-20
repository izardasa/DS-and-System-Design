import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorServiceDemo {

	private ReentrantLock lock = new ReentrantLock();

	public void acquireLock() {
		lock.lock();
		if (lock.getHoldCount() >= 10) {
			System.out.println(lock.getHoldCount());
		}

		if(lock.getHoldCount()<13)
		{
		acquireLock();
		}

		lock.unlock();

	}

	public static void main(String[] args) {
		ExecutorServiceDemo demo = new ExecutorServiceDemo();
		demo.acquireLock();
	}

}

class MyTask implements Callable<Integer> {

	private Random random = new Random();

	@Override
	public Integer call() throws Exception {
		// Thread.sleep(4000);
		return random.nextInt(100);
	}

}