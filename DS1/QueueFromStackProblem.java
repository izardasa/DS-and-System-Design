import ds.impl.ArrayStack;
import ds.impl.QueueFromStack;

public class QueueFromStackProblem {

	public static void main(String[] args) {
		ArrayStack stack1 = new ArrayStack();

		ArrayStack stack2 = new ArrayStack();
		
		QueueFromStack queue = new QueueFromStack(stack1, stack2);
		
		queue.enqeue(10);
		queue.enqeue(20);
		queue.enqeue(30);
		queue.enqeue(40);
		queue.enqeue(50);
		queue.enqeue(60);
		queue.enqeue(70);
		
		queue.enqeue(80);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
	}

}
