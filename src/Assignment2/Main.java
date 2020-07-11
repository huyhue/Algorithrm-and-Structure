package Assignment2;
import java.io.IOException;
public class Main {

    public static void main(String[] args) throws IOException {
        Manager manager = new Manager();
        Menu menu = new Menu();
        while (true) {
            int choice = menu.menuProgram();
            switch (choice) {
                case 1:
                    manager.TrainList();
                    System.out.println();
                    break;
                case 2:
                    manager.CustomerList();
                    System.out.println();
                    break;
                case 3:
                    manager.BookingList();
                    System.out.println();
                    break;
                case 0:
                    return;
            }
        }
    }
}
