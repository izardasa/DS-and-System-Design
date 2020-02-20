package ds.model;

public class BinaryTreeNodeWithNext {
int value;
BinaryTreeNodeWithNext left;
BinaryTreeNodeWithNext right;
BinaryTreeNodeWithNext next;
public BinaryTreeNodeWithNext getNext() {
	return next;
}
public void setNext(BinaryTreeNodeWithNext next) {
	this.next = next;
}
public BinaryTreeNodeWithNext(int value)
{
	this.value = value;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public BinaryTreeNodeWithNext getLeft() {
	return left;
}
public void setLeft(BinaryTreeNodeWithNext left) {
	this.left = left;
}
public BinaryTreeNodeWithNext getRight() {
	return right;
}
public void setRight(BinaryTreeNodeWithNext right) {
	this.right = right;
}

}
