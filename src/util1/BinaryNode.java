package util1;

// Basic node stored in unbalanced binary search trees
// Note that this class is not accessible outside
// of this package.

/**
 * 
 * @author Raymond Luu
 * @version Winter 2013
 * 
 * @param <E>
 */
class BinaryNode<E>
{
  
  // Data; accessible by other package routines
  
  /**
   * The element in node.
   */
  protected E my_element;  // The data in the node
  
  /**
   * Left Child.
   */
  protected BinaryNode<E> my_left;     // Left child
  
  /**
   * Right Child.
   */
  protected BinaryNode<E> my_right;    // Right child
  
  // Constructor
  /**
   * 
   * @param the_element the element for the node.
   */
  BinaryNode(final E the_element)
  {
    my_element = the_element;
    my_left = null;
    my_right = null;
  }
  
}
