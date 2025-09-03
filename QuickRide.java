
interface Cancellable {
    void cancel();
}


abstract class Booking {
    String bookingId;
    double amount;

    Booking(String bookingId, double amount) {
        this.bookingId = bookingId;
        this.amount = amount;
    }

    abstract void confirm();  
}


class CabBooking extends Booking implements Cancellable {
    CabBooking(String bookingId, double amount) {
        super(bookingId, amount);
    }

    void confirm() {
        System.out.println("Cab booked with ID " + bookingId + " for ₹" + amount);
    }

    public void cancel() {
        System.out.println("Cab booking " + bookingId + " cancelled. Refund: ₹" + (amount - 200));
    }
}


class TrainBooking extends Booking implements Cancellable {
    TrainBooking(String bookingId, double amount) {
        super(bookingId, amount);
    }

    void confirm() {
        System.out.println("Train ticket booked with ID " + bookingId + " for ₹" + amount);
    }

    public void cancel() {
        System.out.println("Train booking " + bookingId + " cancelled. Refund: ₹" + (amount - 200));
    }
}


class BusBooking extends Booking {
    BusBooking(String bookingId, double amount) {
        super(bookingId, amount);
    }

    void confirm() {
        System.out.println("Bus ticket booked with ID " + bookingId + " for ₹" + amount);
        System.out.println("Bus booking cannot be cancelled.");
    }
}


public class QuickRide {
    public static void main(String[] args) {
        CabBooking cab = new CabBooking("CAB101", 500);
        cab.confirm();
        cab.cancel();

        TrainBooking train = new TrainBooking("TRN202", 1200);
        train.confirm();
        train.cancel();

        BusBooking bus = new BusBooking("BUS303", 200);
        bus.confirm();
    }
}
