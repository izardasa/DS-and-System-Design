

import ds.impl.DoublyLinkedList;
import ds.model.DLLNode;

public class DLLProblem {

	public static void main(String[] args) {
		DLLNode n1 = new DLLNode(10);
		DLLNode n2 = new DLLNode(20);
		DLLNode n3 = new DLLNode(30);
		DLLNode n4 = new DLLNode(40);
		DLLNode n5 = new DLLNode(50);
		DLLNode n6 = new DLLNode(60);

		n1.setNext(n2);
		n1.setPre(null);
		n2.setNext(n3);
		n2.setPre(n1);
		n3.setNext(n4);
		n3.setPre(n2);
		n4.setNext(n5);
		n4.setPre(n3);
		n5.setNext(n6);
		n5.setPre(n4);
		n6.setNext(null);
		n6.setPre(n5);
		
		DoublyLinkedList.iterateList(n1);
		System.out.println("Size of the linked list is "+DoublyLinkedList.size(n1));
		DoublyLinkedList.insertNode(n1, new DLLNode(70), 3);
		DoublyLinkedList.iterateList(n1);
		System.out.println("Size of the linked list is "+DoublyLinkedList.size(n1));
		DLLNode resultNode  = DoublyLinkedList.insertNode(n1, new DLLNode(80), 1);
		DoublyLinkedList.iterateList(resultNode);
		System.out.println("Size of the linked list is "+DoublyLinkedList.size(resultNode));
		DLLNode resultNode1  = DoublyLinkedList.insertNode(resultNode, new DLLNode(90), 9);
		DoublyLinkedList.iterateList(resultNode1);
		System.out.println("Size of the linked list is "+DoublyLinkedList.size(resultNode1));
		/*DLLNode resultNode =DoublyLinkedList.deleteNode(n1, 3);
		DoublyLinkedList.iterateList(resultNode);
		System.out.println("Size of the linked list is "+DoublyLinkedList.size(resultNode));*/
	}

}
