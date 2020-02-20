package ds.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import ds.model.BinaryTreeNode;
import ds.model.BinaryTreeNodeWithNext;

public class BinaryTree
{
    static int preIndex = 0;

    public static void inOrderTraversel( BinaryTreeNode root )
    {
        if( null == root )
            return;

        inOrderTraversel( root.getLeft() );
        System.out.println( root.getValue() );
        inOrderTraversel( root.getRight() );
    }

    public static void preOrderTraversal( BinaryTreeNode root )
    {
        if( null == root )
            return;

        System.out.println( root.getValue() );
        preOrderTraversal( root.getLeft() );
        preOrderTraversal( root.getRight() );
    }

    public static void preOrderTraversalIterative( BinaryTreeNode node )
    {
        if( node == null )
            return;

        Stack stack = new Stack<BinaryTreeNode>();
        while( true )
        {
            while( node != null )
            {

                System.out.println( node.getValue() );
                stack.push( node );
                node = node.getLeft();
            }
            if( stack.isEmpty() )
                break;

            node = (BinaryTreeNode)stack.pop();
            node = node.getRight();

        }
        return;
    }

    public static void printLeftViewSelf( BinaryTreeNode node )
    {
        printLeftViewSelfUtil( node, 1 );
    }

    private static void printLeftViewSelfUtil( BinaryTreeNode node, int level )
    {
        if( node == null )
            return;

        if( max_level < level )
        {
            System.out.println( node.getValue() );
            max_level = level;
        }

        printLeftViewSelfUtil( node.getLeft(), level + 1 );
        printLeftViewSelfUtil( node.getRight(), level + 1 );
    }

    public static void printRightViewSelf( BinaryTreeNode node )
    {
        printRightViewSelfUtil( node, 1 );
    }

    private static void printRightViewSelfUtil( BinaryTreeNode node, int level )
    {
        if( node == null )
            return;

        if( max_level < level )
        {
            System.out.println( node.getValue() );
            max_level = level;
        }

        printRightViewSelfUtil( node.getRight(), level + 1 );
        printRightViewSelfUtil( node.getLeft(), level + 1 );
    }

    static BinaryTreeNodeWithNext next = null;

    public static void setNextToInorderNext( BinaryTreeNodeWithNext node )
    {

        if( node != null )
        {
            setNextToInorderNext( node.getRight() );
            node.setNext( next );
            next = node;
            setNextToInorderNext( node.getLeft() );
        }
    }

    public static void traverseNextNode( BinaryTreeNodeWithNext node )
    {
        if( node == null )
            return;

        while( node != null )
        {
            System.out.println( node.getValue() );
            node = node.getNext();
        }
    }

    public static void inOrderTraversalIterative( BinaryTreeNode node )
    {
        if( node == null )
            return;

        Stack stack = new Stack<BinaryTreeNode>();
        while( true )
        {
            while( node != null )
            {
                stack.push( node );
                node = node.getLeft();
            }
            if( stack.isEmpty() )
                break;

            node = (BinaryTreeNode)stack.pop();
            System.out.println( node.getValue() );
            node = node.getRight();

        }
        return;
    }

    public static void postOrderTraversal( BinaryTreeNode root )
    {
        if( null == root )
            return;

        postOrderTraversal( root.getLeft() );
        postOrderTraversal( root.getRight() );
        System.out.println( root.getValue() );
    }

    public static void levelOrderTraversal( BinaryTreeNode root )
    {
        if( null == root )
            return;

        Queue<BinaryTreeNode> queue = new java.util.LinkedList<BinaryTreeNode>();
        queue.add( root );
        BinaryTreeNode temp = null;
        while( queue.size() != 0 )
        {
            temp = queue.remove();
            if( null != temp.getLeft() )
                queue.add( temp.getLeft() );
            if( null != temp.getRight() )
                queue.add( temp.getRight() );

            System.out.println( temp.getValue() );
        }
        queue = null;
    }

    public static void boundaryOrderTraversal( BinaryTreeNode root )
    {
        System.out.println( root.getValue() );
        printLeftBoundary( root.getLeft() );
        printLeaves( root.getLeft() );
        printLeaves( root.getRight() );
        printRightBoundary( root.getRight() );
    }

