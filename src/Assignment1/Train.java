package Assignment1;
public class Train {
    public String tcode;
    public String train_name;
    public int seat;
    public int booked;
    public double depart_time;
    public String depart_place;

    public Train() {
    }

    public Train(String tcode, String train_name, int seat, int booked, double depart_time, String depart_place) {
        this.tcode = tcode;
        this.train_name = train_name;
        this.seat = seat;
        this.booked = booked;
        this.depart_time = depart_time;
        this.depart_place = depart_place;
    }

   
    public int upBooked(int booked) {
        return this.booked = this.booked + booked;
    }

    @Override
    public String toString() {
        return "booking{" + "tcode=" + tcode + ", train_name=" + train_name + ", seat=" + seat + ", booked=" + booked + ", depart_time=" + depart_time + ", depart_place=" + depart_place + '}';
    }
}
