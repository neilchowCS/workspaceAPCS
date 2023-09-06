import java.util.*;


public class Ch25Exercises
{
    /**
     * Exercise 21.
     * 
     * An array
     * 
     * Object[] completeTree;
     * 
     * represents a complete tree with completeTree[0] holding the number of
     * nodes in the tree and completeTree[1] holding the root value. Write a
     * method removeLeaves(Object[] completeTree) that removes all the leaves
     * from this tree.
     * 
     * @param completeTree
     *            represents a complete tree with completeTree[0] holding the
     *            number of nodes in the tree and completeTree[1] holding the
     *            root value
     */
    public void removeLeaves( Object[] completeTree )
    {
        // TODO complete method
        Object temp = completeTree[0];
        completeTree[0] = (Integer)temp - ( (Integer)temp + 1 ) / 2;
    }


    /**
     * Exercise 22.
     * 
     * Suppose a complete binary tree is rooted at root and has numNodes nodes.
     * Write a method
     * 
     * public Object[] toArray(TreeNode root, int numNodes)
     * 
     * that takes root and numNodes as parameters, stores that tree in an array
     * of length numNodes + 1, starting at the element with index 1, and returns
     * that array. The resulting array should hold the values in the order of a
     * level-by-level traversal of the tree. Write and use a recursive helper
     * method
     * 
     * private void toArray(TreeNode node, Object[] values, int i)
     * 
     * that places the value from node into values[i] and the rest of the values
     * from the (sub)tree rooted at node into the appropriate locations in
     * values.
     * 
     * @param root
     *            base of a complete binary tree
     * @param numNodes
     *            number of nodes in the tree
     * @return an array that holds the values of the binary tree in the order of
     *         a level-by-level traversal of the tree
     */
    public Object[] toArray( TreeNode root, int numNodes )
    {
        // TODO complete method
        Object[] output = new Object[numNodes + 1];
        output[0] = numNodes;

        toArray( root, output, 1 );

        return output; // FIX THIS!!
    }


    /**
     * toArray helper method.
     * 
     * @param node
     *            base of a complete binary tree
     * @param values
     *            an array that holds the values of the binary tree in the order
     *            of a level-by-level traversal of the tree
     * @param i
     *            current location in the values array
     */
    private void toArray( TreeNode node, Object[] values, int i )
    {
        // TODO complete helper method
        
        values[i] = node.getValue();
        if (values.length < i * 2 + 1 ) {
            toArray( node.getRight(), values, i * 2 + 1 );
        }
        if (values.length < i * 2 ) {
            toArray( node.getLeft(), values, i * 2 );
        }
        

    }


    /**
     * Exercise 23.
     * 
     * Write a boolean method isHeap. This method assumes that items represents
     * a complete binary tree with numNodes, with its root value stored in
     * items[1]. isHeap should return true if and only if this tree is a
     * min-heap. Do not use recursion, stacks, or temporary lists or arrays.
     * 
     * @param items
     *            a complete binary tree with numNodes nodes
     * @param numNodes
     *            number of nodes in the items array
     * @return true if and only if this tree is a min-heap
     */
    public boolean isHeap( Integer[] items, int numNodes )
    {/**
        // TODO complete method
        int l = ( numNodes - 2 ) / 2;
        for ( int i = 0; i <=  l; i++ )
        {
            
            if ( items[2 * i + 1] > items[i] )
            {
                return false;
            }

            if ( 2 * i + 2 < numNodes) 
            {
                if (items[2 * i + 2] > items[i] ){
                    return false;
                }
            }
        }**/
        return true;
        // FIX THIS!!
    }


    /**
     * Exercise 24.
     * 
     * A min-heap is represented in Integer[] items, with the root value in
     * items[1]. Suppose the root value has been replaced by the last leaf.
     * Write a method reheapDown that repairs the heap. numNodes is the total
     * number of nodes in the heap.
     * 
     * @param items
     *            a min-heap with the root value in items[1]
     * @param numNodes
     *            total number of nodes in the heap
     */
    public void reheapDown( Integer[] items, int numNodes )
    {
        // TODO complete method
        int a = 1;
        int l = a * 2;
        int r = a * 2 + 1;

        while ( r <= numNodes + 1)
        {
            if ( items[l] < items[r] )
            {
                Integer temp = items[a];
                items[a] = items[l];
                a = l;
                items[l] = temp;
                
            }

            else if ( items[r] < items[l] )
            {
                Integer temp = items[a];
                items[a] = items[r];
                a = r;
                items[r] = temp;
                
            }
            //new
            l = a * 2;
            r = a * 2 + 1;

        }

    }


