import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
	private Queue<E> queue;
	private int capacity;
	private ReentrantLock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();

	public MyBlockingQueue(int capacity) {
		super();
		this.queue = new LinkedList<>();
		this.capacity = capacity;
	}

	public void put(E e) throws InterruptedException {
		lock.lock();
		try {
			while(queue.size()==capacity)
			{
				notFull.await();
			}
			queue.add(e);
			System.out.println("Item added"+e);
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public E take() throws InterruptedException {
		lock.lock();
		try {
			while(queue.size()==0)
			{
				notEmpty.await();
			}
			E item = queue.remove();
			System.out.println("Item Removed"+item);
			notFull.signalAll();
			return item;
		} finally {
			lock.unlock();
		}
	}

}
