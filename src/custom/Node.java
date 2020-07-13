/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom;

/**
 *
 * @author ASUS
 */
public class Node<T> {
    
    Node previous;
//    Customer data;
    T data;
    Node next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Node(Node previous, T data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

}
