package ds.model;

public class DLLNode {
	DLLNode next;
	DLLNode pre;
	public DLLNode getPre() {
		return pre;
	}


	public void setPre(DLLNode pre) {
		this.pre = pre;
	}

	int value;
	
	public DLLNode(int value)
	{
		this.value=value;
	}
	

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
