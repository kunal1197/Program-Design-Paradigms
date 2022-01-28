package bst;

import java.util.List;

interface BstNode<T extends Comparable<T>> {

  BstNode<T> add(T data);

  int size();

  List<T> preOrder();

  List<T> inOrder();

  List<T> postOrder();

  int height();

  boolean present(T data);

  T maximum();

  T minimum();
}
