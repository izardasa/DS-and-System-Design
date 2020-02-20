package ds.impl;

import ds.model.DLLNode;

public class DoublyLinkedList {

	public static long size(DLLNode node) {
		long sizeList = 0;
		if (null == node)
			return sizeList;

		while (null != node) {
			node = node.getNext();
			sizeList++;

		}
		return sizeList;
	}

	public static void iterateList(DLLNode node) {
		if (null == node) {
			System.out.print("Linked list is empty.");
			return;
		}
		while (null != node) {
			System.out.print(node.getValue() + " -> ");
			node = node.getNext();
		}
		System.out.println("NULL");
	}

	public static DLLNode insertNode(DLLNode head, DLLNode nodeToInsert, long position) {
		if (null == head || null == nodeToInsert)
			return head;

		long sizeList = size(head);

		if (position < 1 || position > sizeList + 1) {
			System.out.println("Invalid position to insert");
			return head;
		}

		if (1 == position) {
			nodeToInsert.setNext(head);
			head.setPre(nodeToInsert);
			head = null;
			return nodeToInsert;
		}

		if (1 < position) {
			DLLNode previousNode = head;
			long index = 1;
			while (index != position - 1) {
				previousNode = previousNode.getNext();
				index++;
			}

			DLLNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			nodeToInsert.setPre(previousNode);
			previousNode.setNext(nodeToInsert);
			if (null != currentNode)
				currentNode.setPre(nodeToInsert);
		}
		return head;
	}

	public static DLLNode deleteNode(DLLNode head, int position) {
		if (null == head)
			return head;

		long sizeList = size(head);

		if (position < 1 || position > sizeList) {
			System.out.println("Invalid position to delete");
			return head;
		}

		if (1 == position) {
			DLLNode temp = head.getNext();
			head = null;
			return temp;
		}

		if (1 < position) {
			DLLNode previousNode = head;
			long index = 1;
			while (index != position - 1) {
				previousNode = previousNode.getNext();
				index++;
			}

			DLLNode curNode = previousNode.getNext();
			DLLNode laterNode = null != curNode.getNext() ? curNode.getNext() : null;
			previousNode.setNext(laterNode);
			if (null != laterNode)
				laterNode.setPre(previousNode);
			curNode = null;
		}
		return head;
	}
}
