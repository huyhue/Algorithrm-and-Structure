package Graph;
public class ShortestPath {

    static final int V = 9;

    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < V; i++) {
            if (sptSet[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    void printSolution(int dist[], int n) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) 
            System.out.print("Distance from Source to " + i + " is " + dist[i]);
    }
}
