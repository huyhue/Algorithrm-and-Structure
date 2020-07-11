package LAB1;

import java.util.Scanner;

public class ListDataStructures {

    public static void main(String[] args) {
        int listC = 0;
        Scanner s = new Scanner(System.in);
        Scanner keyIn = new Scanner(System.in);
        MyList t = new MyList();
        int choice;
        while (true) {
            System.out.println("\n Choose your option:");
            System.out.println("  1. Create data list");
            System.out.println("  2. Display data list");
            System.out.println("  3. Sort Data");
            System.out.println("  4. Add a node with value x  at the head of  a list.");
            System.out.println("  5. add a node with value x  at the tail of  a list.");
            System.out.println("  6. add a node with value x  after the node p.");
            System.out.println(" 7. traverse from head to tail and dislay info of all nodes in the list.");
            System.out.println("  8. delete the head and return its info.");
            System.out.println(" 9. delete the tail and return its info.");
            System.out.println("  10.delete the node after the node  p  and return its info.");
            System.out.println(" 11. delele the first node whose info is equal to  x");
            System.out.println("  12. search and return the reference to the first node having info x.");
            System.out.println(" 13. count and return number of nodes in the list.");
            System.out.println("  14. delete an i-th node on the list. Besure that such a node exists. ");
            System.out.println(" 15. sort the list by ascending order of info.");
            System.out.println("  16. delete node p if it exists in the list.");
            System.out.println(" 17. create and return array containing info of all nodes in the list.");
            System.out.println("  18. add a node with value x  before the node p.");
            System.out.println(" 19. find and return the maximum value in the list.  ");
            System.out.println("  20. find and return the minimum value in the list.  ");
            System.out.println(" 21. return the sum of all values in the list.  ");
            System.out.println("  22. return the average of all values in the list.");
            System.out.println(" 23. check and return true if the list is sorted, return false if the list is not sorted.");

            System.out.println("  0. Exit\n");
            System.out.print("  Your selection (0 -> 24): ");
            choice = s.nextInt();
            if (choice == 0) {
                System.out.println(" Good bye, have a nice day!");
                break;
            }
            switch (choice) {
                case 1:
                    // prompt for the size of the list  
                    System.out.print("Enter the size of the list: ");
                    listC = keyIn.nextInt();
                    t.createList(listC);
                    System.out.println(" List is created!");
                    System.out.println(" The list is ");
                    t.traverse();
                    break;
                case 2:
                    System.out.println(" The list is ");
                    t.traverse();
                    break;
                case 3:
                    System.out.println(" The list is sorted");
                    t.sort();
                    break;
                case 4:
                    System.out.println(" Add a node with value x  at the head of  a list ");
                    System.out.print("Value of Node: ");
                    int val = keyIn.nextInt();
                    t.addToHead(val);
                    System.out.println(" The new list is ");
                    t.traverse();
                    break;
                case 5:
                    System.out.println(" add a node with value x  at the tail of  a list. ");
                    System.out.print("Value of Node: ");
                    val = keyIn.nextInt();
                    t.addToTail(val);
                    System.out.println(" The new list is ");
                    t.traverse();
                    break;
                case 6:
                    System.out.println(" 6. add a node with value x  after the node p.");
                    System.out.print("Value of Node: ");
                    val = keyIn.nextInt();
                    t.addAfter(t.head.next.next, val);
                    break;
                case 7:
                    System.out.println(" 7. traverse from head to tail and dislay info of all nodes in the list.");
                    System.out.println(" The list is ");
                    t.traverse();
                    break;
                case 8:
                    System.out.println("  8. delete the head and return its info.");
                    System.out.println(" The Node detelted is " + t.deleteFromHead());
                    System.out.println(" The new list is ");
                    t.traverse();
                    break;
                case 9:
                    System.out.println(" 9. delete the tail and return its info.");
                    System.out.println(" The Node detelted is " + t.deleteFromTail());
                    System.out.println(" The new list is ");
                    t.traverse();
                    break;
                case 10:
                    System.out.println("  10.delete the node after the node  p  and return its info.");
                    System.out.print("Enter the order of deleted Node: ");
                    int order = keyIn.nextInt();
                    Node q = t.head;
                    for (int jj = 1; jj < order; jj++) {
                        q = q.next;
                    }
                    //System.out.println(" The Node detelted is "+ q.info); 
                    System.out.println(" The Node detelted is " + t.deleteAter(q));
                    System.out.println(" The new list is ");
                    t.traverse();
                    break;
                case 11:  System.out.println("delele the first node whose info is equal to  x");  
                    System.out.print("Value of x: ");  
                    val = keyIn.nextInt(); 
                      t.dele(val); 
                      System.out.println(" The new list is "); 
                      t.traverse(); 
                      break; 
              case 12:  System.out.println("12. search and return the reference to the first node having info x."); 
              System.out.print("Value of x: ");  
              val = keyIn.nextInt(); 
              // t.search(val); 
              if(t.search(val)!=null) 
                  System.out.println(" The data searched Node is "+ t.search(val).info + " and the address is "+ t.search(val).next); 
              System.out.println(" The new list is "); 
              t.traverse(); 
              break; 
              case 13: System.out.println(" 13. count and return number of nodes in the list."); 
              System.out.println(" The number of node in the list is " + t.count()); 
              t.traverse(); 
              break; 
              case 14: System.out.println("  14. delete an i-th node on the list. Besure that such a node exists. ");  
              System.out.print("Value of position: ");  
              val = keyIn.nextInt(); 
              System.out.println(" The list is "); 
              t.traverse(); 
              t.dele_position(val-1); 
              System.out.println(" The new list is "); 
              t.traverse(); 
              break; 
              case 15:  System.out.println(" 15. sort the list by ascending order of info."); 
              t.sort(); 
              System.out.println(" The new list is "); 
              t.traverse(); 
              break; 
              case 16:  System.out.println("  16. delete node p if it exists in the list."); 
              System.out.print("Enter the order of deleted Node: ");  
              order = keyIn.nextInt(); 
              Node qq=t.head; 
              for(int jj=1;jj<order;jj++) 
              { 
                    qq=qq.next;
              } 
            } 
            //System.out.println(" The Node detelted is "+ q.info); 
            System.out.println(" The Node detelted is "+ qq.info); 
            t.dele(qq); 
            System.out.println(" The new list is "); 
            t.traverse(); 
            break; 
            case 17:  System.out.println(" 17. create and return array containing info of all nodes in the list."); 
            int[] arr=t.toArray2(listC); 
            System.out.println(" The new Array is "); 
            for(int jj=0;jj<arr.length;jj++) 
            System.out.print("   " + arr[jj]); 
            System.out.println(); 
            break; 
            case 18:  System.out.println("  18. add a node with value x  before the node p."); 
            System.out.print("Value of x: ");  
            val = keyIn.nextInt(); 
            t.addBefore(t.head.next.next.next,val); 
            System.out.println(" The new list is "); 
            t.traverse(); 
            break; 
            case 19:  System.out.println(" 19. find and return the maximum value in the list.  "); 
            t.traverse(); 
            System.out.println(" The Maximum is " + t.findmax()); 
            break; 
        

    }
}
