package ds.impl;

import java.util.ArrayList;
import java.util.List;

import ds.model.BinarySearchTreeNode;

public class BinarySearchTree {
	public static void preOrderTraversal(BinarySearchTreeNode root) {
		if (null == root)
			return;

		System.out.println(root.getValue());
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());

	}

	public static void InOrderTraversal(BinarySearchTreeNode root) {
		if (null == root)
			return;

		InOrderTraversal(root.getLeft());
		System.out.println(root.getValue());
		InOrderTraversal(root.getRight());
	}

	public static void PostOrderTraversal(BinarySearchTreeNode root) {
		if (null == root)
			return;

		PostOrderTraversal(root.getLeft());
		PostOrderTraversal(root.getRight());
		System.out.println(root.getValue());

	}

	public static BinarySearchTreeNode findMin(BinarySearchTreeNode root) {
		if (null == root)
			return null;

		while (null != root.getLeft()) {
			root = root.getLeft();
		}
		return root;
	}

	public static BinarySearchTreeNode findMax(BinarySearchTreeNode root) {
		if (null == root)
			return null;

		while (null != root.getRight()) {
			root = root.getRight();
		}
		return root;
	}

	public static boolean find(BinarySearchTreeNode root, int number) {
		if (null == root)
			return false;

		if (number == root.getValue())
			return true;

		if (number < root.getValue())
			return find(root.getLeft(), number);
		else
			return find(root.getRight(), number);
	}

	public static BinarySearchTreeNode insertNode(BinarySearchTreeNode root, int num) {

		if (null == root) {
			root = new BinarySearchTreeNode(num);
			root.setLeft(null);
			root.setRight(null);
		} else {
			if (num > root.getValue())
				root.setRight(insertNode(root.getRight(), num));
			else
				root.setLeft(insertNode(root.getLeft(), num));
		}
		return root;
	}
	
	public static BinarySearchTreeNode delete(BinarySearchTreeNode root,int data)
	{
		if(null==root)
			return root;
		
		if(data>root.getValue())
			root.setRight(delete(root.getRight(),data));
		else if(data<root.getValue())
			root.setLeft(delete(root.getLeft(),data));
		else
		{
			//If node has both childs
			BinarySearchTreeNode temp;
			if(null!=root.getLeft() && null!=root.getRight())
			{
				 temp= findMax(root.getLeft());
				root.setValue(temp.getValue());
				root.setLeft(delete(root.getLeft(),temp.getValue()));
				
			}
			else
			{
				temp = root;
				if(null!=root.getLeft())
					root=root.getLeft();
				if(null!=root.getRight())
					root=root.getRight();
				
				root= null;
			}
		}
		
		return root;
			
	}
	
	public static BinarySearchTreeNode LCA(BinarySearchTreeNode root, BinarySearchTreeNode A,BinarySearchTreeNode B)
	{
		if(root==null)
			return root;
		
		if(root==A || root==B)
			return root;
		
		BinarySearchTreeNode left= LCA(root.getLeft(),A,B);
		BinarySearchTreeNode right =LCA(root.getRight(),A,B);
		
		if(left!=null && right!=null)
			return root;
		
		return null!=left?left:right;
	}
	
	public static boolean isBST(BinarySearchTreeNode root)
	{
		if(null==root)
			return true;
		
		
		if(root.getLeft()!=null && findMax(root.getLeft()).getValue()>root.getValue())
			return false;
		
		if(root.getRight()!=null && findMin(root.getRight()).getValue()<root.getValue())
			return false;
		
		if(!isBST(root.getLeft()) || !isBST(root.getRight()))
			return false;
		
		return true;
	}
	
	public static boolean isBSTOptimized(BinarySearchTreeNode root, int prev)
	{
		if(null==root)
			return true;
		
		if(!isBSTOptimized(root.getLeft(),prev))
			return false;
		
		if(prev>root.getValue() || (root.getLeft()!=null && root.getLeft().getValue()>root.getValue()))
			return false;
		
		prev = root.getValue();
		return isBSTOptimized(root.getRight(), prev);
	}
	
	public static BinarySearchTreeNode buildTreeFromArray(int[] A)
	{
		int len= A.length;
		if(len==0)
			return null;
		
		BinarySearchTreeNode tree=getTreeFromArray(A,0,len-1); 
		return tree;
	}
	
	public static BinarySearchTreeNode getTreeFromArray(int[] A, int left, int right)
	{
		if(left>right)
			return null;
		
		BinarySearchTreeNode root = new BinarySearchTreeNode();;
		int mid = left+(right-left)/2;
		root.setValue(A[mid]);
		if(left==right)
		{
			root.setLeft(null);
			root.setRight(null);
		}
		else
		{
			root.setLeft(getTreeFromArray(A,left,mid-1));
			root.setRight(getTreeFromArray(A,mid+1,right));
		}
		
		return root;
	}
	
	static int index=1;
	public static BinarySearchTreeNode findKthSmallestNumber(BinarySearchTreeNode root,int k){
		if(root==null)
			return root;
		BinarySearchTreeNode left = findKthSmallestNumber(root.getLeft(),k);
		if( left!=null) return left;
		if(index++==k)
			return root;
			
		return  findKthSmallestNumber(root.getRight(), k);
	}
	
	public static int floorValue(BinarySearchTreeNode root,int key)
	{
		if(root==null)
			return Integer.MAX_VALUE;
		
		if(root.getValue()==key)
			return root.getValue();
		
		if(root.getValue()>key)
			return floorValue(root.getLeft(), key);
		
		int floorValue = floorValue(root.getRight(), key);
		return floorValue <=key?floorValue:root.getValue();
			
	}
	
	public static int ceilingValue(BinarySearchTreeNode root,int key)
	{
		if(root==null)
			return Integer.MAX_VALUE;
		
		if(root.getValue()==key)
			return root.getValue();
		
		if(root.getValue()>key)
			return ceilingValue(root.getLeft(), key);
		
		int ceilingValue = ceilingValue(root.getRight(), key);
		return ceilingValue <=key?ceilingValue:root.getValue();
			
	}
	
	public static List<Integer> array = new ArrayList<Integer>();
	public static void serializeBST(BinarySearchTreeNode root)
	{
		if(root==null)
			return;
		array.add(root.getValue());
		serializeBST(root.getLeft());
		serializeBST(root.getRight());
	}
	
	public static int findClosest(BinarySearchTreeNode node, int k)
	{
		return findClosesHelper(node, k, Integer.MAX_VALUE);
	}

	private static int findClosesHelper(BinarySearchTreeNode node, int k, int closest) {
		if(node==null)
				return closest;
		
		BinarySearchTreeNode temp = node;
		while(temp!=null)
		{
			if(Math.abs(k-closest)>Math.abs(k-temp.getValue()))
				closest = temp.getValue();
			
			if(k>temp.getValue())
				temp = temp.getRight();
			else if(k<temp.getValue())
				temp = temp.getLeft();
			else
			{
				closest = temp.getValue();
				break;
			}
		}
		return closest;
	}
}
