package flight;

public class Ticket {
    static int count;

    private String passengerName;
    private String flightName;
    private final int ticketId;

    public Ticket() {
        this.ticketId = ++count;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
}
