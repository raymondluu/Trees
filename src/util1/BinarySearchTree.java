package util1;


// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// void removeMin( )      --> Remove minimum item
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Exceptions are thrown by insert, remove, and removeMin if warranted

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the tree.
     */
    public BinarySearchTree( )
    {
        root = null;
    }

    /**
     * Insert into the tree.
     * @param x the item to insert.
     * @throws DuplicateItemException if x is already present.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree..
     * @param x the item to remove.
     * @throws ItemNotFoundException if x is not found.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Remove minimum item from the tree.
     * @throws ItemNotFoundException if tree is empty.
     */
    public void removeMin( )
    {
        root = removeMin( root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public AnyType findMin( )
    {
        return elementAt( findMin( root ) );
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item or null if empty.
     */
    public AnyType findMax( )
    {
        return elementAt( findMax( root ) );
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public AnyType find( AnyType x )
    {
        return elementAt( find( x, root ) );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Internal method to get element field.
     * @param t the node.
     * @return the element field or null if t is null.
     */
    private AnyType elementAt( BinaryNode<AnyType> t )
    {
        return t == null ? null : t.my_element;
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws DuplicateItemException if x is already present.
     */
    protected BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            t = new BinaryNode<AnyType>( x );
        else if( x.compareTo( t.my_element ) < 0 )
            t.my_left = insert( x, t.my_left );
        else if( x.compareTo( t.my_element ) > 0 )
            t.my_right = insert( x, t.my_right );
        else
            throw new DuplicateItemException( x.toString( ) );  // Duplicate
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if x is not found.
     */
    protected BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            throw new ItemNotFoundException( x.toString( ) );
        if( x.compareTo( t.my_element ) < 0 )
            t.my_left = remove( x, t.my_left );
        else if( x.compareTo( t.my_element ) > 0 )
            t.my_right = remove( x, t.my_right );
        else if( t.my_left != null && t.my_right != null ) // Two children
        {
            t.my_element = findMin( t.my_right ).my_element;
            t.my_right = removeMin( t.my_right );
        }
        else
            t = ( t.my_left != null ) ? t.my_left : t.my_right;
        return t;
    }

    /**
     * Internal method to remove minimum item from a subtree.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if t is empty.
     */
    protected BinaryNode<AnyType> removeMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            throw new ItemNotFoundException( );
        else if( t.my_left != null )
        {
            t.my_left = removeMin( t.my_left );
            return t;
        }
        else
            return t.my_right;
    }    

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    protected BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.my_left != null )
                t = t.my_left;

        return t;
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.my_right != null )
                t = t.my_right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode<AnyType> find( AnyType x, BinaryNode<AnyType> t )
    {
        while( t != null )
        {
            if( x.compareTo( t.my_element ) < 0 )
                t = t.my_left;
            else if( x.compareTo( t.my_element ) > 0 )
                t = t.my_right;
            else
                return t;    // Match
        }
        
        return null;         // Not found
    }

      /** The tree root. */
    protected BinaryNode<AnyType> root;


        // Test program
    public static void main( String [ ] args )
    {
        BinarySearchTree<Integer> t = new BinarySearchTree<Integer>( );
        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( i );

        for( int i = 1; i < NUMS; i += 2 )
            t.remove( i );

        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 2; i < NUMS; i += 2 )
             if( t.find( i ) != i )
                 System.out.println( "Find error1!" );

        for( int i = 1; i < NUMS; i += 2 )
            if( t.find( i ) != null )
                System.out.println( "Find error2!" );
    }
    
  // Assignment 3 added methods
  
  /**
   * This method returns the number of nodes in the tree which have 2 null children.
   * 
   * @return number of nodes with 2 null children.
   */
  public int countLeafNodes()
  {
    return countLeafNodesHelper(root);
  }
  
  /**
   * This method returns the number of nodes in the tree which have one non-null child.
   * 
   * @return number of nodes with one non-null child.
   */
  public int countOneChildNodes()
  {
    return countOneChildNodesHelper(root);
  }
  
  /**
   * This method returns the number of nodes in the tree which have two non-null children.
   * 
   * @return number of nodes with two non-null children.
   */
  public int countTwoChildNodes()
  {
    return countTwoChildNodesHelper(root);
  }
  
  /**
   * Helper method for countLeaveNodes.
   * 
   * @param the_node given root to search through.
   * @return number of nodes with two null children.
   */
  private int countLeafNodesHelper(final BinaryNode<AnyType> the_node)
  {
    int return_value = 0;
    
    if (the_node.my_left != null)
    {
      return_value = return_value + countLeafNodesHelper(the_node.my_left);
    }
    if (the_node.my_right != null)
    {
      return_value = return_value + countLeafNodesHelper(the_node.my_right);
    }
    if (the_node.my_left == null && the_node.my_right == null)
    {
      return_value = 1;
    }
    
    return return_value;
  }
  
  /**
   * Helper method for countOneChildNodes.
   * 
   * @param the_node given root to search through.
   * @return number of nodes with one non-null child.
   */
  private int countOneChildNodesHelper(final BinaryNode<AnyType> the_node)
  {
    int return_value = 0;
    
    if (the_node.my_left != null)
    {
      return_value = return_value + countOneChildNodesHelper(the_node.my_left);
    }
    if (the_node.my_right != null)
    {
      return_value = return_value + countOneChildNodesHelper(the_node.my_right);
    }
    if (the_node.my_left != null && the_node.my_right == null
        || the_node.my_left == null && the_node.my_right != null)
    {
      return_value = return_value + 1;
    }
    return return_value;
  }
  
  /**
   * Helper method for countTwoChildNodes.
   * 
   * @param the_node given root to search through.
   * @return number of nodes with two non-null children.
   */
  private int countTwoChildNodesHelper(final BinaryNode<AnyType> the_node)
  {
    int return_value = 0;
    
    if (the_node.my_left != null)
    {
      return_value = return_value + countTwoChildNodesHelper(the_node.my_left);
    }
    if (the_node.my_right != null)
    {
      return_value = return_value + countTwoChildNodesHelper(the_node.my_right);
    }
    if (the_node.my_left != null && the_node.my_right != null)
    {
      return_value = return_value + 1;
    }
    return return_value;
  }
  
}
