import java.util.*;

class Graph {
  ArrayList<ArrayList<Integer>> adj;

  public Graph() {
    adj = new ArrayList<ArrayList<Integer>>();
  }

  public void addVertex(int i) {
    adj.add(new ArrayList<Integer>(i));
  }

  public void removeVertex(int i) {
    ArrayList<Integer> currentVertex = adj.get(i);
    for (int j = 0; j < currentVertex.size(); j++) {
      removeEdge(i, currentVertex.get(j));
    }
    adj.remove(i);
  }

  public void addEdge(int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
  }

  public void removeEdge(int u, int v) {
    adj.get(u).remove(adj.get(u).indexOf(v));
    adj.get(v).remove(adj.get(v).indexOf(u));
  }

  public void printGraph() {
    for (int i = 0; i < adj.size(); i++) {
      System.out.println("\nAdjacency list of vertex" + i);
      System.out.print("head");
      for (int j = 0; j < adj.get(i).size(); j++) {
        System.out.print(" -> " + adj.get(i).get(j));
      }
      System.out.println();
    }
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
    myGraph.removeEdge(1,3);

    myGraph.printGraph();
  }
}