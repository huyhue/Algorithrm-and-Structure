package DoubleLinkedList;
public class MyDoubleLinkedList {
    Node head, tail;
    
    public void addToHead(int nInfo){
        Node q = new Node(nInfo);
        
        q.next = head;
        q.prev = null;
        if(head != null)
            head.prev = q;
        head = q;      
    }
    
    public void insertAfter(Node prevNode, int nInfor) {
        if(prevNode == null){
            System.out.println("The given previous node can not be NULL");
            return;
        }
        
        Node nNode = new Node(nInfor);
        nNode.next = prevNode.next;
        prevNode.next = nNode;
        nNode.prev = prevNode;
        
        if(nNode.next != null)
            nNode.next.prev = nNode;
    }
    
    void addToTail(int nInfor){
        Node q = new Node(nInfor);
        if (tail == null) {
            q.next = null;
            tail = q;
        }
        
        if (head == null) {
            q.prev = null;
            head = q;
            return;
        }
        
        tail.next = q;
        q.next = null;
        q.prev = tail;
        tail = q;
    }
    
    public void displayList(){
        Node q = head;
        System.out.println("Traversal in forward direction head to tail");
        
        System.out.println();
        
        Node p = tail;
        System.out.println("Traversal in reverse ...");
        while(p != null){
            System.out.print(p.data + "");
            p = p.prev;
        }
    }
    
    public void deleteNode(Node head_ref, Node del){
        //base case
        if (head == null || del == null) {
            return;
        }
        if (head == del) {
            head = del.next;
        }
        
        //change next only if node to be deleted is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }
        //change prev only if node to be deleted is NOT the next node
        if (del.prev != null) {
            del.prev.next = del.next;
        }
        //finally, free the memory occupied by del
        return;
    }
    
}

