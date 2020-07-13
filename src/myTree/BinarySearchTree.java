package myTree;

import java.util.Scanner;
public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    TreeNode insertNode(TreeNode root, int info) {
        TreeNode node = new TreeNode(info);
        if (root == null) {
            root = node;
            return root;
        }
        if (info < root.info) {
            root.left = insertNode(root.left, info);
        } else if (info > root.info) {
            root.right = insertNode(root.right, info);
        }
        return root;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(" " + root.info);
        inOrder(root.right);
    }

    public TreeNode search(TreeNode root, int infox) {
        if (root == null || root.info == infox) {
            return root;
        }
        if (root.info > infox) {
            return search(root.left, infox);
        }
        return search(root.right, infox);
    }
    
    int count(TreeNode p){
        if (p == null) {
            return 0;
        }
        int k, h, r;
        k = count(p.left);
        h = count(p.right);
        r = k + h + 1;
        return r;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner s = new Scanner(System.in);
        System.out.println("Root at the beginging is: " + tree.root);
        TreeNode rootA = tree.insertNode(tree.root, 50);
        System.out.println("Root after insertion is: " + rootA.info);
        tree.insertNode(rootA, 30);
        System.out.println("Root after insertion is: " + rootA.info);
        System.out.println("Left root after insertion is: " + rootA.left.info);
        tree.insertNode(rootA, 20);
        System.out.println("lEFR Root after insertion is: " + rootA.left.info);
        tree.insertNode(rootA, 40);
        tree.insertNode(rootA, 70);
        System.out.println("Right Root after insertion is: " + rootA.right.info);
        tree.insertNode(rootA, 60);
        tree.insertNode(rootA, 80);

        tree.inOrder(rootA);
        System.out.println("");
        System.out.println("Count of root: " + tree.count(rootA));
        System.out.print("Enter value of TreeNode: ");
        int val = s.nextInt();
        TreeNode p = tree.search(rootA, val);
        if (p != null) {
            System.out.println(val + " found in the tree");
        } else {
            System.out.println(val + " not found in the tree");
        }
        
        
    }

}
