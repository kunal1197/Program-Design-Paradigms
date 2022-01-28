package bsttest;

import org.junit.Before;
import org.junit.Test;

import bst.BinarySearchTree;
import bst.BinarySearchTreeImpl;

import static org.junit.Assert.assertEquals;

/**
 * This is used to Test the BST.
 */
public class TestBST {

  BinarySearchTree<String> tree;
  BinarySearchTree<String> tree1;

  /**
   * Used to set up the BST object for testing.
   */
  @Before
  public void setup() {
    tree = new BinarySearchTreeImpl<>();
    tree.add("1");
    tree.add("2");
    tree.add("4");
    tree1 = new BinarySearchTreeImpl<>();
  }

  /**
   * This is used to tree with no parameters.
   */
  @Test
  public void bstNoParam() {
    BinarySearchTree<String> test = new BinarySearchTreeImpl<>();
    assertEquals("[]", test.toString());
    assertEquals(0, test.height());
  }

  /**
   * This is used to test Empty tree.
   */
  @Test
  public void toStringEmpty() {
    assertEquals("[]", tree1.toString());
  }

  /**
   * This is used to test the add method on empty tree.
   */
  @Test
  public void testAddTreeEmpty() {
    tree1.add("abc");
    tree1.add("xyz");
    assertEquals("[abc xyz]", tree1.toString());
  }

  /**
   * This is used to test the add method on non-empty tree.
   */
  @Test
  public void testAddNotEmpty() {
    tree.add("3");
    tree.add("4");
    assertEquals("[1 2 3 4]", tree.toString());
  }

  /**
   * This is used to test the add method with same element on non-empty tree.
   */
  @Test
  public void testAddSameObject() {
    tree.add("2");
    tree.add("2");
    assertEquals("[1 2 4]", tree.toString());
  }

  /**
   * Used to test the size of empty tree.
   */
  @Test
  public void testSizeEmptyTree() {
    assertEquals(0, tree1.size());
  }

  /**
   * Used to test the size of Non-empty tree.
   */
  @Test
  public void testSizeTree() {
    tree.add("3");
    assertEquals(4, tree.size());
  }

  /**
   * Used to test the present method when present.
   */
  @Test
  public void testPresent() {
    tree.add("3");
    assertEquals(true, tree.present("3"));
  }

  /**
   * Used to test the present method when not present.
   */
  @Test
  public void testNotPresent() {
    assertEquals(false, tree.present("3"));
  }

  /**
   * This is used to test the Minimum element on non-empty tree.
   */
  @Test
  public void testMinimum() {
    assertEquals("1", tree.minimum());
  }

  /**
   * This is used to test the Minimum element on empty tree.
   */
  @Test
  public void testMinimumNull() {
    assertEquals(null, tree1.minimum());
  }

  /**
   * This is used to test the Maximum element on non-empty tree.
   */
  @Test
  public void testMaximum() {
    assertEquals("4", tree.maximum());
  }

  /**
   * This is used to test the Maximum element on empty tree.
   */
  @Test
  public void testMaximumNull() {
    assertEquals(null, tree1.maximum());
  }

  /**
   * Used to test the Preorder on empty tree.
   */
  @Test
  public void testPreOrderNull() {
    assertEquals("[]", tree1.preOrder());
  }

  /**
   * Used to test the Preorder on non-empty tree.
   */
  @Test
  public void testPreOrder() {
    assertEquals("[1 2 4]", tree.preOrder());
  }

  /**
   * Used to test the Inorder on empty tree.
   */
  @Test
  public void testInOrderNull() {
    assertEquals("[]", tree1.inOrder());
  }

  /**
   * Used to test the Inorder on non-empty tree.
   */
  @Test
  public void testInOrder() {
    assertEquals("[1 2 4]", tree.inOrder());
  }

  /**
   * Used to test the Postorder on empty tree.
   */
  @Test
  public void testPostOrderNull() {
    assertEquals("[]", tree1.postOrder());
  }

  /**
   * Used to test the Postorder on non-empty tree.
   */
  @Test
  public void testPostOrder() {
    assertEquals("[4 2 1]", tree.postOrder());
  }

  /**
   * This is used to test the height of empty tree.
   */
  @Test
  public void testHeightEmpty() {
    assertEquals(0, tree1.height());
  }

  /**
   * This is used to test the height of non-empty tree.
   */
  @Test
  public void testHeight() {
    assertEquals(3, tree.height());
  }

  /**
   * This is used to test the height of non-empty tree with different size of left and right
   * sub-tree.
   */
  @Test
  public void testHeightDiff() {
    BinarySearchTree<String> test = new BinarySearchTreeImpl<>();
    test.add("20");
    test.add("10");
    test.add("5");
    test.add("2");
    test.add("30");
    assertEquals(3, test.height());
  }


}
