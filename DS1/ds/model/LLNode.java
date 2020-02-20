package ds.model;

public class LLNode {
	LLNode next;
	int value;
	
	public LLNode(int value)
	{
		this.value=value;
	}
	

	public LLNode getNext() {
		return next;
	}

	public void setNext(LLNode next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
