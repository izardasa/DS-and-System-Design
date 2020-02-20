package ds.impl;

import ds.model.CLLNode;

public class CircularLinkedList {

	public static long size(CLLNode head) {
		long sizeList = 1;
		if (null == head)
			return 0;

		CLLNode temp = head;
		while (temp.getNext() != head) {
			temp = temp.getNext();
			sizeList++;

		}
		return sizeList;
	}

	public static void iterateList(CLLNode head) {
		if (null == head) {
			System.out.print("Linked list is empty.");
			return;
		}

		CLLNode temp = head;
		while (temp.getNext() != head) {
			System.out.print(temp.getValue() + " -> ");
			temp = temp.getNext();
		}
		System.out.println(temp.getValue());
	}

	public static CLLNode insertNode(CLLNode head, CLLNode nodeToInsert, long position) {
		if (null == nodeToInsert)
			return head;

		long sizeList = size(head);

		if (position < 0 || position > sizeList + 1) {
			System.out.println("Invalid position to insert");
			return head;
		}

		if (0 == (position % sizeList)) {

			CLLNode temp = head;
			while (temp.getNext() != head) {
				temp = temp.getNext();
			}
			nodeToInsert.setNext(head);
			temp.setNext(nodeToInsert);
			head = nodeToInsert;
		} else {

			if (0 < (position % sizeList)) {
				CLLNode previousNode = head;
				long index = 1;
				while (index < position - 1) {
					previousNode = previousNode.getNext();
					index++;
				}

				CLLNode currentNode = previousNode.getNext();
				nodeToInsert.setNext(currentNode);
				previousNode.setNext(nodeToInsert);
			}
		}
		return head;
	}

	public static CLLNode deleteNode(CLLNode head, int position) {
		if (null == head)
			return head;

		long sizeList = size(head);

		if (position < 1 || position > sizeList) {
			System.out.println("Invalid position to delete");
			return head;
		}

		
		if (1 == position) {
			CLLNode temp = head;
			while(temp.getNext()!=head)
			{
			temp= temp.getNext();
			}
			temp.setNext(head.getNext());
			head = null;
			return temp.getNext();
		}

		if (1 < position) {
			CLLNode previousNode = head;
			long index = 1;
			while (index != position - 1) {
				previousNode = previousNode.getNext();
				index++;
			}

			CLLNode curNode = previousNode.getNext();
			CLLNode laterNode =  curNode.getNext() ;
			previousNode.setNext(laterNode);
		}
		return head;
	}
}
