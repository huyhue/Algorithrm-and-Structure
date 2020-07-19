package Assignment2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class TrainList {

    Validation valid = new Validation();
    NodeTrain root;

    public TrainList() {
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void clear() {
        root = null;
    }

    public void insert(Train x) {
        if (isEmpty()) {
            root = new NodeTrain(x);
            return;
        }
        NodeTrain f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.infoTrain.tcode.equalsIgnoreCase(x.tcode)) {
                System.out.println("The Train: " + x + " already exists, no insertion");
                return;
            }
            f = p;
            if (p.infoTrain.tcode.compareToIgnoreCase(x.tcode) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (f.infoTrain.tcode.compareToIgnoreCase(x.tcode) > 0) {
            f.left = new NodeTrain(x);
        } else {
            f.right = new NodeTrain(x);
        }
    }

    //  input from file
    public void loadFile(String fname) throws IOException {
        RandomAccessFile f = new RandomAccessFile(fname, "r");
        String s;
        String[] a;
        String tcode, train_name;
        int seat, booked;
        double depart_time;
        String depart_place;
        Train x;
        while (true) {
            s = f.readLine();
            if (s == null || s.trim().equals("")) {
                break;
            }
            a = s.split("[|]");  //lay du lieu tu file
            tcode = a[0].trim();
            train_name = a[1].trim();
            seat = Integer.parseInt(a[2].trim());
            booked = Integer.parseInt(a[3].trim());
            depart_time = Double.parseDouble(a[4].trim());
            depart_place = a[5].trim();
            x = new Train(tcode, train_name, seat, booked, depart_time, depart_place);
            insert(x);
        }
        f.close();
    }

    public void inOrder(NodeTrain p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    public void breadthFirstTraverse(NodeTrain p) {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        NodeTrain r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    public void inOrderFile(NodeTrain n, RandomAccessFile f) throws IOException {
        if (n == null) {
            return;
        }
        inOrderFile(n.left, f);
        f.writeBytes(String.format("%-6s|  %-8s | %-3s |  %-4s |    %-6s|   %-11s\n", n.infoTrain.tcode, n.infoTrain.train_name, n.infoTrain.seat, n.infoTrain.booked, n.infoTrain.depart_time, n.infoTrain.depart_place));
        inOrderFile(n.right, f);
    }

    // save file
    public void saveFile(String filename) throws IOException {
        RandomAccessFile f;
        NodeTrain n = root;
        try {
            System.out.println("Writing data...");
            f = new RandomAccessFile(filename, "rw");
            f.setLength(0);
            inOrderFile(n, f);
            f.close();
            System.out.println("File written successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // input node
    public void inputInsert() {
        String tcode, train_name;
        int seat, booked;
        double depart_time;
        String depart_place;
        NodeTrain p;
        while (true) {
            tcode = valid.checkString("Enter train code: ");
            p = searchByTcode(root, tcode);
            if (p != null) {
                System.err.println("Train Code is already in the list. Please enter again: ");
            } else {
                train_name = valid.checkString("Enter train name: ");
                seat = valid.checkPositiveInt("Enter number seat: ");
                System.out.print("Enter number of  booked: ");
                booked = valid.checkInputLimit(0, seat);
                depart_time = valid.checkInputDouble("Enter depart tine: ");
                depart_place = valid.checkString("Enter train depart time: ");
                break;
            }
        }
        Train x = new Train(tcode, train_name, seat, booked, depart_time, depart_place);
        insert(x);
    }

    //search by bcode
    public NodeTrain searchByTcode(NodeTrain p, String tcode) {
        if (p == null) {
            return null;
        }
        if (p.infoTrain.tcode.equalsIgnoreCase(tcode)) {
            return p;
        }
        if (p.infoTrain.tcode.compareToIgnoreCase(tcode) > 0) {
            return searchByTcode(p.left, tcode);
        } else {
            return searchByTcode(p.right, tcode);
        }
    }

    // delete by bycode
    public void deleByCode(String bcode) {
        if (isEmpty()) {
            return;
        }
        NodeTrain f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.infoTrain.tcode.equalsIgnoreCase(bcode)) {
                break;
            }
            f = p;
            if (p.infoTrain.tcode.compareToIgnoreCase(bcode) > 0) {
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

        // p has left son ony
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

        // p has right son ony
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
            NodeTrain q = p.left; // q is the root of he left bub-tree
            NodeTrain frp, rp;
            frp = null;
            rp = q;
            // find the right-most node in the left-subtree
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp now is the right-most node
            p.infoTrain = rp.infoTrain; // replace p's content with rp's content
            if (frp == null) { // q is the right-mst node
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
        System.out.println("sucessful");
    }
    
    public void balance(ArrayList<Train> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        insert(t.get(k));
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    public void balance() {
        ArrayList<Train> t = new ArrayList<>();
        inOrder2(t, root);
        clear();
        int n = t.size();
        balance(t, 0, n - 1);
    }

    // 1.9
    public int CountNumberOfTrain() {
        ArrayList<Train> t = new ArrayList<>();
        inOrder2(t, root);
        return (t.size());
    }

    public void inOrder2(ArrayList<Train> t, NodeTrain p) {
        if (p == null) {
            return;
        }
        inOrder2(t, p.left);
        t.add(p.infoTrain);
        inOrder2(t, p.right);
    }

    // display data
    public void visit(NodeTrain p) {
        if (p != null) {
            System.out.printf("%-6s|   %-8s|  %-2d |  %-4d |  %-9.1f|      %-7s\n",p.infoTrain.tcode, p.infoTrain.train_name, p.infoTrain.seat, p.infoTrain.booked, p.infoTrain.depart_time, p.infoTrain.depart_place);
        }
    }

    
}
