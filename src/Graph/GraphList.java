package Graph;

import java.util.LinkedList;

public class GraphList {

    int vertex;
    LinkedList<Integer> edges[];

    public GraphList(int vertex) {
        this.vertex = vertex;
        edges = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        edges[source].add(destination);
        edges[destination].add(source);
    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            if (edges[i].size() > 0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < edges[i].size(); j++) {
                    System.out.print(edges[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        GraphList graph = new GraphList(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
    }

}
