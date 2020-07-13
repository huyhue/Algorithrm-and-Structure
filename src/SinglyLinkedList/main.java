package SinglyLinkedList;
public class main {
    public static void main(String[] args) {
        
        Node nodeA = new Node(5);
        Node nodeB = new Node(4);
        Node nodeC = new Node(11);
        Node nodeD = new Node(4);
        Node nodeE = new Node(6);
        
        MyLinkedList mll = new MyLinkedList();
        mll.head = nodeA;
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = mll.tail;

        mll.display();
        
//        System.out.println("=======================");
//        mll.addFirst(1);
//        mll.addLast(100);
//        mll.display();
        
//        System.out.println("=======================");
//        mll.insertAfterPosition(55, 3);
//        mll.display();
    }
}
