package Assignment1;
public class BookingList {
    Validation valid = new Validation();
    NodeBooking head, tail;
    CusList cusList = null;
    TrainList trainList = null;

    public BookingList(CusList cusList, TrainList trainList) {
        this.cusList = cusList;
        this.trainList = trainList;
    }

    public boolean isEmpty() {
        return (head == null);
    }
   
    public void visit(NodeBooking p) {
        if (p != null) {
            System.out.printf("%-5s |   %-7s |  %-5d |    %-6s|   %-8s|    %-7.1s|      %-8d\n", p.info.customer.cCode, p.info.customer.cName, p.info.customer.phone, p.info.train.tcode, p.info.train.train_name, p.info.train.depart_place, p.info.seatBooking);
        }
    }

    //add last
    public void addLast(Booking x) {
        NodeBooking p = new NodeBooking(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    // add new Booking
    public Booking input() {
        boolean check = true;
        while (true) {
            System.out.print("Enter train code: ");
            String tCode = valid.checkInputString();
            System.out.print("Enter customer code: ");
            String cCode = valid.checkInputString();
            int seat = valid.checkPositiveInt("Enter seat: ");
            check = checkAll(tCode, cCode, seat);
            if (check) {
                trainList.searchByTcode(tCode).infoTrain.upBooked(seat);
                return new Booking(cusList.searchByCcode(cCode).infoCus, trainList.searchByTcode(tCode).infoTrain, seat);
            }
        }
    }

    // Check condition to be input
    public boolean checkAll(String tCode, String cCode, int seat) {
        boolean check = true;
        NodeBooking p = null;
        NodeTrain nodeTrain = trainList.searchByTcode(tCode);
        NodeCus nodeCus = cusList.searchByCcode(cCode);
        if (nodeTrain == null || nodeCus == null) {
            System.err.println("Train code or customer code not exist. Please enter again: ");
            return false;
        }
        if (checkExistTcodeCcode(cCode, tCode)) {
            System.err.println("Information is already in the list. Please enter agian: ");
            return false;
        }
        if (nodeTrain.infoTrain.seat == nodeTrain.infoTrain.booked) {
            System.err.println("Train is exhausted. Please enter again");
            return false;
        }
        if (seat > (nodeTrain.infoTrain.seat - nodeTrain.infoTrain.booked)) {
            System.err.println("Please enter number seat in the range [ 1-" + (nodeTrain.infoTrain.seat - nodeTrain.infoTrain.booked) + "]");
            return false;
        }
        return check;
    }

    // check exist customer and bus
    public boolean checkExistTcodeCcode(String ccode, String tcode) {
        NodeBooking p = head;
        while (p != null) {
            if (p.info.customer.cCode.equalsIgnoreCase(ccode) && p.info.train.tcode.equalsIgnoreCase(tcode)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    //display
    public void traversal() {
        if (isEmpty()) {
            System.err.println("List empty!");
            System.out.println();
        } else {
            NodeBooking p = head;
            System.out.println("____________________________________________________________________________");
            System.out.printf("%-5s |  %-7s | %-5s  |   %-7s|  %-8s |%-5s| %-6s\n", "cCode", "Cus_Name", "Phone", "bCode", "Bus_Name", "Travel Time", "Seats Booked");
            System.out.println("-----------------------------------------------------------------------------");
            while (p != null) {
                visit(p);
                p = p.next;
            }
            System.out.println("____________________________________________________________________________");
            System.out.println();
        }//bai giong nhau mi oi, lenluon heo
    }

    // sort by code
    public void sortByBcode() {
        NodeBooking pi, pj;
        Booking x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if ((pi.info.train.tcode.compareTo(pj.info.train.tcode) + pi.info.customer.cCode.compareTo(pj.info.customer.cCode)) > -1) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
}
