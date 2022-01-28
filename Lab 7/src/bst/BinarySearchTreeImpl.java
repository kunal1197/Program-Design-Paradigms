package bst;

import java.util.stream.Collectors;

/**
 * This class is used to implement all the methods defined in the Binary Search Tree Interface.
 *
 * @param <T> Generic Node.
 */
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

  private BstNode<T> root;

  /**
   * Construct BinarySearchTreeImpl Object.
   */
  public BinarySearchTreeImpl() {
    root = new BstLeafNode<>();
  }

  /**
   * Used to add elements in Binary Search Tree.
   *
   * @param data the data to be added
   */
  @Override
  public void add(T data) {
    root = root.add(data);
  }

  /**
   * Used to return the size of BST.
   *
   * @return size.
   */
  @Override
  public int size() {
    return root.size();
  }

  /**
   * Used to find the height of BST.
   *
   * @return height.
   */
  @Override
  public int height() {
    return root.height();
  }

  /**
   * Used to find if element is present in BST.
   *
   * @param data the data to be searched
   * @return boolean.
   */
  @Override
  public boolean present(T data) {
    return root.present(data);
  }

  /**
   * Used to find the minimum element.
   *
   * @return minimum element.
   */
  @Override
  public T minimum() {
    return root.minimum();
  }

  /**
   * Used to find the maximum element.
   *
   * @return maximum element.
   */
  @Override
  public T maximum() {
    return root.maximum();
  }

  /**
   * Used to traverse tree in Preorder.
   *
   * @return tree node.
   */
  @Override
  public String preOrder() {
    return "[" + root.preOrder().stream().map(t -> t.toString())
            .collect(Collectors.joining(" ")) + "]";
  }

  /**
   * Used to traverse tree in Inorder.
   *
   * @return tree node.
   */
  @Override
  public String inOrder() {
    return "[" + root.inOrder().stream().map(t -> t.toString())
            .collect(Collectors.joining(" ")) + "]";
  }

  /**
   * Used to traverse tree in Postorder.
   *
   * @return tree node.
   */
  @Override
  public String postOrder() {
    return "[" + root.postOrder().stream().map(t -> t.toString())
            .collect(Collectors.joining(" ")) + "]";
  }

  /**
   * Used to get the String representation of BST.
   *
   * @return BST object.
   */
  @Override
  public String toString() {
    return this.inOrder();
  }
}
