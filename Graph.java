import java.util.*;

class Graph {
  Map<Integer, ArrayList<Integer>> adj;

  public Graph() {
    this.adj = new HashMap<Integer, ArrayList<Integer>>();
  }

  public void addVertex(int i) {
    adj.put(i, new ArrayList<Integer>());
  }

  public void addEdge(int i, int j) {
    adj.get(i).add(j);
    adj.get(j).add(i);
  }

  public void removeVertex(int i) {
    ArrayList<Integer> currentVertex = adj.get(i);
    for (int j = 0; j < currentVertex.size(); j++) {
      int neighbor = currentVertex.get(j);
      this.adj.get(neighbor).remove(this.adj.get(neighbor).indexOf(i));
    }
    adj.remove(i);
  }

  public void removeEdge(int i, int j) {

    adj.get(i).remove(adj.get(i).indexOf(j));
    adj.get(j).remove(adj.get(j).indexOf(i));
  }

  public static void main(String[] args) {
    Graph myGraph = new Graph();

    for (int i = 0; i < 5; i++) {
      myGraph.addVertex(i);
    }

    myGraph.addEdge(0, 1);
    myGraph.addEdge(0, 4);
    myGraph.addEdge(1, 2);
    myGraph.addEdge(1, 3);
    myGraph.addEdge(1, 4);
    myGraph.addEdge(2, 3);
    myGraph.addEdge(3, 4);
    // myGraph.removeEdge(1, 2);
    myGraph.removeVertex(1);
    System.out.println(myGraph.adj);
  }
}