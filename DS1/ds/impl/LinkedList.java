package ds.impl;

import java.util.Hashtable;

import ds.model.LLNode;

public class LinkedList
{

    public static long size( LLNode node )
    {
        long sizeList = 0;
        if( null == node )
            return sizeList;

        while( null != node )
        {
            node = node.getNext();
            sizeList++;

        }
        return sizeList;
    }

    public static void iterateList( LLNode node )
    {
        if( null == node )
        {
            System.out.print( "Linked list is empty." );
            return;
        }
        while( null != node )
        {
            System.out.print( node.getValue() + " -> " );
            node = node.getNext();
        }
        System.out.println( "NULL" );
    }

    public static LLNode insertNode( LLNode head, LLNode nodeToInsert, long position )
    {
        if( null == head || null == nodeToInsert )
            return head;

        long sizeList = size( head );

        if( position < 1 || position > sizeList + 1 )
        {
            System.out.println( "Invalid position to insert" );
            return head;
        }

        if( 1 == position )
        {
            nodeToInsert.setNext( head );
            head = null;
            return nodeToInsert;
        }

        if( 1 < position )
        {
            LLNode previousNode = head;
            long index = 1;
            while( index != position - 1 )
            {
                previousNode = previousNode.getNext();
                index++;
            }

            LLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext( currentNode );
            previousNode.setNext( nodeToInsert );
        }
        return head;
    }

    public static LLNode deleteNode( LLNode head, int position )
    {
        if( null == head )
            return head;

        long sizeList = size( head );

        if( position < 1 || position > sizeList )
        {
            System.out.println( "Invalid position to delete" );
            return head;
        }

        if( 1 == position )
        {
            LLNode temp = head.getNext();
            head = null;
            return temp;
        }

        if( 1 < position )
        {
            LLNode previousNode = head;
            long index = 1;
            while( index != position - 1 )
            {
                previousNode = previousNode.getNext();
                index++;
            }

            LLNode curNode = previousNode.getNext();
            LLNode laterNode = null != curNode.getNext() ? curNode.getNext() : null;
            previousNode.setNext( laterNode );
            curNode = null;
        }
        return head;
    }

    public static LLNode nthNodeFromEnd( LLNode head, long position )
    {
        if( null == head )
            return head;

        LLNode temp = null, nthNode = head;
        long count = 0;
        for( temp = head; temp != null; )
        {
            count++;
            if( position - count < 0 )
                nthNode = nthNode.getNext();

            temp = temp.getNext();
        }

        if( position - count <= 0 )
            return nthNode;
        return null;
    }

    public static boolean checkLoopInLinkedListExtraSpace( LLNode head )
    {
        if( null == head )
            return false;

        Hashtable<LLNode, LLNode> ht = new Hashtable<LLNode, LLNode>();
        while( head != null && null != head.getNext() )
        {
            if( !ht.containsKey( head ) )
            {
                ht.put( head, head.getNext() );
            }
            else
            {
                return true;
            }

            head = head.getNext();
        }
        return false;
    }

    public static boolean checkLoopInLinkedList( LLNode head )
    {
        if( null == head )
            return false;

        LLNode sp = head, fp = head;
        while( null != sp && null != fp )
        {
            fp = fp.getNext();
            if( sp.equals( fp ) )
                return true;
            if( null == fp )
                return false;
            fp = fp.getNext();
            if( sp.equals( fp ) )
                return true;
            sp = sp.getNext();

        }
        return false;
    }

