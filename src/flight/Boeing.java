package flight;

import java.util.HashMap;

public class Boeing extends Flight {

    public Boeing() {
        this.name = "Boeing";
        this.capacity = 50;
        this.seatsFilled = 0;
        this.ticketPrice = 5000;
        this.passengers = new HashMap<>();
    }

    @Override
    public void bookTicket(Passenger passenger) {
        if (seatsFilled < capacity) {
            passengers.put(passenger.getTicketId(), passenger);
            System.out.println("Ticket booked successfully for " + passenger.getName() + " in Boeing. Ticket id is " + passenger.getTicketId());
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
            System.out.println("Ticket cancellation successful");
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
