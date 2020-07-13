package myTree;

import java.util.Arrays;

public class BSTree {

    TreeNode root;

    public BSTree() {
        root = null;
    }

    void insertNode(int x) {
        if (root == null) {
            root = new TreeNode(x);
            return;
        }
        TreeNode f, p;
        p = root;
        f = null;
        while (p != null) {
            if (p.info == x) {
                System.out.println("The key " + x + " already exists");
                return;
            }
            if (x < p.info) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (x < f.info) {
            f.left = new TreeNode(x);
        } else {
            f.right = new TreeNode(x);
        }
    }

    void visit(TreeNode p) {
        if (p == null) {
            return;
        }
        System.out.print(" " + p.info);
    }

    void inOrder(TreeNode p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(TreeNode p) {
        if (p == null) {
            return;
        }
        visit(p);
        inOrder(p.left);
        inOrder(p.right);
    }

    void addArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insertNode(a[i]);
        }
    }

    TreeNode balance(int[] a, int start, int end) {
        //base case
        if (start > end) {
            return null;
        }
        //lay phan tu middle
        int middle = (start + end) / 2;
        TreeNode rootNode = new TreeNode(a[middle]);
        insertNode(rootNode.info);
        //lam nhanh ben trai
        rootNode.left = balance(a, start, middle - 1);
        //lam nhanh ben phai
        rootNode.right = balance(a, middle + 1, end);
        return rootNode;
    }

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        int[] a = {3, 5, 1, 9, 8};
        System.out.println("Before sort" + Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("After sort" + Arrays.toString(a));
        int size = a.length;
//        tree.addArray(a);
//        System.out.println("Traverse ");
//        tree.inOrder(tree.root);
        tree.balance(a, 0, size-1);
        System.out.println("Pre-order traverse");
        tree.postOrder(tree.root);
        System.out.println("In-order traverse");
        tree.inOrder(tree.root);
    }

}