    public static LLNode startNodeOfLoop( LLNode head )
    {
        if( null == head )
            return head;

        LLNode slow = head, fast = head;

        slow = slow.getNext();
        fast = fast.getNext();
        if( fast == null )
            return null;

        fast = fast.getNext();

        while( null != fast && null != fast.getNext() )
        {
            if( fast.equals( slow ) )
                break;

            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        if( fast != slow )
            return null;

        slow = head;
        while( fast != slow )
        {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return fast;
    }

    public static long sizeOfLoop( LLNode head )
    {
        if( null == head )
            return 0;

        LLNode slow = head, fast = head;

        slow = slow.getNext();
        fast = fast.getNext();
        if( fast == null )
            return 0;

        fast = fast.getNext();

        while( null != fast && null != fast.getNext() )
        {
            if( fast.equals( slow ) )
                break;

            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        if( fast != slow )
            return 0;

        long size = 1;
        while( fast.getNext() != slow )
        {
            fast = fast.getNext();
            size++;
        }
        return size;
    }

    public static LLNode reverseList( LLNode head )
    {
        LLNode temp = null, nextNode = null;

        if( null == head )
            return head;

        while( head != null )
        {
            nextNode = head.getNext();
            head.setNext( temp );
            temp = head;
            head = nextNode;

        }
        return temp;
    }

    public static LLNode head;

    public static void reverseListRecursive( LLNode node )
    {
        if( node == null )
            return;

        if( node.getNext() == null )
        {
            head = node;
            return;
        }

        reverseListRecursive( node.getNext() );
        node.getNext().setNext( node );
        node.setNext( null );
    }

    public static LLNode reverseListInBlock( LLNode head, int k )
    {
        if( head == null )
            return null;

        LLNode temp = null;
        LLNode c1 = head;
        int count = 0;
        while( c1 != null && count < k )
        {
            LLNode c2 = c1.getNext();
            c1.setNext( temp );
            temp = c1;
            c1 = c2;
            count++;
        }

        if( c1 != null )
            head.setNext( reverseListInBlock( c1.getNext(), k ) );

        return temp;

    }

    public static LLNode reverseListSelf( LLNode node )
    {

        LLNode c1 = node, c2 = node;
        LLNode temp = null;
        while( c1 != null )
        {
            c2 = c1.getNext();
            c1.setNext( temp );
            temp = c1;
            c1 = c2;
        }
        return temp;
    }

    public static LLNode findIntersectionOfAList( LLNode head1, LLNode head2 )
    {
        if( null == head1 || null == head2 )
            return null;

        long L1 = size( head1 );
        long L2 = size( head2 );

        long diff = L1 - L2;
        if( diff > 0 )
        {
            for( int i = 0; i < diff; i++ )
            {
                head1 = head1.getNext();
            }
        }
        else
        {
            for( int i = 0; i < Math.abs( diff ); i++ )
            {
                head2 = head2.getNext();
            }
        }

        while( head1 != null && head2 != null )
        {
            if( head1.equals( head2 ) )
                return head1;

            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        return null;
    }

    public static LLNode segregateEvenAndOddValueNodes( LLNode head )
    {
        if( head == null )
            return null;

        LLNode evenFirst = null, evenLast = null, oddFirst = null, oddLast = null;
        LLNode current = head;

        while( current != null )
        {
            int value = current.getValue();

            if( value % 2 == 0 )
            {
                if( evenFirst == null )
                {
                    evenFirst = current;
                    evenLast = current;
                }
                else
                {
                    evenLast.setNext( current );
                    evenLast = evenLast.getNext();
                }
            }
            else
            {
                if( oddFirst == null )
                {
                    oddFirst = current;
                    oddLast = current;
                }
                else
                {
                    oddLast.setNext( current );
                    oddLast = oddLast.getNext();
                }
            }
            current = current.getNext();
        }

        if( evenFirst != null )
        {
            head = evenFirst;
            if( oddFirst != null )
            {
                evenLast.setNext( oddFirst );
                oddLast.setNext( null );
            }
        }
        else
        {
            head = oddFirst;
            if( oddLast != null )
                oddLast.setNext( null );
        }
        return head;
    }

    public static LLNode sumList( LLNode head1, LLNode head2 )
    {
        if( head1 == null )
            return head2;
        if( head2 == null )
            return head1;

        LLNode res = new LLNode( 0 );
        LLNode head = res;
        int rem = 0;
        int carryOver = 0;
        int sum=0;
        while( head1 != null && head2 != null )
        {
            sum = head1.getValue() + head2.getValue() + carryOver;

            rem = sum % 10;
            res.setNext( new LLNode( rem ) );
            carryOver = sum >= 10 ? 1 : 0;

          

            if( head1 != null && head2 != null )
                res = res.getNext();

            head1 = head1.getNext();
            head2 = head2.getNext();
        }

        while( head1!= null )
        {
            sum = head1.getValue() + carryOver;
            rem = sum%10;
            res.setNext( new LLNode( rem ) );
            carryOver = sum >= 10 ? 1 : 0;
            if(head1!=null)
                res = res.getNext();
            head1 = head1.getNext();
        }

        while( head2 != null )
        {
            sum = head2.getValue()+carryOver;
            rem = sum%10;
            res.setNext( new LLNode( rem ) );
            carryOver = sum >= 10 ? 1 : 0;
            if(head2!=null)
                res = res.getNext();
            head2 = head2.getNext();
        }

        res.setNext( null );
        return head.getNext();

    }
}