    private static void printRightBoundary( BinaryTreeNode root )
    {
        if( root != null )
        {
            if( root.getRight() != null )
            {
                printRightBoundary( root.getRight() );
                System.out.println( root.getValue() );
            }
            else if( root.getLeft() != null )
            {
                printRightBoundary( root.getLeft() );
                System.out.println( root.getValue() );
            }
        }

    }

    static int max_level = 0;

    public void printLeftView( BinaryTreeNode root )
    {

        leftViewUtil( root, 1 );
    }

    private void leftViewUtil( BinaryTreeNode root, int level )
    {
        if( root == null )
            return;
        if( max_level < level )
        {
            System.out.println( root.getValue() );
            max_level = level;
        }

        leftViewUtil( root.getLeft(), level + 1 );
        leftViewUtil( root.getRight(), level + 1 );

    }

    public void printRightView( BinaryTreeNode root )
    {

        rightViewUtil( root, 1 );
    }

    private void rightViewUtil( BinaryTreeNode root, int level )
    {
        if( root == null )
            return;
        if( max_level < level )
        {
            System.out.println( root.getValue() );
            max_level = level;
        }

        rightViewUtil( root.getRight(), level + 1 );
        rightViewUtil( root.getLeft(), level + 1 );
    }

    public static void printLeaves( BinaryTreeNode root )
    {
        if( root != null )
        {
            printLeaves( root.getLeft() );

            if( root.getLeft() == null && root.getRight() == null )
                System.out.println( root.getValue() );

            printLeaves( root.getRight() );
        }

    }

    private static void printLeftBoundary( BinaryTreeNode root )
    {
        if( root != null )
        {
            if( root.getLeft() != null )
            {
                System.out.println( root.getValue() );
                printLeftBoundary( root.getLeft() );
            }
            else if( root.getRight() != null )
            {
                System.out.println( root.getValue() );
                printLeftBoundary( root.getRight() );
            }
        }

    }

    public static BinaryTreeNode deepestNodeOfATree( BinaryTreeNode root )
    {
        if( null == root )
            return null;

        Queue<BinaryTreeNode> queue = new java.util.LinkedList<BinaryTreeNode>();
        queue.add( root );
        BinaryTreeNode temp = null;
        while( queue.size() != 0 )
        {
            temp = queue.remove();
            if( null != temp.getLeft() )
                queue.add( temp.getLeft() );
            if( null != temp.getRight() )
                queue.add( temp.getRight() );

        }
        queue = null;
        return temp;
    }

    public static int findMax( BinaryTreeNode root )
    {
        if( null == root )
            return Integer.MIN_VALUE;

        Queue<BinaryTreeNode> queue = new java.util.LinkedList<BinaryTreeNode>();
        queue.add( root );
        BinaryTreeNode temp = null;
        int max = Integer.MIN_VALUE;
        while( queue.size() != 0 )
        {
            temp = queue.remove();
            if( null != temp.getLeft() )
                queue.add( temp.getLeft() );
            if( null != temp.getRight() )
                queue.add( temp.getRight() );

            if( max < temp.getValue() )
                max = temp.getValue();
        }
        queue = null;
        return max;
    }

    public static int findMaxByRecursion( BinaryTreeNode root )
    {
        if( null == root )
            return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE, left, right, rootValue;
        if( null != root )
        {
            rootValue = root.getValue();
            left = findMaxByRecursion( root.getLeft() );
            right = findMaxByRecursion( root.getRight() );
            if( left < right )
                max = right;
            else
                max = left;

            if( rootValue > max )
                max = rootValue;
        }

        return max;
    }

    public static BinaryTreeNode insertNodeInABinaryTree( BinaryTreeNode root, BinaryTreeNode node )
    {
        if( null == root )
            return node;

        Queue<BinaryTreeNode> queue = new java.util.LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp = null;
        queue.add( root );
        while( queue.size() != 0 )
        {
            temp = queue.remove();
            if( temp.getLeft() != null )
                queue.add( temp.getLeft() );
            else
            {
                temp.setLeft( node );
                queue.clear();
                break;
            }

            if( temp.getRight() != null )
                queue.add( temp.getRight() );
            else
            {
                temp.setRight( node );
                queue.clear();
                break;
            }

        }

        return root;
    }

