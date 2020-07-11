/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

/**
 *
 * @author ASUS
 */
public class MyList {

    Node head, tail;

    void myList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void addToHead(int x) {  //You should write here appropriate statements to complete this function.  
    }

    void addToTail(int x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        }
        tail.next = q;
        tail = q;
    }
    // Inserts a new node after the given prev_node.   

    void addAfter(Node p, int x) {
        if (p == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        // 2 & 3: Allocate the Node & Put in the data  
        Node new_node = new Node(x);
        // 4. Make next of new Node as next of prev_node   
        new_node.next = p.next;
        // 5. make next of prev_node as new_node   
        p.next = new_node;
    }

    void visit(Node p) {

        //You should write here appropriate statements to complete this function.        
    }
    //- traverse from head to tail and dislay info of all nodes in the list.  

    void traverse() {

        //You should write here appropriate statements to complete this function.  
    }
    // - delete the head and return its info  

    int deleteFromHead() {
//You should write here appropriate statements to complete this function.  
    }
    // - delete the tail and return its info.  

    int deleteFromTail() {

        //You should write here appropriate statements to complete this function.      
    }
    // - delete the node after the node  p  and return its info.  

    int deleteAter(Node p) {
        // If linked list is empty   
        if (head == null) {
            return 0;
        }
        // Store head node   
        Node currentNode = head;
        // Find previous node of the node to be deleted  
        while (currentNode.next != p && currentNode.next != null) {
            currentNode = currentNode.next;
        }
        // Node temp->next is the node to be deleted  
        // Store pointer to the next of node to be deleted  
        Node deleted_node = currentNode.next;
        currentNode.next = deleted_node.next;
// Unlink the deleted node from list 
        return deleted_node.info;
    }
    // - delele the first node whose info is equal to  x. 

    void dele(int x) {
        // If linked list is empty  
        if (head == null) {
            System.out.println("The given list is empty");
            return;
        }
        // Store head node  
        Node currentNode = head;
        Node prevNode = new Node();
        // Find previous node of the node to be deleted  
        while (currentNode.info != x && currentNode.next != null) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode.next == null) {
            System.out.println("The given list does not have x value");
            return;
        }
        // Node temp->next is the node to be deleted  
        // Store pointer to the next of node to be deleted 
        prevNode.next = currentNode.next;
    }
    
}
