package Graph;

public class GraphMatrix {
    int vertex;
    int[][] edges;

    public GraphMatrix(int vertex) {
        this.vertex = vertex;
        edges = new int[vertex][vertex];
    }
    
    public void addEdge(int source, int destination){
        //add edge
        edges[source][destination] = 1;
        //add bak edge for undirected graph
        edges[destination][source] = 1;
    }
    
    public void printGraph(){
        System.out.println("Graph:(Adjacency Matrix)");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < vertex; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j = 0; j < vertex; j++) {
                if (edges[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(5);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.printGraph();
    }
    
}
