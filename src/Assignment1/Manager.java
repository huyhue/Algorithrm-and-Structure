package Assignment1;
import java.io.IOException;
public class Manager {
    Validation valid = new Validation();
    Menu menu = new Menu();
    TrainList listTrain = new TrainList();
    CusList listCus = new CusList();
    BookingList listBooking = new BookingList(listCus, listTrain);  //truyen vao de lien ket du lieu

    public void TrainList() throws IOException {
        int choice;
        do {
            choice = menu.menuTrainList();
            switch (choice) {
                case 1:
                    listTrain.loadFile("D://train.txt");
                    listTrain.traversal();
                    System.out.println();
                    break;
                case 2:
                    listTrain.addFirst();
                    System.out.println("** Add Successfully! **");
                    System.out.println();
                    break;
                case 3:
                    listTrain.traversal();
                    break;
                case 4:
                    listTrain.saveFile("D://train.txt");
                    System.out.println("**Save Successfully! **");
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter train code: ");
                    String tCode = valid.checkInputString();
                    listTrain.displayTrainFound(tCode);
                    System.out.println();
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Enter train code want to del: ");
                    String tCodeDel = "";
                    while (true) {
                        tCodeDel = valid.checkInputString();
                        if (listTrain.searchByTcode(tCodeDel) == null) {
                            System.err.print("Not found train code " + "\"" + tCodeDel + "\"" + " in list. Enter again: ");
                            System.out.println();
                        } else {
                            break;
                        }
                    }
                    listTrain.deleByTcode(tCodeDel);
                    System.out.println();
                    break;
                case 7:
                    listTrain.sortByTcode();
                    System.out.println("List Train After Sort: ");
                    listTrain.traversal();
                    System.out.println();
                    break;
                case 8:
                    int k = valid.checkPositiveInt("Enter position: ");
                    if (k == 1) {
                        listTrain.addFirst();
                        System.out.println("** Successfully! **");
                    } else {
                        Train train = listTrain.input();
                        listTrain.insertAfterPos(k, train);
                        System.out.println("** Insert after Successfully! **");
                    }
                    System.out.println();
                    break;
                case 9:
                    String tCodeSearch = "";
                    System.out.print("Enter train code: ");
                    do {
                        tCodeSearch = valid.checkInputString();
                        if (listTrain.searchByTcode(tCodeSearch) == null) {
                            System.err.print("The train code \"" + tCodeSearch + "\" not exist, Enter again: ");
                            System.out.println();
                        }
                    } while (listTrain.searchByTcode(tCodeSearch) == null);  //nhap 1 lan khac null la thoat.
                    listTrain.delePosBefore(tCodeSearch);
                    System.out.println();
                    break;
                case 0:
                    break;
            }
        }while(choice > 0 && choice < 10);
    }

    public void CustomerList() throws IOException {
        int choice;
        do{
            choice = menu.menuCustomerList();
            switch (choice) {
                case 1:
                    listCus.loadFile("D://customer.txt");
                    listCus.traversal();
                    System.out.println();
                    break;
                case 2:
                    Customer cus = listCus.input();
                    listCus.addLast(cus);
                    System.out.println("**Add Successfully! **");
                    System.out.println();
                    break;
                case 3:
                    listCus.traversal();
                    System.out.println();
                    break;
                case 4:
                    listCus.saveFile("D://customer.txt");
                    System.out.println("**Save Successfully! **");
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter customer code: ");
                    String cCodeSearch = valid.checkInputString();
                    listCus.displayCusFound(cCodeSearch);
                    System.out.println();
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Enter customer code want to delete: ");
                    String cCodeDel = "";
                    while (true) {
                        cCodeDel = valid.checkInputString();
                        if (listCus.searchByCcode(cCodeDel) == null) {
                            System.err.print("Not found customer code " + "\"" + cCodeDel + "\"" + " in list. Enter agian: ");
                            System.out.println();
                        } else {
                            break;
                        }
                    }
                    listCus.deleByCcode(cCodeDel);
                    System.out.println();
                    break;
                default:
                    break;
            }
        }while(choice>0 && choice<7);
    }

    public void BookingList() {
        int choice;
        do {
            choice = menu.menuBookingList();
            switch (choice) {
                case 1:
                    listBooking.addLast(listBooking.input());
                    System.out.println("**Add Successfully **!");
                    System.out.println();
                    break;
                case 2:
                    listBooking.traversal();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("List booking after sort: ");
                    listBooking.sortByBcode();
                    listBooking.traversal();
                    System.out.println();
                    break;
                default:
                    break;
            }
        }while (choice > 0 && choice < 4);
    }

}