    public static void levelOrderTraversalReverseOrder( BinaryTreeNode root )
    {
        if( null == root )
            return;

        Queue<BinaryTreeNode> queue = new java.util.LinkedList<BinaryTreeNode>();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        queue.add( root );
        BinaryTreeNode temp = root;
        while( queue.size() != 0 )
        {
            temp = queue.remove();
            if( temp.getRight() != null )
                queue.add( temp.getRight() );

            if( temp.getLeft() != null )
                queue.add( temp.getLeft() );

            stack.push( temp );
        }
        queue.clear();
        while( stack.size() != 0 )
        {
            System.out.println( stack.pop().getValue() );
        }
    }

    public static int heightOfATree( BinaryTreeNode tree )
    {
        if( null == tree )
            return 0;

        int lh = 0, rh = 0;
        if( tree != null )
        {
            lh = heightOfATree( tree.getLeft() );
            rh = heightOfATree( tree.getRight() );

        }
        return Math.max( lh, rh ) + 1;
    }

    public static int heightOfATreeWithoutRecursion( BinaryTreeNode tree )
    {
        if( null == tree )
            return 0;

        Queue<BinaryTreeNode> queue = new java.util.LinkedList<BinaryTreeNode>();
        queue.add( tree );
        queue.add( null );
        BinaryTreeNode temp = null;
        int height = 0;
        while( queue.size() != 0 )
        {

            temp = queue.remove();
            if( null == temp )
            {
                if( queue.size() != 0 )
                {
                    queue.add( null );

                }
                height++;
            }
            else
            {
                if( temp.getLeft() != null )
                    queue.add( temp.getLeft() );
                if( temp.getRight() != null )
                    queue.add( temp.getRight() );
            }

        }
        return height;
    }

    public static void deleteANodeFromATree( BinaryTreeNode root, BinaryTreeNode node )
    {
        if( null == root )
            System.out.println( "Cannot delete node from empty tree" );
        if( null == node )
            System.out.println( "Please entre a valid node" );

        Queue<BinaryTreeNode> queue = new java.util.LinkedList<BinaryTreeNode>();
        queue.add( root );
        BinaryTreeNode temp = null;
        BinaryTreeNode deepestNode = deepestNodeOfATree( root );
        boolean nodeExists = false;
        if( !deepestNode.equals( node.getLeft() ) )
            deepestNode.setLeft( node.getLeft() );
        if( !deepestNode.equals( node.getRight() ) )
            deepestNode.setRight( node.getRight() );
        while( queue.size() != 0 )
        {
            temp = queue.remove();
            if( temp.equals( node ) )
            {
                temp = deepestNode;
                node = null;
                nodeExists = true;
            }
            if( temp.getLeft() != null )
            {
                if( temp.getLeft().equals( node ) )
                {
                    temp.setLeft( deepestNode );
                    node = null;
                    nodeExists = true;
                }

                queue.add( temp.getLeft() );
            }

            if( temp.getRight() != null )
            {
                if( temp.getRight().equals( node ) )
                {
                    temp.setRight( deepestNode );
                    node = null;
                    nodeExists = true;
                }

                queue.add( temp.getRight() );
            }
        }
        if( !nodeExists )
            System.out.println( "Node is not available in tree." );
    }

    public static int diameterOfTree( BinaryTreeNode root )
    {
        if( null == root )
            return 0;

        int lh = heightOfATree( root.getLeft() );
        int rh = heightOfATree( root.getRight() );

        int ld = diameterOfTree( root.getLeft() );
        int rd = diameterOfTree( root.getRight() );

        return Math.max( lh + rh + 1, Math.max( ld, rd ) );
    }

    public static boolean areMirrors( BinaryTreeNode root1, BinaryTreeNode root2 )
    {
        if( null == root1 && null == root2 )
            return true;
        if( null == root1 || null == root2 )
            return false;
        return root1.getValue() == root2.getValue() && areMirrors( root1.getLeft(), root2.getRight() )
            && areMirrors( root1.getRight(), root2.getLeft() );
    }

    public static BinaryTreeNode mirrorOfATree( BinaryTreeNode root )
    {
        if( null == root )
            return null;

        BinaryTreeNode temp;
        if( null != root )
        {
            mirrorOfATree( root.getLeft() );
            mirrorOfATree( root.getRight() );
            temp = root.getLeft();
            root.setLeft( root.getRight() );
            root.setRight( temp );
        }
        return root;
    }

