/*
 * TCSS 342 Winter 2013
 * Assignment 3
 */

package tests;

import org.junit.Before;
import org.junit.Test;

import util2.TreeSet;

import static org.junit.Assert.*;

/**
 * Junit test for a few methods in TreeSet class.
 * 
 * @author Raymond Luu
 * @version Winter 2013
 */
public class TreeSetJUnitTest
{

  /**
   * TreeSet to test with.
   */
  private TreeSet<Integer> my_tree_set;
  
  /**
   * Set up TreeSet.
   */
  @Before
  public void setUp()
  {
    my_tree_set = new TreeSet<Integer>();
    my_tree_set.add(1);
    my_tree_set.add(13);
    my_tree_set.add(15);
    my_tree_set.add(8);
    my_tree_set.add(3);
    my_tree_set.add(10);
    my_tree_set.add(14);
    my_tree_set.add(16);
    my_tree_set.add(9);
  }
  
  // Tests
  
  /**
   * Test floor method.
   */
  @Test
  public void testFloor()
  {
    // test if null is returned when no floor is found
    assertSame("Floor of target 1 should be null", my_tree_set.floor(1), null);
    
    // test a case if target is not an element in the tree
    assertSame("Floor of target 12 should be 10", my_tree_set.floor(12), 10);
    
    // test a case if target is an element in the tree
    assertSame("Floor of target 13 should be 10", my_tree_set.floor(13), 10);
  }
  
  /**
   * Test ceiling method.
   */
  @Test
  public void testCeiling()
  {
    // test if null is returned when no ceiling is found
    assertSame("Ceiling of target 16 should be null", my_tree_set.ceiling(16), null);
    
    // test a case if target is not an element in the tree
    assertSame("Ceiling of target 12 should be 13", my_tree_set.ceiling(12), 13);
    
    // test a case if target is an element in the tree
    assertSame("Ceiling of target 13 should be 14", my_tree_set.ceiling(13), 14);
  }
}
