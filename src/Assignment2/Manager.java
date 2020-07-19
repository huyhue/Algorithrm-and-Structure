package Assignment2;

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
                    listTrain.inOrder(listTrain.root);
                    System.out.println();
                    break;
                case 2:
                    listTrain.inputInsert();
                    System.out.println("** Add And Inseart Successfully! **");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("In-order traverse: ");
                    listTrain.inOrder(listTrain.root);
                    break;
                case 4:
                    System.out.println("Breadth-First Traverse: ");//chua hieu lam
                    listTrain.breadthFirstTraverse(listTrain.root);
                    break;
                case 5:
                    listTrain.saveFile("D://train.txt");
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Enter train code: ");
                    String value = valid.checkInputString();
                    if (listTrain.searchByTcode(listTrain.root, value) != null) {
                        System.out.println("Found in information");
                    } else {
                        System.out.println("Not Found in information");
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.print("Enter train code want to delete: ");
                    String value1 = "";
                    while (true) {
                        value1 = valid.checkInputString();
                        if (listTrain.searchByTcode(listTrain.root, value1) != null) {
                            break;
                        } else {
                            System.out.println("Not Found in information");
                        }
                    }
                    listTrain.deleByCode(value1);
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Balanced: ");
                    listTrain.balance();
                    break;
                case 9:
                    System.out.println("Numbers of trains: " + listTrain.CountNumberOfTrain());
                    System.out.println();
                    break;
                case 0:
                    break;
            }
        } while (choice > 0 && choice < 10);
    }

    public void CustomerList() throws IOException {
        int choice;
        do {
            choice = menu.menuCustomerList();
            switch (choice) {
                case 1:
                    listCus.loadFile("D://customer.txt");
                    listCus.display();
                    System.out.println();
                    break;
                case 2:
                    listCus.inputInsert();
                    System.out.println("**Add and Insert Successfully! **");
                    System.out.println();
                    break;
                case 3:
                    listCus.display();
                    System.out.println();
                    break;
                case 4:
                    listCus.saveFile("D://customer.txt");
                    System.out.println("**Save Successfully! **");
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter customer code: ");
                    String cCode = valid.checkInputString();
                    if (listCus.searchByCode(listCus.root, cCode) != null) {
                        System.out.println("Found in information");
                    } else {
                        System.out.println("Not Found in information");
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Enter customer code want to delete: ");
                    String cCodeDel = "";
                    while (true) {
                        cCodeDel = valid.checkInputString();
                        if (listCus.searchByCode(listCus.root, cCodeDel) != null) {
                            break;
                        } else {
                            System.out.println("Not Found in information");
                        }
                    }
                    listCus.deleByCode(cCodeDel);
                    System.out.println();
                    break;
                case 0:
                    return;
            }
        } while (choice > 0 && choice < 7);
    }

    public void BookingList() {
        int choice;
        do {
            choice = menu.menuBookingList();
            switch (choice) {
                case 1:
                    listBooking.inputData();
                    System.out.println("**Add Successfully **!");
                    System.out.println();
                    break;
                case 2:
                    listBooking.inOrder(listBooking.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("List booking after sort: ");
                    listBooking.inOrder(listBooking.root);
                    System.out.println();
                    break;
                case 0:
                    return;
            }
        } while (choice > 0 && choice < 4);
    }

}
