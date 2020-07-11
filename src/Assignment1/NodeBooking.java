package Assignment1;
public class NodeBooking {
    Booking info;
    NodeBooking next;
    
    NodeBooking() {
        info = null;
        next = null;
    }
    
    NodeBooking(Booking info, NodeBooking next) {
        this.info = info;
        this.next = next;
    }
    
    NodeBooking(Booking info) {
        this(info, null);
    }
    
}
