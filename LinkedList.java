public class LinkedList {
  class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
      this.next = null;
    }
  }

  Node head = null;

  public LinkedList() {
    this.head = null;
  }

  public void addNode(int val) {
    {
      Node newNode = new Node(val);

      if (this.head == null) {
        this.head = newNode;
      } else {
        Node current = this.head;
        while (current.next != null) {
          current = current.next;
        }

        current.next = newNode;
      }
    }
  }

  public void deleteNode(int val) {
    Node current = this.head;
    Node prev = null;
    if (current.val == val) {
      this.head = current.next;
      return;
    }
    while (current.val != val && current.next != null) {
      prev = current;
      current = current.next;
    }
    if (current.next == null) {
      System.out.println("Node not found");
      return;
    }
    prev.next = current.next;
  }

  void printList() {
    Node currNode = this.head;

    System.out.print("LinkedList: ");

    while (currNode != null) {
      System.out.print(currNode.val + " ");
      currNode = currNode.next;
    }

    System.out.println();
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.addNode(1);
    list.addNode(2);
    list.addNode(3);
    list.addNode(4);
    list.addNode(5);
    list.addNode(6);
    list.addNode(7);
    list.addNode(8);

    list.printList();

    list.deleteNode(1);

    list.printList();

    list.deleteNode(4);

    list.printList();

    list.deleteNode(10);

    list.printList();
  }
}
