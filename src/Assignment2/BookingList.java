package Assignment2;

public class BookingList {

    Validation valid = new Validation();
    NodeBooking root;
    CusList cusList = null;
    TrainList trainList = null;

    public BookingList(CusList cusList, TrainList trainList) {
        this.cusList = cusList;
        this.trainList = trainList;
    }

    // check empty
    public boolean isEmpty() {
        return (root == null);
    }

    public void clear() {
        root = null;
    }

    public void visit(NodeBooking p) {
        if (p != null) {
            System.out.printf("%-5s |   %-7s |  %-5d |    %-6s|   %-8s|    %-7.1s|      %-8d\n", p.info.customer.cCode, p.info.customer.cName, p.info.customer.phone, p.info.train.tcode, p.info.train.train_name, p.info.train.depart_place, p.info.seatBooking);
        }
    }

    // add new Booking
    public Booking inputAndInsert() {
        String cCode = "";
        String bCode = "";
        int seat = 0;
        NodeBooking q = null;
        boolean check = true;
        while (true) {
            cCode = valid.checkString("Enter customer code: ");
            bCode = valid.checkString("Enter bus code: ");
            seat = valid.checkPositiveInt("Enter seat: ");
            check = checkAll(bCode, cCode, seat);
            if (check) {
                trainList.searchByTcode(trainList.root, bCode).infoTrain.upBooked(seat);
                return new Booking(cusList.searchByCode(cusList.root, cCode).infoCus, trainList.searchByTcode(trainList.root, bCode).infoTrain, seat);
            }
        }
    }

    public void inputData() {
        Booking x = inputAndInsert();

        if (isEmpty()) {
            root = new NodeBooking(x);
            return;
        }
        NodeBooking f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.customer.cCode.equalsIgnoreCase(x.customer.cCode)) {
                System.out.println("The Train: " + x + " already exists, no insertion");
                return;
            }
            f = p;
            if (p.info.customer.cCode.compareToIgnoreCase(x.customer.cCode) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (f.info.customer.cCode.compareToIgnoreCase(x.customer.cCode) > 0) {
            f.left = new NodeBooking(x);
        } else {
            f.right = new NodeBooking(x);
        }
    }

    // Check condition to be input
    public boolean checkAll(String tCode, String cCode, int seat) {
        boolean check = true;
        NodeBooking p = null;
        NodeTrain nodeTrain = trainList.searchByTcode(trainList.root, tCode);
        NodeCus nodeCus = cusList.searchByCode(cusList.root, cCode);
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

    public void inOrder(NodeBooking p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);

    }

    // check exist customer and bus
    public boolean checkExistTcodeCcode(String ccode, String tcode) {
        TrainList tl = new TrainList();
        CusList cl = new CusList();
        if (cl.searchByCode(cl.root, ccode) != null) {
            return true;
        }
        if (tl.searchByTcode(tl.root, tcode) != null) {
            return true;
        }
        return false;
    }

}
