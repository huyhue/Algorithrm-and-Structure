package DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        MyDoubleLinkedList t = new MyDoubleLinkedList();
        t.addToTail(6);
        t.addToHead(7);
        t.addToHead(1);
        t.addToTail(4);
        t.insertAfter(t.head.next, 8);
        System.out.println("Create DoubleLinkedList is: ");
        t.displayList();
    }
}
