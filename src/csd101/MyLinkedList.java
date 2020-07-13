package csd101;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList {
    LinkedList<Integer> list = new LinkedList<>();
    int n;
    
    public MyLinkedList(int size) {
        this.n = size;
    }
    
    public void enterLinkedList() {
        int value;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter elements: ");
            value = ListDemo.in.nextInt();
            list.add(value);
        }
    }
    
    public void enterFirst(int value) {
        System.out.print("Enter first element: ");
        value = ListDemo.in.nextInt();
        list.addFirst(value);
    }
    
    public void enterLast(int value){
        System.out.println("Enter last element: ");
        value = ListDemo.in.nextInt();
        list.addLast(value);
    }

    public void displayll() {
        //fore TAB
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
    
}
