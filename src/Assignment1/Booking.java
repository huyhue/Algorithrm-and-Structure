package Assignment1;
public class Booking {
    public Customer customer;
    public Train train;
    public int seatBooking;

    public Booking() {
        
    }

    public Booking(Customer customer, Train train, int seatBooking) {
        this.customer = customer;
        this.train = train;
        this.seatBooking = seatBooking;
    }

    @Override
    public String toString() {
        return "" + customer + "\t" + train.tcode + "\t" + train.train_name + "\t" + train.depart_time + "\t" + train.depart_place + "\t" + seatBooking;
    }
}
