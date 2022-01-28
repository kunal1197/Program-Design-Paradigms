package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to hold all the Group nodes.
 * @param <T> Generic Node.
 */
class BstGroupNode<T extends Comparable<T>> extends AbstractNode<T> {
  private final T data;
  private BstNode<T> left;
  private BstNode<T> right;

  /**
   * Construct the BstGroup Node Object.
   * @param data parent data.
   * @param left left of tree.
   * @param right right of tree.
   */
  BstGroupNode(T data, BstNode<T> left, BstNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  /**
   * This is used to get the size of the Group Node.
   * @return size.
   */
  @Override
  public int size() {
    return 1 + left.size() + right.size();
  }

  /**
   * This is used to find the height of Group Node.
   * @return height.
   */
  @Override
  public int height() {
    int leftHeight = this.left.height();
    int rightHeight = this.right.height();
    return Math.max(leftHeight, rightHeight) + 1;
  }

  /**
   * Used to traverse tree in Preorder.
   * @return tree node.
   */
  @Override
  public List<T> preOrder() {
    return preOrderHelper(new ArrayList<>());
  }

  /**
   * Preorder accumulator Helper used to find the Preorder.
   * @param acc List Accumulator.
   * @return List.
   */
  @Override
  List<T> preOrderHelper(List<T> acc) {
    acc.add(this.data);
    ((AbstractNode<T>) left).preOrderHelper(acc);
    ((AbstractNode<T>) right).preOrderHelper(acc);

    return acc;
  }

  /**
   * Used to traverse tree in Inorder.
   * @return tree node.
   */
  @Override
  public List<T> inOrder() {
    return inOrderHelper(new ArrayList<>());
  }

  /**
   * Preorder accumulator Helper used to find the Inorder.
   * @param acc List Accumulator.
   * @return List.
   */
  @Override
  List<T> inOrderHelper(List<T> acc) {
    ((AbstractNode<T>) left).inOrderHelper(acc);
    acc.add(this.data);
    ((AbstractNode<T>) right).inOrderHelper(acc);

    return acc;
  }

  /**
   * Used to traverse tree in Postorder.
   * @return tree node.
   */
  @Override
  public List<T> postOrder() {
    return postOrderHelper(new ArrayList<>());
  }

  /**
   * Preorder accumulator Helper used to find the Postorder.
   * @param acc List Accumulator.
   * @return List.
   */
  @Override
  List<T> postOrderHelper(List<T> acc) {
    ((AbstractNode<T>) left).postOrderHelper(acc);
    ((AbstractNode<T>) right).postOrderHelper(acc);
    acc.add(this.data);

    return acc;
  }

  /**
   * This method is used to add the nodes to BST.
   * @param data node to be added.
   * @return Bst Node.
   */
  @Override
  public BstNode<T> add(T data) {
    if (this.left instanceof BstLeafNode && data.compareTo(this.data) < 0) {
      this.left = new BstGroupNode<>(data, new BstLeafNode<>(), new BstLeafNode<>());
      return this;
    }
    else if (this.right instanceof BstLeafNode && data.compareTo(this.data) > 0) {
      this.right = new BstGroupNode<>(data, new BstLeafNode<>(), new BstLeafNode<>());
      return this;
    }
    else if (this.left instanceof BstGroupNode && data.compareTo(this.data) < 0) {
      this.left.add(data);
      return this;
    }
    else if (this.right instanceof BstGroupNode && data.compareTo(this.data) > 0) {
      this.right.add(data);
      return this;
    }
    else if (data.compareTo(this.data) == 0) {
      return this;
    }

    throw new IllegalArgumentException("This data cannot be added to the Tree.");
  }

  /**
   * Used to find the minimum node.
   * @return minimum element.
   */
  @Override
  public T minimum() {
    T leftMin = this.left.minimum();
    if (leftMin == null) {
      return this.data;
    }

    return leftMin;
  }

  /**
   * Used to find the maximum node.
   * @return maximum element.
   */
  @Override
  public T maximum() {
    T rightMax = this.right.maximum();
    if (rightMax == null) {
      return this.data;
    }

    return rightMax;
  }

  /**
   * Used to find if element is present in BST.
   *
   * @param data the data to be searched
   * @return boolean.
   */
  @Override
  public boolean present(T data) {
    if (this.data.compareTo(data) == 0) {
      return true;
    }
    else if (data.compareTo(this.data) < 0) {
      return left.present(data);
    }
    else if (data.compareTo(this.data) > 0) {
      return right.present(data);
    }
    return false;
  }

}