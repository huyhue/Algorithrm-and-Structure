package Assignment1;
public class NodeCus {
    Customer infoCus;
    NodeCus next;

    NodeCus() {
        infoCus = null;
        next = null;
    }

    NodeCus(Customer infoCus, NodeCus next) {
        this.infoCus = infoCus;
        this.next = next;
    }

    NodeCus(Customer infoCus) {
        this(infoCus, null);
    }
}