    public static void printAllRootToLeafPathsInTree( BinaryTreeNode root )
    {
        int[] path = new int[ 256 ];
        int len = 0;
        printPaths( root, path, len );
    }

    private static void printPaths( BinaryTreeNode root, int[] path, int len )
    {
        if( null == root )
            return;

        path[len] = root.getValue();
        len++;
        if( root.getLeft() == null && root.getRight() == null )
            printArray( path );
        else
        {
            printPaths( root.getLeft(), path, len );
            printPaths( root.getRight(), path, len );
        }
    }

    private static void printArray( int[] path )
    {
        for( int i = 0; i < path.length; i++ )
        {
            if( path[i] != 0 )
                System.out.print( path[i] + "->" );
        }

        System.out.println( "NULL" );
    }

    public static void levelWithMaxSum( BinaryTreeNode root )
    {
        if( root == null )
            return;

        Queue<BinaryTreeNode> queue = new java.util.LinkedList<BinaryTreeNode>();
        queue.add( root );
        queue.add( null );
        BinaryTreeNode temp = null;
        int maxLevel = -1, maxSum = -1, level = 0, sum = 0;
        while( queue.size() != 0 )
        {
            temp = queue.remove();
            if( temp == null )
            {
                if( maxSum < sum )
                {
                    maxSum = sum;
                    maxLevel = level;
                }

                if( queue.size() != 0 )
                {
                    queue.add( null );
                }
                level++;
                sum = 0;
            }
            else
            {
                if( temp.getLeft() != null )
                    queue.add( temp.getLeft() );
                if( temp.getRight() != null )
                    queue.add( temp.getRight() );
                sum += temp.getValue();
            }
        }

        System.out.println( "Level is " + maxLevel + " sum is :" + maxSum );
    }

    public static boolean hasPathSum( BinaryTreeNode root, int sum )
    {
        if( root == null )
            return sum == 0;

        sum = sum - root.getValue();
        return hasPathSum( root.getLeft(), sum ) || hasPathSum( root.getRight(), sum );
    }

    public static BinaryTreeNode LCA( BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b )
    {
        if( root == null )
            return root;

        if( root.equals( a ) || root.equals( b ) )
            return root;

        BinaryTreeNode left = LCA( root.getLeft(), a, b );
        BinaryTreeNode right = LCA( root.getRight(), a, b );

        if( left != null && right != null )
            return root;

        return left != null ? left : right;
    }

    public static void printVerticalSumInBinaryTree( BinaryTreeNode root )
    {
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        verticalSumInBinaryTree( root, ht, 0 );
        Set<Integer> keys = ht.keySet();
        Iterator<Integer> itr = keys.iterator();

        while( itr.hasNext() )
        {
            Integer key = itr.next();
            System.out.println( "column : " + key + " value :" + ht.get( key ) );
        }
    }

    private static void verticalSumInBinaryTree( BinaryTreeNode root, Hashtable<Integer, Integer> ht,
        Integer startIndex )
    {
        if( root == null )
            return;

        verticalSumInBinaryTree( root.getLeft(), ht, startIndex - 1 );
        int value = ht.get( startIndex ) == null ? 0 : ht.get( startIndex );
        ht.put( startIndex, value + root.getValue() );
        verticalSumInBinaryTree( root.getRight(), ht, startIndex + 1 );
    }

    public static BinaryTreeNode buildTreeFromPreOrder( char[] A, int i )
    {
        if( A == null )
            return null;

        BinaryTreeNode newNode = new BinaryTreeNode( A[i] );
        newNode.setLeft( null );
        newNode.setRight( null );
        if( A[i] == 'L' )
            return newNode;

        newNode.setLeft( buildTreeFromPreOrder( A, ++i ) );
        newNode.setRight( buildTreeFromPreOrder( A, ++i ) );
        return newNode;

    }

