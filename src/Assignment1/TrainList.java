package Assignment1;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
public class TrainList {

    Validation valid = new Validation();
    NodeTrain head;
    NodeTrain tail;

    public TrainList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    // add last
    public void addLast(Train x) {
        NodeTrain p = new NodeTrain(x);

        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
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
            a = s.split("[|]");
            tcode = a[0].trim();
            train_name = a[1].trim();
            seat = Integer.parseInt(a[2].trim());
            booked = Integer.parseInt(a[3].trim());
            depart_time = Double.parseDouble(a[4].trim());
            depart_place = a[5].trim();
            x = new Train(tcode, train_name, seat, booked, depart_time, depart_place);
            addLast(x);
        }
        f.close();
    }

    // save file
    public void saveFile(String filename) throws IOException {
        File f = new File(filename);
        if (!f.exists()) {
            f.delete();
        }
        RandomAccessFile r = new RandomAccessFile(filename, "rw");

        NodeTrain p = head;
        while (p != null) {
            r.writeBytes(p.infoTrain.tcode + "\t" + "|" + p.infoTrain.train_name + "\t" + "|" + p.infoTrain.seat + "\t" + "|" + p.infoTrain.booked + "\t" + "|" + p.infoTrain.depart_time + "\t" + "|" + p.infoTrain.depart_place + "\r\n");
            p = p.next;
        }
        r.close();
    }

    // input node
    public Train input() {
        String tcode, train_name;
        int seat, booked;
        double depart_time;
        String depart_place;
        NodeTrain p;
        while (true) {
            tcode = valid.checkString("Enter train code: ");
            p = searchByTcode(tcode);
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
        return x;
    }

    //search by bcode
    public NodeTrain searchByTcode(String tcode) {
        NodeTrain p = head;  //p la chung cua doi tuong
        while (p != null) {
            if (p.infoTrain.tcode.equalsIgnoreCase(tcode)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // display info bus when find by code
    public void displayTrainFound(String tCode) {
        if (searchByTcode(tCode) == null) {
            System.err.println("Not exist \"" + tCode + "\" in list train.");
        } else {
            System.out.println("Found. This is information: ");
            System.out.println();
            System.out.println("________________________________________________________________________");
            System.out.printf("%-6s|  %-8s |%-2s |%-2s |%-5s| %-6s\n", "tCode", "Train_Name", "Seat", "Booked", "Depart Time", "Depart Place");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-6s|   %-8s|  %-2d |  %-4d |  %-9.1f|      %-7s\n",
                    searchByTcode(tCode).infoTrain.tcode, searchByTcode(tCode).infoTrain.train_name, searchByTcode(tCode).infoTrain.seat,
                    searchByTcode(tCode).infoTrain.booked, searchByTcode(tCode).infoTrain.depart_time, searchByTcode(tCode).infoTrain.depart_place);
        }
    }

    //sort by bcode
    public void sortByTcode() {
        NodeTrain pi;
        NodeTrain pj;
        Train x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.infoTrain.tcode.compareTo(pj.infoTrain.tcode) > -1) {
                    x = pi.infoTrain;
                    pi.infoTrain = pj.infoTrain;
                    pj.infoTrain = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    //add to end
    public void inputNewTrain() {
        Train p = input();
        addLast(p);
    }

    // display data
    public void visit(NodeTrain p) {
        if (p != null) {
            //System.out.println(p.info);
            System.out.printf("%-6s|   %-8s|  %-2d |  %-4d |  %-9.1f|      %-7s\n",
                    p.infoTrain.tcode, p.infoTrain.train_name, p.infoTrain.seat, p.infoTrain.booked, p.infoTrain.depart_time, p.infoTrain.depart_place);
        }
    }

    // display
    public void traversal() {
        if (isEmpty()) {
            System.err.println("List empty!");
            System.out.println();
        } else {
            NodeTrain p = head;
            System.out.println("________________________________________________________________________");
            System.out.printf("%-6s|  %-8s |%-2s |%-2s |%-5s| %-6s\n", "tCode", "Train_Name", "Seat", "Booked", "Depart Time", "Depart_place");
            System.out.println("------------------------------------------------------------------------");
            while (p != null) {
                visit(p);
                p = p.next;
            }
            System.out.println("________________________________________________________________________");
            System.out.println();
        }
    }

    // delete fist
    public void deleFist() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        System.out.println("** Del Successfully! **");
    }

    // dele node q
    public void dele(NodeTrain q) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            deleFist();
        } else {
            NodeTrain p = head;
            while (p != null && p.next != q) {
                p = p.next;  //tim cai node can xoa
            }
            if (p == null) {
                return;
            }
            p.next = q.next;  //giay doan xoa
            if (p.next == null) {
                tail = p;
            }
            System.out.println("** Delete Successfully! **");
        }
    }

    // dele by bcode
    public void deleByTcode(String tCode) {
        NodeTrain q = searchByTcode(tCode);   //tim vi tri cua node trong doi tuong
        dele(q);  //tien hanh xoa
    }

    public int findIndexTcode(String tCode) {
        int index = 1;
        NodeTrain p = head;
        while (!p.infoTrain.tcode.equalsIgnoreCase(tCode)) {
            p = p.next;
            index++;
        }
        return index;
    }

    public void delePosBefore(String tCode) {
        int k = findIndexTcode(tCode);   //tim vi tri chi so do
        NodeTrain p = head;
        int count = 0;
        while (p != null) {
            if (k == 1) {
                System.out.println("Not exist train to delete");
                break;
            }
            if (count++ == k - 2) {
                dele(p);
                break;
            }
            p = p.next;
        }
    }

    //add first
    public void addFirst() {
        Train x = input();
        NodeTrain p = new NodeTrain(x);
        p.next = head;
        head = p;
        if (tail == null) {
            tail = head;
        }
    }

    // insert after
    public void insertNode(NodeTrain q, Train x) {
        if (q == null) {
            return;
        }
        NodeTrain p = new NodeTrain(x, q.next);
        q.next = p;  //chen vao vi tri
        if (p.next == null) {
            tail = p;
        }
    }

    //insert after k
    public void insertBeforePos(int k, Train x) {
        NodeTrain q = new NodeTrain(x);
        int count = 0;
        NodeTrain p = head;

        while (p != null) {
            if (count++ == k - 2) {  //vi tri 0 1 2 3 4 ...
                insertNode(p, x);   //chen vao cai node do
                break;
            }
            p = p.next;
        }
    }

    // insert after
    public void insertAfter(NodeTrain q, Train x) {
        if (q == null) {
            return;
        }
        NodeTrain p = new NodeTrain(x, q.next);
        q.next = p;
        if (p.next == null) {
            tail = p;
        }
    }

    //insert after k
    public void insertAfterPos(int k, Train x) {
        NodeTrain q = new NodeTrain(x);
        int count = 0;
        NodeTrain p = head;
        while (p != null) {
            if (count++ == k-1) {
                insertAfter(p, x);
                break;
            }
            p = p.next;
        }
    }

    //dele st pos k
    public void delePos(int k) {
        NodeTrain p = head;
        int count = 0;
        while (p != null) {
            if (count++ == k) {
                dele(p);
                break;
            }
            p = p.next;
        }
    }
}
