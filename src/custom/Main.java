package custom;
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Customer a = new Customer("Nguyen Xuan Nghiep", "DE140022");
        Customer b = new Customer("Nguyen Quang Hung", "DE140016");
        Customer c = new Customer("Tran Kim Viet", "DE140021");
        Customer d = new Customer("Nguyen Truong Phuc", "DE140006");
        list.addHead(a);
        list.addToTail(d);

        list.addHead(b);
        list.addHead(c);
        list.display();
        System.out.println("--------------------------");
        System.out.println("Size: " + list.getSize());
        System.out.println("--------------------------");
        list.deleteFirst();
        list.display();
        
    }
}
