import ds.impl.LLQueue;

public class LLQueueProblem {

	public static void main(String[] args) {

		LLQueue queue = LLQueue.createQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);queue.enqueue(90);
		queue.enqueue(70);
		queue.enqueue(80);
		
		System.out.println(queue.dequque());
		System.out.println(queue.dequque());
		System.out.println(queue.dequque());
		System.out.println(queue.dequque());
		System.out.println(queue.dequque());
		System.out.println(queue.dequque());
	}

}
