package flight;

import java.util.HashMap;

public class Airbus extends Flight {

    public Airbus() {
        this.name = "Airbus";
        this.capacity = 50;
        this.seatsFilled = 0;
        this.ticketPrice = 5000;
        this.passengers = new HashMap<>();
    }

    @Override
    public void bookTicket(Passenger passenger) {
        if (seatsFilled < capacity) {
            passengers.put(passenger.getTicketId(), passenger);
            System.out.println("Ticket booked successfully for " + passenger.getName() + " in Airbus");
            this.seatsFilled++;
            this.ticketPrice += 200;
            return;
        }
        System.out.println("Sorry, seat limit reached!");
    }

    @Override
    public void cancelTicket(int ticketId) {
        if (passengers.containsKey(ticketId)) {
            passengers.remove(ticketId);
            this.seatsFilled--;
            this.ticketPrice -= 200;
            return;
        }
        System.out.println("No such ticket exists!");
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Capacity: " + capacity + ", Seats Filled: " + seatsFilled + ", Ticket Price: " + ticketPrice;
    }
}
