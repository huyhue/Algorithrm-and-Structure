package LAB4;

import java.util.Scanner;
public class Main {

    static int menu() {
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println();
        System.out.println("1.boolean isEmpty() - return true if a tree is empty, return false otherwise.");
        System.out.println("2.void clear() - clear a tree.");
        System.out.println("3.Node search(int x) - Search a node having value x. Return a reference to that node if found, return null otherwise.");
        System.out.println("4.void insert(int x) - check if the key x does not exists in a tree then insert new node with value x into the tree.");
        System.out.println("5.void breadth() - traverse a tree.");
        System.out.println("6.void preorder(Node p) - recursive preorder traverse of a tree.");
        System.out.println("7.void inorder(Node p) - recursive inorder traverse of a tree.");
        System.out.println("8.void postorder(Node p) - recursive postorder traverse of a tree.");
        System.out.println("9.int count() - count and return number of nodes in the tree.");
        System.out.println("10.void dele(int x) - delete a node having value x.");
        System.out.println("11.Node min() - find and return the node with minimum value in the tree.");
        System.out.println("12.Node max() - find and return the node with maximum value in the tree.");
        System.out.println("13.int sum() - return the sum of all values in the tree.");
        System.out.println("14.int avg() - return the average of all values in the tree.");
        System.out.println("15.The height of a tree is : ");
        System.out.println("16.Exit!");
        do {
            System.out.print("Please enter your choice : ");
            option = sc.nextInt();
            sc.nextLine();
        } while (option < 1 && option > 15);
        return option;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        BTree tree = new BTree();
        Scanner s = new Scanner(System.in);
        Node rootA = tree.insertRec(tree.root, 50);
        tree.insertRec(rootA, 30);
        tree.insertRec(rootA, 20);
        tree.insertRec(rootA, 40);
        tree.insertRec(rootA, 70);
        tree.insertRec(rootA, 60);
        tree.insertRec(rootA, 80);

        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    if (tree.isFullTree(rootA) == true) {
                        System.out.println("Full tree!");
                    }else{
                        System.out.println("Empty tree!");
                    }
                    break;
                case 2:
                    tree.clear();
                    break;
                case 3:
                    System.out.print("Enter value: ");
                    int x = s.nextInt();
                    if (tree.search(rootA, x)) {
                        System.out.println("Found it ! ");
                    } else {
                        System.out.println("Not found ! ");
                    }
                    break;
                case 4:
                    System.out.print("Enter value: ");
                    int x1 = s.nextInt();
                    tree.insertRec(rootA, x1);
                    System.out.println("Inserted!");
                    tree.inOrder(rootA);
                    break;
                case 5:
                    System.out.println("Hight tree: " + tree.height(rootA));
                    tree.traversal(rootA);
                    break;
                case 6:
                    tree.preOrder(rootA);
                    break;
                case 7:
                    tree.inOrder(rootA);
                    break;
                case 8:
                    tree.postOrder(rootA);
                    break;
                case 9:
                    System.out.println(tree.count(rootA) + " Node");
                    break;
                case 10:
                    System.out.print("Enter value you want to delete in tree: ");
                    int x2 = s.nextInt();
                    tree.deleteRec(rootA, x2);
                    System.out.println("Deleted ! ");
                    tree.inOrder(rootA);
                    break;
                case 11:
                    System.out.println("MIN: "+tree.minValue(rootA));
                    break;
                case 12:
                    System.out.println("MAX: "+tree.maxValue(rootA));
                    break;
                case 13:
                    System.out.println("SUM: "+tree.sum(rootA));
                    break;
                case 14:
                    System.out.println("AVERAGE: "+tree.avg(rootA));
                    break;
                case 15:
                    System.out.println("HEIGHT: "+tree.height(rootA));
                    break;
                case 16:
                    System.out.println("goodbye ! ");
                    break;
            }
        }
    }

}
