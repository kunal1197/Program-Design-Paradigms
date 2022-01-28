package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to hold all the Leaf nodes.
 *
 * @param <T> Generic Node.
 */
public class BstLeafNode<T extends Comparable<T>> extends AbstractNode<T> {

  /**
   * This method is used to add the nodes to BST.
   *
   * @param data node to be added.
   * @return Bst Node.
   */
  @Override
  public BstNode<T> add(T data) {
    return new BstGroupNode<>(data, new BstLeafNode<>(), new BstLeafNode<>());
  }

  /**
   * This is used to get the size of the Group Node.
   *
   * @return size.
   */
  @Override
  public int size() {
    return 0;
  }

  /**
   * This is used to find the height of Group Node.
   *
   * @return height.
   */
  @Override
  public int height() {
    return 0;
  }

  /**
   * Used to find if element is present in BST.
   *
   * @param data the data to be searched
   * @return boolean.
   */
  @Override
  public boolean present(T data) {
    return false;
  }

  /**
   * Used to find the maximum node.
   *
   * @return maximum element.
   */
  @Override
  public T maximum() {
    return null;
  }

  /**
   * Used to find the minimum node.
   *
   * @return minimum element.
   */
  @Override
  public T minimum() {
    return null;
  }

  /**
   * Used to traverse tree in Preorder.
   *
   * @return tree node.
   */
  @Override
  public List<T> preOrder() {
    return preOrderHelper(new ArrayList<>());
  }

  /**
   * Preorder accumulator Helper used to find the Preorder.
   *
   * @param acc List Accumulator.
   * @return List.
   */
  @Override
  List<T> preOrderHelper(List<T> acc) {

    return acc;
  }

  /**
   * Used to traverse tree in Inorder.
   *
   * @return tree node.
   */
  @Override
  public List<T> inOrder() {
    return inOrderHelper(new ArrayList<>());
  }

  /**
   * Preorder accumulator Helper used to find the Inorder.
   *
   * @param acc List Accumulator.
   * @return List.
   */
  @Override
  List<T> inOrderHelper(List<T> acc) {

    return acc;
  }

  /**
   * Used to traverse tree in Postorder.
   *
   * @return tree node.
   */
  @Override
  public List<T> postOrder() {
    return postOrderHelper(new ArrayList<>());
  }

  /**
   * Preorder accumulator Helper used to find the Postorder.
   *
   * @param acc List Accumulator.
   * @return List.
   */
  @Override
  List<T> postOrderHelper(List<T> acc) {

    return acc;
  }
}
