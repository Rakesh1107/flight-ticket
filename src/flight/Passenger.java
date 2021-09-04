package flight;

public class Passenger {
    private String name;
    private int age;
    private int ticketId;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTicket(int ticketId) {
        this.ticketId = ticketId;
    }
}
