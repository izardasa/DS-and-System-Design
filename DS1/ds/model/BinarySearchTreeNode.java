package ds.model;

public class BinarySearchTreeNode {
int value;
BinarySearchTreeNode left;
BinarySearchTreeNode right;

public BinarySearchTreeNode(int value)
{
	this.value = value;
}
public BinarySearchTreeNode() {
	// TODO Auto-generated constructor stub
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public BinarySearchTreeNode getLeft() {
	return left;
}
public void setLeft(BinarySearchTreeNode left) {
	this.left = left;
}
public BinarySearchTreeNode getRight() {
	return right;
}
public void setRight(BinarySearchTreeNode right) {
	this.right = right;
}

}
