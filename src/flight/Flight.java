package flight;

import java.util.Map;

abstract class Flight {
    String name;
    int capacity;
    int ticketPrice;
    int seatsFilled;
    Map<Integer, Passenger> passengers;

    abstract void bookTicket(Passenger passenger);

    abstract void cancelTicket(int ticketId);
}
