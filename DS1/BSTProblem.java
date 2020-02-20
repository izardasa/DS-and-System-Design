import ds.impl.BinarySearchTree;
import ds.model.BinarySearchTreeNode;

public class BSTProblem {

	public static void main(String[] args) {

		BinarySearchTreeNode t1 = new BinarySearchTreeNode(20);
		BinarySearchTreeNode t2 = new BinarySearchTreeNode(10);
		BinarySearchTreeNode t3 = new BinarySearchTreeNode(40);
		BinarySearchTreeNode t4 = new BinarySearchTreeNode(5);
		BinarySearchTreeNode t5 = new BinarySearchTreeNode(15);
		BinarySearchTreeNode t6 = new BinarySearchTreeNode(30);
		BinarySearchTreeNode t7 = new BinarySearchTreeNode(60);

		t1.setLeft(t2);
		t1.setRight(t3);
		t2.setLeft(t4);
		t2.setRight(t5);
		t3.setLeft(t6);
		t3.setRight(t7);

		System.out.println(BinarySearchTree.findClosest(t1,42));
//		for(Integer value :BinarySearchTree.array)
//			System.out.print(value+ " , ");
	}

}
