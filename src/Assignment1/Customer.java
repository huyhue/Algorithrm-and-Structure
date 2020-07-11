package Assignment1;
public class Customer {

    public String cCode;
    public String cName;
    public int phone;

    public Customer() {
    }

    public Customer(String cCode, String cName, int phone) {
        this.cCode = cCode;
        this.cName = cName;
        this.phone = phone;
    }

    public void displayInfoCustomer() {
        System.out.printf("%-15s %-15s %-10s\n", cCode, cName, phone);
    }

    @Override
    public String toString() {
        return " " + cCode + "\t" + cName + "\t" + phone;
    }

}
