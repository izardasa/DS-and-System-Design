import java.util.ArrayList;
import java.util.List;

import ds.impl.BinaryTree;
import ds.model.BinaryTreeNode;

public class TreeProblem
{

    public static void main( String[] args )
    {
        BinaryTreeNode t1 = new BinaryTreeNode( 1 );
        BinaryTreeNode t2 = new BinaryTreeNode( 2 );
        BinaryTreeNode t3 = new BinaryTreeNode( 3 );
        BinaryTreeNode t4 = new BinaryTreeNode( 4 );
        BinaryTreeNode t5 = new BinaryTreeNode( 5 );
        BinaryTreeNode t6 = new BinaryTreeNode( 6 );
        BinaryTreeNode t7 = new BinaryTreeNode( 7 );

        
        t1.setLeft( t2 );
        t1.setRight( t3 );
        t2.setLeft( t4 );
        t2.setRight( t5 );
        t3.setLeft( t6 );
        t3.setRight( t7 );

        /*   BinaryTreeNode t20= new BinaryTreeNode( 20 );
        BinaryTreeNode t10= new BinaryTreeNode( 10 );
        BinaryTreeNode t4 = new BinaryTreeNode(4);
        BinaryTreeNode t18 = new BinaryTreeNode(18);
        BinaryTreeNode t14= new BinaryTreeNode(14);
        BinaryTreeNode t13 = new BinaryTreeNode(13);
        BinaryTreeNode t15 = new BinaryTreeNode(15);
        BinaryTreeNode t19 = new BinaryTreeNode( 19 );
        BinaryTreeNode t26 = new BinaryTreeNode(26);
        BinaryTreeNode t24 = new BinaryTreeNode(24);
        BinaryTreeNode t27 = new BinaryTreeNode( 27 );
        BinaryTreeNode t28 = new BinaryTreeNode( 28 );
        
        t20.setLeft( t10 );
        t10.setParent( t20 );
        t10.setLeft( t4 );
        t4.setParent( t10 );
        t10.setRight( t18 );
        t18.setParent( t10 );
        t18.setLeft( t14 );
        t14.setParent( t18 );
        t14.setLeft( t13 );
        t13.setParent( t14 );
        t14.setRight( t15 );
        t15.setParent( t14 );
        t18.setRight( t19 );
        t19.setParent( t18 );
        t20.setRight( t26 );
        t26.setParent( t20 );
        t26.setLeft( t24 );
        t24.setParent( t26 );
        t26.setRight( t27 );
        t27.setParent( t26 );
        t27.setRight( t28 );
        t28.setParent( t27 );
        */

        // BinaryTree.postOrderTraversal( t20 );
        // System.out.println( BinaryTree.postOrderSuccessor( t20, t19 ).getValue() );
        // System.out.println( BinaryTree.getLevelOfANode( t20, 109 ));
        //BinaryTree.makeSumTreeToATree(  t1 );
        //BinaryTree.inOrderTraversalIterative( t1 );
        BinaryTreeNode st1 = new BinaryTreeNode(1);
        BinaryTreeNode st2 = new BinaryTreeNode( 1 );
        st1.setLeft( st2 );
        BinaryTree.makeSumTreeToATree( st1 );
        BinaryTree.sizeOfTree( st1 );
        System.out.println( BinaryTree.isValidTree );
    }
}
