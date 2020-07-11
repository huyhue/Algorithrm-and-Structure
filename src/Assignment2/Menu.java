package Assignment2;
public class Menu {
//You should use 1 binary search tree to store data for trains and 2 linked lists, 
//each one is used to store data for customers or booking items.
    Validation valid = new Validation();

    public int menuProgram() {
        int choice;
         System.out.println("------------------------------");
        System.out.println("-------Welcome to system------");
        System.out.println("1. About A Train");
        System.out.println("2. About A Customer");
        System.out.println("3. About A Booking");
        System.out.println("0. Exit");
        System.out.println("------------------------------");
        System.out.print("What is your choice? ->: ");
        choice = valid.checkInputLimit(0, 3);
        System.out.println();
        System.out.println();
        return choice;
    }

    public int menuTrainList() {
        int choice;
        System.out.println("---------------****************************---------------");
        System.out.println("1.1.      Load data from file");
        System.out.println("1.2.      Input & insert data");
        System.out.println("1.3.      In-order traverse");
        System.out.println("1.4.      Breadth-first traverse");
        System.out.println("1.5.      In-order traverse to file");
        System.out.println("1.6.      Search by pcode");
        System.out.println("1.7.      Delete by pcode by copying");
        System.out.println("1.8.      Simply balancing");
        System.out.println("1.9.      Count number of trains");
        System.out.println("---------------****************************---------------");
        System.out.print("Choice option: ");
        choice = valid.checkInputLimit(0, 9);
        System.out.println();
        return choice;
    }

    public int menuCustomerList() {
        int choice;
        System.out.println(".............................................");
        System.out.println("---------------****************************---------------");
        System.out.println("2.1.Load data from file");
        System.out.println("2.2.Input & add to the end");
        System.out.println("2.3.Display data");
        System.out.println("2.4.Save customer list to file");
        System.out.println("2.5.Search by ccode");
        System.out.println("2.6.Delete by ccode");
        System.out.println("---------------****************************---------------");
        System.out.print("Choice option: ");
        choice = valid.checkInputLimit(0, 6);
        System.out.println();
        return choice;
    }

    public int menuBookingList() {
        int choice;
        System.out.println("---------------****************************---------------");
        System.out.println("3.1.Input data");
        System.out.println("3.2.Display data width available seats");
        System.out.println("3.3.Sort  by tcode + ccode");
        System.out.println("---------------****************************---------------");
        System.out.print("Choice option: ");
        choice = valid.checkInputLimit(0, 3);
        System.out.println();
        return choice;
    }
}
