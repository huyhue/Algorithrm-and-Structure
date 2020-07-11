package LAB4;

public class BTree {

    Node root;

    BTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    boolean search(Node p, int x) {
        if (p == null) {
            return false;
        }
        if (p.info == x) {
            return true;
        }
        boolean res1 = search(p.left, x);
        if (res1) {
            return true;
        }
        boolean res2 = search(p.right, x);

        return res2;
    }

    Node insertRec(Node root, int info) {
        if (root == null) {
            root = new Node(info);
            return root;
        }
        if (info < root.info) {
            root.left = insertRec(root.left, info);
        } else if (info > root.info) {
            root.right = insertRec(root.right, info);
        }
        return root;
    }

    void visit(Node p) {
        System.out.print(p.info + " ");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        inOrder(p.left);
        inOrder(p.right);
    }

    int count(Node p) {
        if (p == null) {
            return (0);
        }
        int k, h, r;
        k = count(p.left);
        h = count(p.right);
        r = 1 + k + h;
        return (r);
    }

    int avg(Node p) {
        int k = sum(p) / count(p);
        return k;
    }

    int minValue(Node root) {
        int minv = root.info;
        while (root.left != null) {
            minv = root.left.info;
            root = root.left;
        }
        return minv;
    }

    Node deleteRec(Node root, int infox) {
        if (root == null) {
            return root;
        }
        if (infox < root.info) {
            root.left = deleteRec(root.left, infox);
        } else if (infox > root.info) {
            root.right = deleteRec(root.right, infox);
        } else {
            if (root.left != null && root.right != null) {
                Node minNodeForRight = new Node();
                minNodeForRight.info = minValue(root.right);
                root.info = minNodeForRight.info;
                deleteRec(root.right, minNodeForRight.info);
            }
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    void clear() {
        root = null;
    }

    int height(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);
            int rDepth = height(p.right);
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }
    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level) { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.info + " "); 
        else if (level > 1){ 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
    
    void traversal(Node root) { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, i); 
    } 

    boolean isFullTree(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }
        if ((root.left != null) && (root.right != null)) {
            return false;
        }
        return false;
    }

    int maxValue(Node root) {
        int maxv = root.info;
        while (root.right != null) {
            maxv = root.right.info;
            root = root.right;
        }
        return maxv;
    }

    int sum(Node root) {
        if (root == null) {
            return 0;
        }
        return (root.info + sum(root.left) + sum(root.right));
    }
}