    public static void printZigZagTraversal( BinaryTreeNode root )
    {
        if( root == null )
            return;

        Stack<BinaryTreeNode> preLevel = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> nextLevel = new Stack<BinaryTreeNode>();
        BinaryTreeNode temp = null;
        boolean leftToRight = true;
        preLevel.push( root );

        while( preLevel.size() != 0 )
        {
            temp = preLevel.pop();
            System.out.println( temp.getValue() );
            if( temp != null )
            {
                if( leftToRight )
                {
                    if( temp.getLeft() != null )
                        nextLevel.push( temp.getLeft() );
                    if( temp.getRight() != null )
                        nextLevel.push( temp.getRight() );
                }
                else
                {
                    if( temp.getRight() != null )
                        nextLevel.push( temp.getRight() );
                    if( temp.getLeft() != null )
                        nextLevel.push( temp.getLeft() );
                }
            }
            if( preLevel.size() == 0 )
            {
                leftToRight = !leftToRight;
                Stack<BinaryTreeNode> tempLevel = new Stack<BinaryTreeNode>();
                tempLevel = preLevel;
                preLevel = nextLevel;
                nextLevel = tempLevel;
            }
        }

    }

    public static BinaryTreeNode buildBinaryTree( char[] preOrder, char[] inOrder, int startIndex, int endIndex )
    {
        if( startIndex > endIndex )
            return null;

        BinaryTreeNode node = new BinaryTreeNode( preOrder[preIndex] );
        preIndex++;
        node.setLeft( null );
        node.setRight( null );
        if( startIndex == endIndex )
            return node;
        int inorderIndex = 0;
        for( int i = startIndex; i <= endIndex; i++ )
        {
            if( inOrder[i] == node.getValue() )
            {
                inorderIndex = i;
                break;
            }

        }
        node.setLeft( buildBinaryTree( preOrder, inOrder, startIndex, inorderIndex - 1 ) );
        node.setRight( buildBinaryTree( preOrder, inOrder, inorderIndex + 1, endIndex ) );
        return node;
    }

    public static int findDepthInGenericTree( int[] P )
    {
        int n = P.length;
        int maxDepth = 0;
        for( int i = 0; i < n; i++ )
        {
            int localDepth = 0;
            int j = i;
            while( -1 != P[j] )
            {
                localDepth++;
                j = P[j];
            }
            if( localDepth > maxDepth )
                maxDepth = localDepth;
        }

        return maxDepth;
    }

    public static int minDepth( BinaryTreeNode node )
    {
        if( node == null )
            return 0;

        if( node.getLeft() == null && node.getRight() == null )
            return 1;

        int left = minDepth( node.getLeft() );
        int right = minDepth( node.getRight() );

        return Math.min( left, right ) + 1;

    }

    public static List<Integer> array = new ArrayList<Integer>();

    public static void serializeTree( BinaryTreeNode root )
    {
        if( root == null )
        {
            array.add( -1 );
            return;
        }

        array.add( root.getValue() );
        serializeTree( root.getLeft() );
        serializeTree( root.getRight() );
    }

    static int serializeIndex = 0;

