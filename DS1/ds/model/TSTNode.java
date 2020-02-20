package ds.model;

public class TSTNode {

	char data;
	TSTNode right;
	TSTNode left;
	TSTNode equal;
	boolean isEndOfString;
	
	
	public TSTNode(char data)
	{
		this.data = data;
	}
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public TSTNode getRight() {
		return right;
	}
	public void setRight(TSTNode right) {
		this.right = right;
	}
	public TSTNode getLeft() {
		return left;
	}
	public void setLeft(TSTNode left) {
		this.left = left;
	}
	public TSTNode getEqual() {
		return equal;
	}
	public void setEqual(TSTNode equal) {
		this.equal = equal;
	}
	public boolean isEndOfString() {
		return isEndOfString;
	}
	public void setEndOfString(boolean isEndOfString) {
		this.isEndOfString = isEndOfString;
	}
}
