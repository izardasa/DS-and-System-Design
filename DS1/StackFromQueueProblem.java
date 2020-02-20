import ds.impl.ArrayQueue;
import ds.impl.StackFromQueue;

public class StackFromQueueProblem {

	public static void main(String[] args) {
		ArrayQueue q1 = new ArrayQueue(1);
		ArrayQueue q2 = new ArrayQueue(1);
		StackFromQueue s = new StackFromQueue(q1, q2);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(140);
		s.push(50);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
