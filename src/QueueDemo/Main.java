package QueueDemo;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> que = new LinkedList<>();
        //first in, first out
        que.add("ok 1");
        que.add("ok 2");
        que.add("ok 3");
        que.add("ok 4");

        System.out.println("" + que.poll());
        System.out.println("" + que.poll());
        System.out.println("" + que.poll());
        System.out.println("" + que.poll());
        System.out.println("--------END P1--------------");

        Queue<Integer> q = new LinkedList<>();
        // Adds elements {0, 1, 2, 3, 4} to queue 
        for (int i = 0; i < 5; i++) {
            q.add(i);
        }
        // Display contents of the queue. 
        System.out.println("Elements of queue- " + q);
        // To remove the head of queue. 
        int removedele = q.remove();
        System.out.println("Removed element- " + removedele);
        System.out.println("Display current- " + q);
        // To view the head of queue 
        int head = q.peek();
        System.out.println("Head of queue- " + head);
        // Rest all methods of collection interface, 
        // Like size and contains can be used with this 
        // implementation. 
        int size = q.size();
        System.out.println("Size of queue- " + size);

    }
}
