package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchExample {
    private Queue<Node> queue;
    static ArrayList<Node> nodes = new ArrayList<Node>();

    static class Node {
        int data;
        boolean visited;
        public Node(int data) {
            this.data = data;
        }
    }

    public BreadthFirstSearchExample() {
        queue = new LinkedList<Node>();
    }

    public ArrayList<Node> findNeighbours(int adjacency_matrix[][], Node x) {
        int nodeIndex = -1;
        ArrayList<Node> neighbours = new ArrayList<Node>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).equals(x)) {
                nodeIndex = i;
                break;
            }
        }
        if (nodeIndex != -1) {
            for (int i = 0; i < adjacency_matrix[nodeIndex].length; i++) {
                if (adjacency_matrix[nodeIndex][i] == 1) {
                    neighbours.add(nodes.get(i));
                }
            }
        }
        return neighbours;
    }
    
    public void bfs(int adjacency_matrix[][], Node node){
        queue.add(node);
        node.visited = true;
        while(!queue.isEmpty()){
            Node element = queue.remove();
            System.out.print(element.data + " ");
            ArrayList<Node> neighbours=findNeighbours(adjacency_matrix, element);
            for (int i = 0; i < neighbours.size(); i++) {
               Node n = neighbours.get(i);
                if (n != null) {
                    queue.add(n);
                    n.visited = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);
        
        nodes.add(node40);
        nodes.add(node10);
        nodes.add(node20);
        nodes.add(node30);
        nodes.add(node60);
        nodes.add(node50);
        nodes.add(node70);
        int adjacency_matrix[][]={
            {0,1,1,0,0,0,0},  
            {0,0,0,1,0,0,0},  
            {0,1,0,1,1,1,0},  
            {0,0,0,0,1,0,0},  
            {0,0,0,0,0,0,1},  
            {0,0,0,0,0,0,1},  
            {0,0,0,0,0,0,0},  
        };
        System.out.println("The BFS traversal of the graph is ");
        BreadthFirstSearchExample bfsExample = new BreadthFirstSearchExample();
        bfsExample.bfs(adjacency_matrix, node40);
    }
     
}
