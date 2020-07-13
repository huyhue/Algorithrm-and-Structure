/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularSingleLinkedList;
public class NewMain {
    static class Node{
        int data;
        Node next;
    };
    static Node addToEmpty(Node tail,int data){
        //this function is only for empty list
        if (tail != null) {
            return tail;
        }
        //create a node dynamically
        Node temp = new Node();
        //assigning the data
        temp.data = data;
        tail = temp;
        //creating the link
        tail.next = tail;
        return tail;
    }
    static Node addBegin(Node tail, int data){
        if (tail == null) {
            return addToEmpty(tail, data);
        }
        Node temp = new Node();
        temp.data = data;
        temp.next = tail.next;
        tail.next = temp;
        
        return tail;
    }
    static void traverse(Node tail){
        Node p;
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        //pointing to first Node of the list
        p = tail.next;
        do {            
            System.out.print(p.data + "");
            p = p.next;
        } while (p != tail.next);
        
    }
    public static void main(String[] args) {
        Node tail = null;
        tail = addToEmpty(tail, 6);
        tail = addBegin(tail, 4);
        tail = addBegin(tail, 2);
        traverse(tail);
    }
}
