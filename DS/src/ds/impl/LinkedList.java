package ds.impl;

import ds.model.LLNode;

public class LinkedList {

	public static long size(LLNode node) {
		long sizeList = 0;
		if (null == node)
			return sizeList;

		while (null != node) {
			node = node.getNext();
			sizeList++;

		}
		return sizeList;
	}

	public static void iterateList(LLNode node) {
		if (null == node) {
			System.out.println("Linked list is empty.");
			return;
		}
		while (null != node) {
			System.out.println(node.getValue() + " -> ");
		}
		System.out.println("NULL");
	}

	public static LLNode insertNode(LLNode head, LLNode nodeToInsert, long position) {
		if (null == head || null == nodeToInsert)
			return head;

		long sizeList = size(head);

		if (position < 1 || position > sizeList + 1) {
			System.out.println("Invalid position to insert");
			return head;
		}

		if (1 == position) {
			nodeToInsert.setNext(head);
			head = null;
			return nodeToInsert;
		}

		if (1 < position) {
			LLNode previousNode = head;
			long index = 1;
			while (index != position - 1) {
				previousNode = previousNode.getNext();
				index++;
			}

			LLNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
		}
		return head;
	}

	public static LLNode deleteNode(LLNode head, int position) {
		if (null == head)
			return head;

		long sizeList = size(head);

		if (position < 1 || position > sizeList) {
			System.out.println("Invalid position to delete");
			return head;
		}

		if (1 == position) {
			LLNode temp = head.getNext();
			head = null;
			return temp;
		}

		if(1<position){
			LLNode previousNode = head;
			long index=1;
			while(index != position-1){
				previousNode = previousNode.getNext();
			}
			
			LLNode curNode = previousNode.getNext();
			LLNode laterNode = null != curNode.getNext()?curNode.getNext():null;
			previousNode.setNext(laterNode);
			curNode=null;
		}
		return head;
	}
}
