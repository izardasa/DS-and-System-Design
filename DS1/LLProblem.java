
import ds.impl.LinkedList;
import ds.model.LLNode;

public class LLProblem
{

    public static void main( String[] args )
    {
        LLNode n1 = new LLNode( 7 );
        LLNode n2 = new LLNode( 5 );
        LLNode n3 = new LLNode( 9 );
        LLNode n4 = new LLNode( 4 );
        LLNode n5 = new LLNode( 6 );
        
        LLNode n11 = new LLNode( 8 );
        LLNode n22 = new LLNode( 4 );
        
        /* LinkedList.iterateList( LinkedList.reverseListInBlock( n1, 3 ));*/
        
        
        n1.setNext( n2 );
        n2.setNext( n3 );
        n3.setNext( n4 );
        n4.setNext( n5 );
        

        n11.setNext( n22 );
       // LinkedList.iterateList( n1 );
        
        LLNode result = LinkedList.sumList( n1,n11 );
        LinkedList.iterateList( result );
        // LinkedList.iterateList(n1);
        // System.out.println("Size of the linked list is "+LinkedList.size(n1));
        /*LinkedList.insertNode(n1, new LLNode(70), 3);
        LinkedList.iterateList(n1);
        System.out.println("Size of the linked list is "+LinkedList.size(n1));
        LLNode resultNode  = LinkedList.insertNode(n1, new LLNode(80), 1);
        LinkedList.iterateList(resultNode);
        System.out.println("Size of the linked list is "+LinkedList.size(resultNode));
        LLNode resultNode1  = LinkedList.insertNode(resultNode, new LLNode(90), 9);
        LinkedList.iterateList(resultNode1);
        System.out.println("Size of the linked list is "+LinkedList.size(resultNode1));*/
        // LinkedList.iterateList(n1);
        /* LinkedList.reverseListRecursive( n1 );
        LinkedList.iterateList( LinkedList.head );*/
        // LinkedList.iterateList(result);
        // System.out.println(result.getValue());
        // LinkedList.iterateList(resultNode);
        // System.out.println("Size "+result);
    }

}
