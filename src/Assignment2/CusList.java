package Assignment2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class CusList {

    Validation valid = new Validation();
    NodeCus root;

    public CusList() {
        root = null;
    }

    // check empty
    public boolean isEmpty() {
        return (root == null);
    }

    public void clear() {
        root = null;
    }

    public void insert(Customer x) {
        if (isEmpty()) {
            root = new NodeCus(x);
            return;
        }
        NodeCus f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.infoCus.cCode.equalsIgnoreCase(x.cCode)) {
                System.out.println("The key " + x + " already exists, no insertion");
                return;
            }
            f = p;
            if (p.infoCus.cCode.compareToIgnoreCase(x.cCode) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (f.infoCus.cCode.compareToIgnoreCase(x.cCode) > 0) {
            f.left = new NodeCus(x);
        } else {
            f.right = new NodeCus(x);
        }
    }

    //  input from file
    public void loadFile(String fname) throws IOException {
        RandomAccessFile f = new RandomAccessFile(fname, "r");
        String s;
        String[] a;
        String cCode, cName;
        int phone;
        Customer x;
        while (true) {
            s = f.readLine();
            if (s == null || s.trim().equals("")) {
                break;
            }
            a = s.split("[|]");
            cCode = a[0].trim();
            cName = a[1].trim();
            phone = Integer.parseInt(a[2].trim());
            x = new Customer(cCode, cName, phone);
            insert(x);
        }
        f.close();
    }

    public void inOrderFile(NodeCus n, RandomAccessFile f) throws IOException {
        if (n == null) {
            return;
        }
        inOrderFile(n.left, f);
        f.writeBytes(String.format("%-5s |   %-7s |   %-5d\n", n.infoCus.cCode, n.infoCus.cName, n.infoCus.phone));
        inOrderFile(n.right, f);
    }

    public void saveFile(String fname) {
        RandomAccessFile f;
        NodeCus n = root;
        try {
            System.out.println("Writing data...");
            f = new RandomAccessFile(fname, "rw");
            f.setLength(0);
            inOrderFile(n, f);
            f.close();
            System.out.println("File written successfully!\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public NodeCus searchByCode(NodeCus p, String cCode) {
        if (p == null) {
            return null;
        }
        if (p.infoCus.cCode.equalsIgnoreCase(cCode)) {
            return p;
        }
        if (p.infoCus.cCode.compareToIgnoreCase(cCode) > 0) {
            return searchByCode(p.left, cCode);
        } else {
            return searchByCode(p.right, cCode);
        }
    }

    // input node
    public void inputInsert() {
        String cCode, cName;
        int phone;
        Scanner in = new Scanner(System.in);
        NodeCus p;
        while (true) {
            cCode = valid.checkString("Enter customer code: ");
            p = searchByCode(root,cCode);
            if (p != null) {
                System.err.println("Customer Code is already in the list. Please enter again: ");
            } else {
                cName = valid.checkString("Enter customer name: ");
                phone = valid.checkPositiveInt("Enter phone: ");
                break;
            }
        }
        Customer x = new Customer(cCode, cName, phone);
        insert(x);
    }

    // display data
    public void visit(NodeCus p) {
        if (p != null) {
            System.out.printf("%-5s |   %-7s |   %-5d\n", p.infoCus.cCode, p.infoCus.cName, p.infoCus.phone);
        }
    }

    public void inOrder(NodeCus p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    public void display() {
        inOrder(root);
    }

    public void deleByCode(String cCode) {
        if (isEmpty()) {
            return;
        }
        NodeCus f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.infoCus.cCode.equalsIgnoreCase(cCode)) {
                break;
            }
            f = p;
            if (p.infoCus.cCode.compareToIgnoreCase(cCode) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return; // not found
        } // p is a leaf-node
        if (p.left == null && p.right == null) {
            if (f == null) { // p is a root
                root = null;
            } else {
                if (p == f.left) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }

        // p has left son
        if (p.left != null && p.right == null) {
            if (f == null) { // p is a root
                root = p.left;
            } else {
                if (p == f.left) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }

        // p has right son
        if (p.left == null && p.right != null) {
            if (f == null) { // p is a root
                root = p.right;
            } else {
                if (p == f.left) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }

        // p has both 2 sons
        if (p.left != null && p.right != null) {
            NodeCus q = p.left; // q is the root of he left sub-tree
            NodeCus frp, rp;
            frp = null;
            rp = q;
            // find the right-most node in the left-subtree
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp now is the right-most node
            p.infoCus = rp.infoCus; // replace p's content with rp's content
            if (frp == null) { // q is the right-mst node
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
        System.out.println("sucessful");
    }

    public void balance(ArrayList<Customer> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        insert(t.get(k));
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    public void balance() {
        ArrayList<Customer> t = new ArrayList<Customer>();
        inOrder2(t, root);
        clear();
        int n = t.size();
        balance(t, 0, n - 1);
    }

    public void inOrder2(ArrayList<Customer> t, NodeCus p) {
        if (p == null) {
            return;
        }
        inOrder2(t, p.left);
        t.add(p.infoCus);
        inOrder2(t, p.right);
    }

}
