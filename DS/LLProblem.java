

import ds.impl.LinkedList;
import ds.model.LLNode;

public class LLProblem {

	public static void main(String[] args) {
		LLNode n1 = new LLNode(10);
		LLNode n2 = new LLNode(20);
		LLNode n3 = new LLNode(30);
		LLNode n4 = new LLNode(40);
		LLNode n5 = new LLNode(50);
		LLNode n6 = new LLNode(60);

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(null);
		
		LinkedList.iterateList(n1);
		LinkedList.size(n1);
	}

}