    /**
     * Exercise 25.
     * 
     * Messages are Comparable objects. The same message can belong to two
     * priority queues, q1 and q2. Write a method exclude that creates and
     * returns a new priority queue that consists of all messages in q1 that are
     * not in q2 (that is, not msg1 == msg2). exclude should leave q1 and q2
     * empty. Do not use any temporary arrays, lists, or other data structures.
     * 
     * Precondition: no two messages in q2 have the same priority
     * 
     * @param q1
     *            PriorityQueue of Message
     * @param q2
     *            PriorityQueue of Message
     * @return all messages in q1 that are not in q2
     */
    public PriorityQueue<Message> exclude(
        PriorityQueue<Message> q1,
        PriorityQueue<Message> q2 )
    {
        // TODO complete method
        PriorityQueue<Message> output = new PriorityQueue<Message>();
        int l = q1.size();
        for (int i = 0; i < l; i++) {
            if (!q2.contains( q1.peek() )) {
                output.add( q1.peek() );
            }
            q1.remove();
        }

        return output; // FIX THIS!!
    }


    /**
     * Testing method: instantiates a Ch25Exercises object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch25Exercises ex = new Ch25Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println(
                "   (1) 25-21 removeLeaves( Object[] completeTree )" );
            System.out.println(
                "   (2) 25-22 toArray( TreeNode root, int numNodes )" );
            System.out.println(
                "   (3) 25-23 isHeap( Integer[] items, int numNodes )" );
            System.out.println(
                "   (4) 25-24 reheapDown( Integer[] items, int numNodes )" );
            System.out.println(
                "   (5) 25-25 exclude( PriorityQueue<Message> q1,PriorityQueue<Message> q2 )" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        Integer[] compTree = { 7, 1, 3, 2, 7, 5, 6, 4 };
                        for ( int i = 1; i <= compTree[0]; i++ )
                        {
                            System.out.print( compTree[i] + " " );
                        }
                        System.out.println();

                        ex.removeLeaves( compTree );

                        for ( int i = 1; i <= compTree[0]; i++ )
                        {
                            System.out.print( compTree[i] + " " );
                        }
                        System.out.println();
                        break;
                    case '2':
                        TreeNode<Integer> root = new TreeNode<Integer>( 1,
                            new TreeNode<Integer>( 3,
                                new TreeNode<Integer>( 7, null, null ),
                                new TreeNode<Integer>( 5, null, null ) ),
                            new TreeNode<Integer>( 2,
                                new TreeNode<Integer>( 6, null, null ),
                                new TreeNode<Integer>( 4, null, null ) ) );
                        Object[] minHeap = ex.toArray( root, 7 );
                        for ( int i = 0; i < minHeap.length; i++ )
                        {
                            System.out.print( minHeap[i] + " " );
                        }
                        System.out.println();
                        break;
                    case '3':
                        Integer[] items = { 7, 1, 3, 2, 7, 5, 6, 4 };
                        System.out.println( "isHeap( items, items[0] ) = "
                            + ex.isHeap( items, items[0] ) );
                        break;
                    case '4':
                        Integer[] heapDown = { 6, 4, 3, 2, 7, 5, 6 };
                        for ( int i = 1; i <= heapDown[0]; i++ )
                        {
                            System.out.print( heapDown[i] + " " );
                        }
                        System.out.println();
                        ex.reheapDown( heapDown, heapDown[0] );
                        for ( int i = 1; i <= heapDown[0]; i++ )
                        {
                            System.out.print( heapDown[i] + " " );
                        }
                        System.out.println();
                        break;
                    case '5':
                        Message msg1 = new Message( "msg1" );
                        Message msg2 = new Message( "msg2" );
                        Message msg3 = new Message( "msg3" );
                        Message msg4 = new Message( "msg4" );

                        Message msg0 = new Message( "msg0" );
                        Message msg5 = new Message( "msg5" );
                        Message msg6 = new Message( "msg6" );

                        PriorityQueue<Message> pq1 = new PriorityQueue<Message>();
                        pq1.add( msg1 );
                        pq1.add( msg2 );
                        pq1.add( msg3 );
                        pq1.add( msg4 );
                        System.out.println( pq1 );

                        PriorityQueue<Message> pq2 = new PriorityQueue<Message>();
                        pq2.add( msg0 );
                        pq2.add( msg1 );
                        pq2.add( msg4 );
                        pq2.add( msg5 );
                        pq2.add( msg6 );
                        System.out.println( pq2 );

                        PriorityQueue<Message> pq3 = ex.exclude( pq1, pq2 );

                        System.out.println( pq3 );

                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );

    }
}
