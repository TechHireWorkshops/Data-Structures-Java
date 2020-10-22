public class Stack {
  private int maxSize;
  private long[] stackArray;
  private int top;

  public Stack(int s) {
    maxSize = s;
    stackArray = new long[maxSize];
    top = -1;
  }

  public void push(long j) {
    stackArray[++top] = j;
  }

  public long pop() {
    return stackArray[top--];
  }

  public long peek() {
    return stackArray[top];
  }

  public boolean isEmpty() {
    return (top == -1);
  }

  public boolean isFull() {
    return (top == maxSize - 1);
  }

  public static void main(String[] args) {
    Stack theStack = new Stack(10);
    theStack.push(10);
    theStack.push(20);
    theStack.push(30);
    theStack.push(40);
    theStack.push(50);
    theStack.pop();
    theStack.pop();
    theStack.pop();
    theStack.pop();
    theStack.pop();
    theStack.push(1);
    theStack.push(2);
    theStack.push(3);
    theStack.push(4);
    theStack.push(5);
    for(int i =0;i<theStack.stackArray.length;i++){
      System.out.println(theStack.stackArray[i]);
    }
  }
}