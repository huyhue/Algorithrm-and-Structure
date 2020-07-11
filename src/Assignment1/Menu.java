package Assignment1;
public class Menu {

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
        System.out.println("1.1.Load data from file");
        System.out.println("1.2.Input & add to the head");
        System.out.println("1.3.Display data");
        System.out.println("1.4.Save train list to file");
        System.out.println("1.5.Search by tcode");
        System.out.println("1.6.Delete by tcode");
        System.out.println("1.7.Sort by tcode");
        System.out.println("1.8.Add after position  k");
        System.out.println("1.9.Delete the node before the node having tcode = xCode");
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
