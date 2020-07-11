package Assignment1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class CusList {
    Validation valid = new Validation();
    NodeCus head, tail;

    public CusList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    // add last
    public void addLast(Customer x) {
        NodeCus p = new NodeCus(x);
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
            addLast(x);
        }
        f.close();
    }

    //save file
    public void saveFile(String fname) throws IOException {
        File f = new File(fname);
        if (!f.exists()) {
            f.delete();
        }
        RandomAccessFile r = new RandomAccessFile(fname, "rw");

        NodeCus p = head;
        while (p != null) {
            r.writeBytes(p.infoCus.cCode + "\t" + "|" + "\t" + p.infoCus.cName + "\t" + "|" + "\t" + p.infoCus.phone + "\r\n");
            p = p.next;
        }
        r.close();
    }

    // input node
    public Customer input() {
        String cCode, cName;
        int phone;
        Scanner in = new Scanner(System.in);
        NodeCus p;
        while (true) {
            cCode = valid.checkString("Enter customer code: ");
            p = searchByCcode(cCode);
            if (p != null) {
                System.err.println("Customer Code is already in the list. Please enter again: ");
            } else {
                cName = valid.checkString("Enter customer name: ");
                phone = valid.checkPositiveInt("Enter phone: ");
                break;
            }
        }
        Customer x = new Customer(cCode, cName, phone);

        return x;
    }

    // add to end
    public void inputNewCus() {
        Customer p = input();
        addLast(p);
    }

    // display data
    public void visit(NodeCus p) {
        if (p != null) {
            System.out.printf("%-5s |   %-7s |   %-5d\n",
                    p.infoCus.cCode, p.infoCus.cName, p.infoCus.phone);
        }
    }

    public void traversal() {
        if (isEmpty()) {
            System.err.println("List empty!");
            System.out.println("");
        } else {
            NodeCus p = head;
            System.out.println("____________________________");
            System.out.printf("%-5s |  %-7s |  %-5s\n", "cCode", "Cus_Name", "Phone");
            System.out.println("---------------------------");
            while (p != null) {
                visit(p);
                p = p.next;
            }
            System.out.println("____________________________");
            System.out.println("");
        }
    }

    //search by bcode
    public NodeCus searchByCcode(String cCode) {
        NodeCus p = head;
        while (p != null) {
            if (p.infoCus.cCode.equalsIgnoreCase(cCode)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // display info customer when find by code
    public void displayCusFound(String cCode) {
        if (searchByCcode(cCode) == null) {
            System.err.println("Not exist \"" + cCode + "\" in the list customer.");
        } else {
            System.out.println("Found. This is information: ");
            System.out.println();
            System.out.printf("%-5s |  %-7s |  %-5s\n", "cCode", "Cus_Name", "Phone");
            System.out.println("---------------------------");
            System.out.printf("%-5s |   %-7s |   %-5d\n",searchByCcode(cCode).infoCus.cCode, searchByCcode(cCode).infoCus.cName, searchByCcode(cCode).infoCus.phone);
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
    public void dele(NodeCus q) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            deleFist();

        } else {
            NodeCus p = head;
            while (p != null && p.next != q) {
                p = p.next;
            }
            if (p == null) {
                return;
            }
            p.next = q.next;
            if (p.next == null) {
                tail = p;
            }
            System.out.println("** Del Successfully! **");
        }
    }

    // dele by bcode
    public void deleByCcode(String cCode) {
        NodeCus q = searchByCcode(cCode);
        dele(q);
    }
}
