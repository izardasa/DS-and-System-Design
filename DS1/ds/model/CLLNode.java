package ds.model;

public class CLLNode {
	CLLNode next;
	int value;
	
	public CLLNode(int value)
	{
		this.value=value;
	}
	

	public CLLNode getNext() {
		return next;
	}

	public void setNext(CLLNode next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
