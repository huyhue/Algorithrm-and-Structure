package Assignment2;

public class NodeCus {
    Customer infoCus;
    NodeCus left, right;

    NodeCus(Customer infoCus) {
        this.infoCus = infoCus;
        left = right = null;
    }
}
