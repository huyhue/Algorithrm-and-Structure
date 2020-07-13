package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchExample {
    
    static ArrayList<Node> nodes = new ArrayList<Node>();
    
    static class Node {
        
        int data;
        boolean visited;
        
        public Node(int data) {
            this.data = data;
        }
        
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
    
    public void dfs(int adjacency_matrix[][], Node node) {
        System.out.println(node.data + " ");
        ArrayList<Node> neighbours = findNeighbours(adjacency_matrix, node);
        node.visited = true;
        for (int i = 0; i < neighbours.size(); i++) {
            Node n = neighbours.get(i);
            if (n != null && !n.visited) {
                dfs(adjacency_matrix, n);
            }
        }
    }

    public void dfsUsingStack(int adjacency_matrix[][], Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        node.visited = true;
        while (!stack.isEmpty()) {            
            Node element = stack.pop();
            System.out.print(element.data + " ");
            ArrayList<Node> neighbours = findNeighbours(adjacency_matrix, node);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    stack.add(n);
                    n.visited = true;
                }
            }
        }
    }
    
    public static void clearVistedFlags(){
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).visited=false;
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
        int adjacency_matrix[][] = {
            {0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0},};
        DepthFirstSearchExample dfsExample = new DepthFirstSearchExample();
        
        System.out.println("The DFS traversal of the graph using stack ");
        dfsExample.dfsUsingStack(adjacency_matrix, node40);
        
        System.out.println();
        
        clearVistedFlags();
        System.out.println("The DFS traversal of the graph using recursion ");
        dfsExample.dfs(adjacency_matrix, node40);
    }
}
