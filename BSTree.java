import java.util.*;

public class BSTree {

  private class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
      this.right = null;
      this.left = null;
    }
  }

  Node root;

  public BSTree() {
    root = null;
  }

  public void add(int value) {
    root = addRecursive(this.root, value);
  }

  private Node addRecursive(Node current, int value) {
    if (current == null) {
      return new Node(value);
    }

    if (value < current.value) {
      current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
      current.right = addRecursive(current.right, value);
    } else {
      return current;
    }

    return current;
  }

  public boolean findNode(int value) {
    return findNodeRecursive(this.root, value);
  }

  private boolean findNodeRecursive(Node current, int value) {
    if (current == null) {
      return false;
    }
    if (value == current.value) {
      return true;
    }
    return value < current.value ? findNodeRecursive(current.left, value) : findNodeRecursive(current.right, value);
  }

  public static void main(String[] args) {
    BSTree bt = new BSTree();

    bt.add(6);
    bt.add(4);
    bt.add(8);
    bt.add(3);
    bt.add(5);
    bt.add(7);
    bt.add(9);
    System.out.println(bt.findNode(1));
  }
}
