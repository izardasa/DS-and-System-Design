import ds.impl.ArrayQueue;

public class ArrayQueueProblem {

	public static void main(String[] args) {

		ArrayQueue queue = new ArrayQueue(1);
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		System.out.println("Size :"+queue.size());
		queue.enQueue(60);
		queue.enQueue(70);
		queue.enQueue(80);
		queue.enQueue(90);
		System.out.println("Size :"+queue.size());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println("Size :"+queue.size());
		
	}

}
