package bst;

import java.util.List;

/**
 * Abstract class used for Accumulator helper methods for tree traversals.
 * @param <T> Generic Node.
 */
public abstract class AbstractNode<T extends Comparable<T>> implements BstNode<T> {

  /**
   * Preorder accumulator Helper used to find the Preorder.
   * @param acc List Accumulator.
   * @return List.
   */
  abstract List<T> preOrderHelper(List<T> acc);

  /**
   * Preorder accumulator Helper used to find the Inorder.
   * @param acc List Accumulator.
   * @return List.
   */
  abstract List<T> inOrderHelper(List<T> acc);

  /**
   * Preorder accumulator Helper used to find the Preorder.
   * @param acc List Accumulator.
   * @return List.
   */
  abstract List<T> postOrderHelper(List<T> acc);
}