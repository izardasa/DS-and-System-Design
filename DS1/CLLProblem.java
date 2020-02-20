

import ds.impl.CircularLinkedList;
import ds.model.CLLNode;

public class CLLProblem {

	public static void main(String[] args) {
		CLLNode n1 = new CLLNode(10);
		CLLNode n2 = new CLLNode(20);
		CLLNode n3 = new CLLNode(30);
		CLLNode n4 = new CLLNode(40);
		CLLNode n5 = new CLLNode(50);
		CLLNode n6 = new CLLNode(60);

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n1);
		
		CircularLinkedList.iterateList(n1);
		System.out.println("Size of the linked list is "+CircularLinkedList.size(n1));
		/*CLLNode resultNode = CircularLinkedList.insertNode(n1, new CLLNode(70), 0);
		CircularLinkedList.iterateList(resultNode);
		System.out.println("Size of the linked list is "+CircularLinkedList.size(n1));
		CLLNode resultNode  = CircularLinkedList.insertNode(n1, new CLLNode(80), 1);
		CircularLinkedList.iterateList(resultNode);
		System.out.println("Size of the linked list is "+CircularLinkedList.size(resultNode));
		CLLNode resultNode1  = CircularLinkedList.insertNode(resultNode, new CLLNode(90), 9);
		CircularLinkedList.iterateList(resultNode1);
		System.out.println("Size of the linked list is "+CircularLinkedList.size(resultNode1));*/
		CLLNode resultNode = CircularLinkedList.deleteNode(n1, 3);
		CircularLinkedList.iterateList(resultNode);
		System.out.println("Size of the linked list is "+CircularLinkedList.size(resultNode));
	}

}
