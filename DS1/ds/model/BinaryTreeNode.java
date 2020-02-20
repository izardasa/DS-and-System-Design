package ds.model;

public class BinaryTreeNode {
int value;
BinaryTreeNode left;
BinaryTreeNode right;
BinaryTreeNode parent;

public BinaryTreeNode getParent()
{
    return parent;
}
public void setParent( BinaryTreeNode parent )
{
    this.parent = parent;
}
public BinaryTreeNode(int value)
{
	this.value = value;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public BinaryTreeNode getLeft() {
	return left;
}
public void setLeft(BinaryTreeNode left) {
	this.left = left;
}
public BinaryTreeNode getRight() {
	return right;
}
public void setRight(BinaryTreeNode right) {
	this.right = right;
}

}