    public static BinaryTreeNode deserializeTree( List<Integer> A )
    {
        if( serializeIndex >= A.size() || A.get( serializeIndex ) == -1 )
        {
            serializeIndex++;
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode( A.get( serializeIndex++ ) );
        root.setLeft( deserializeTree( A ) );
        root.setRight( deserializeTree( A ) );

        return root;
    }

    public static void findNodesFromRootAtDistnceK( BinaryTreeNode root, int K )
    {
        if( root == null )
        {
            System.out.println( "No Nodes found" );
            return;
        }

        if( K == 0 )
        {
            System.out.println( root.getValue() );
            return;
        }

        findNodesFromRootAtDistnceK( root.getLeft(), K - 1 );
        findNodesFromRootAtDistnceK( root.getRight(), K - 1 );
    }

    public static int findRootToNodeDistance( BinaryTreeNode root, BinaryTreeNode alpha )
    {
        if( root == null || alpha == null )
            return -1;

        return rootToNodeDistanceHelper( root, alpha, 0 );

    }

    private static int rootToNodeDistanceHelper( BinaryTreeNode root, BinaryTreeNode alpha, int count )
    {
        if( root == null )
            return -1;

        if( root == alpha )
            return count;

        int leftCount = rootToNodeDistanceHelper( root.getLeft(), alpha, count + 1 );
        int rightCount = rootToNodeDistanceHelper( root.getRight(), alpha, count + 1 );

        return Integer.max( leftCount, rightCount );
    }

    public static int differenceBetweenTwoNodes( BinaryTreeNode root, BinaryTreeNode alpha, BinaryTreeNode beta )
    {
        BinaryTreeNode lca = LCA( root, alpha, beta );

        int distanceAlpha = findRootToNodeDistance( root, alpha );
        int distanceBeta = findRootToNodeDistance( root, beta );

        return distanceAlpha + distanceBeta - 2 * findRootToNodeDistance( root, lca );
    }

    static class Pair
    {
        BinaryTreeNode node;
        int hd;

        public Pair( BinaryTreeNode node, int hd )
        {
            this.node = node;
            this.hd = hd;
        }

    }

    public static void topViewOfBinaryTree( BinaryTreeNode node )
    {
        if( node == null )
            return;

        Queue<Pair> q = new LinkedList<>();
        q.add( new Pair( node, 0 ) );

        Map<Integer, Integer> map = new HashMap<>();

        while( q.size() > 0 )
        {
            BinaryTreeNode temp = q.peek().node;
            int hd = q.peek().hd;

            q.remove();

            if( map.get( hd ) == null )
                map.put( hd, temp.getValue() );

            if( null != temp.getLeft() )
                q.add( new Pair( temp.getLeft(), hd - 1 ) );

            if( null != temp.getRight() )
                q.add( new Pair( temp.getRight(), hd + 1 ) );
        }

        for( int data : map.values() )
        {
            System.out.println( data );
        }

    }

    public static void bottomViewOfBinaryTree( BinaryTreeNode node )
    {
        if( node == null )
            return;

        Queue<Pair> q = new LinkedList<>();
        q.add( new Pair( node, 0 ) );

        Map<Integer, Integer> map = new HashMap<>();

        while( q.size() > 0 )
        {
            BinaryTreeNode temp = q.peek().node;
            int hd = q.peek().hd;

            q.remove();

            if( map.get( hd ) == null )
                map.put( hd, temp.getValue() );
            else
                map.replace( hd, temp.getValue() );

            if( null != temp.getLeft() )
                q.add( new Pair( temp.getLeft(), hd - 1 ) );

            if( null != temp.getRight() )
                q.add( new Pair( temp.getRight(), hd + 1 ) );
        }

        for( int data : map.values() )
        {
            System.out.println( data );
        }

    }

    public static boolean rootToNodePath( BinaryTreeNode root, BinaryTreeNode node, ArrayList<BinaryTreeNode> path )
    {

        if( root == null )
            return false;

        path.add( root );

        if( root.getValue() == node.getValue() )
            return true;

        if( rootToNodePath( root.getLeft(), node, path ) || rootToNodePath( root.getRight(), node, path ) )
            return true;

        path.remove( path.size() - 1 );

        return false;
    }

    public static void pathBetweenNodes( BinaryTreeNode root, BinaryTreeNode alpha, BinaryTreeNode beta )
    {
        ArrayList<BinaryTreeNode> path1 = new ArrayList<>();
        ArrayList<BinaryTreeNode> path2 = new ArrayList<>();

        rootToNodePath( root, alpha, path1 );
        rootToNodePath( root, beta, path2 );

        int index = 0;
        while( index != path1.size() && index != path2.size() && path1.get( index ) == path2.get( index ) )
            index++;

        index--;

        for( int i = path1.size() - 1; i >= index; i-- )
        {
            System.out.println( path1.get( i ).getValue() );
        }

        for( int i = index + 1; i < path2.size(); i++ )
        {
            System.out.println( path2.get( i ).getValue() );
        }

    }

    public static BinaryTreeNode postOrderSuccessor( BinaryTreeNode root, BinaryTreeNode node )
    {
        if( root.equals( node ) )
            return null;

        BinaryTreeNode parent = node.getParent();

        if( parent.getRight() == null || node.equals( parent.getRight() ) )
            return parent;

        BinaryTreeNode current = node.getParent().getRight();
        while( current.getLeft() != null )
            current = current.getLeft();

        return current;
    }

    public static BinaryTreeNode inOrderSuccessor( BinaryTreeNode root, BinaryTreeNode node )
    {
        if( node.getRight() != null )
        {
            BinaryTreeNode curr = node.getRight();
            while( curr.getLeft() != null )
                curr = curr.getLeft();

            return curr;
        }

        if( node.getRight() == null )
        {
            BinaryTreeNode current = node;
            while( current != root )
            {
                if( current.equals( current.getParent().getLeft() ) )
                    return current.getParent();

                current = current.getParent();
            }
        }

        return null;
    }

    public static int getLevelOfANode( BinaryTreeNode root, int data )
    {
        return getLevelOfANodeUtil( root, data, 1 );
    }

    private static int getLevelOfANodeUtil( BinaryTreeNode root, int data, int level )
    {
        if( root == null )
            return -1;
        if( root.getValue() == data )
            return level;

        int downLevel = getLevelOfANodeUtil( root.getLeft(), data, level + 1 );
        if( downLevel != -1 )
            return downLevel;

        downLevel = getLevelOfANodeUtil( root.getRight(), data, level + 1 );
        return downLevel;
    }

    public static void printNodesAtKDistanceFromRoot( BinaryTreeNode root, int K )
    {
        if( root == null )
            return;
        if( K == 1 )
        {
            System.out.println( root.getValue() );
            return;
        }

        printNodesAtKDistanceFromRoot( root.getLeft(), K - 1 );
        printNodesAtKDistanceFromRoot( root.getRight(), K - 1 );
    }

    public static void printCousinsOfANode( BinaryTreeNode root, BinaryTreeNode node )
    {
        int level = getLevelOfANode( root, node.getValue() );

        printCousinsOfANodeUtil( root, node, level );
    }

    private static void printCousinsOfANodeUtil( BinaryTreeNode root, BinaryTreeNode node, int level )
    {
        if( null == root || level == 1 )
            return;

        if( level == 2 )
        {
            if( node.equals( root.getLeft() ) || node.equals( root.getRight() ) )
                return;

            if( root.getLeft() != null )
                System.out.println( root.getLeft().getValue() );
            if( root.getRight() != null )
                System.out.println( root.getRight().getValue() );

            return;
        }

        printCousinsOfANodeUtil( root.getLeft(), node, level - 1 );
        printCousinsOfANodeUtil( root.getRight(), node, level - 1 );

    }


    public static BinaryTreeNode getParent( BinaryTreeNode root, BinaryTreeNode node )
    {
        if( root == null )
            return null;

        if( node.equals( root.getLeft() ) || node.equals( root.getRight() ) )
            return root;
        
        BinaryTreeNode left = getParent( root.getLeft(), node );
        BinaryTreeNode right = getParent(root.getRight(), node);
        
        return left!=null ? left : right;
            
    }
    
    public static boolean dupSubTreeAvailable(BinaryTreeNode root)
    {
        HashSet<String> subTreeSet = new HashSet<String>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add( root );
        while(!q.isEmpty())
        {
            BinaryTreeNode temp = q.remove();
            int  l = 0; int r=0;
            if(temp.getLeft()!=null)
            {
                l = temp.getLeft().getValue();
                q.add( temp.getLeft() );
            }
            
            if(temp.getRight()!=null)
            {
                r = temp.getRight().getValue();
                q.add( temp.getRight() );
            }
            
            String str  = String.valueOf( temp.getValue() );
            str+=String.valueOf( l );
            str+=String.valueOf( r );
            
            if(!subTreeSet.contains( str ))
            {
                subTreeSet.add( str );
            }
            else
            {
                return true;
            }
        }
        return false;
    }

    public static int makeSumTreeToATree(BinaryTreeNode root)
    {
        if(null == root)
            return 0;
        
        int a = makeSumTreeToATree( root.getLeft() );
        
        a+=root.getValue();
        
        int b = makeSumTreeToATree( root.getRight() );
        
        a+=b;
        root.setValue( a );
                        
        return a;
    }
    
    public static boolean isValidTree = false;
    
    public static int sizeOfTree(BinaryTreeNode root)
    {
        if(root==null || isValidTree)
            return 0;
        
        int a = sizeOfTree( root.getLeft() );
        a+=1;
        
        int b = sizeOfTree( root.getRight() );
        a+=b;
        
        if(a%2==0 && root.getValue()==a/2)
            isValidTree= true;
        
        return a;
    }
}
