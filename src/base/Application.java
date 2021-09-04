package base;

import exception.FlightException;
import flight.Airbus;
import flight.Boeing;
import flight.Passenger;
import flight.Ticket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static Airbus airbus = new Airbus();
    static Boeing boeing = new Boeing();

    public static void start() {

        boolean running = true;

        while (running) {
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Show flight details");
            System.out.println("0. Exit application");

            int option = 0;
            try {
                option = getInt();
                if (option == 0) {
                    running = false;
                    System.out.println("Exiting application");
                    break;
                }
                handle(option);
            } catch (FlightException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void handle(int option) {
        switch (option) {
            case 1 -> bookTicket();
            case 2 -> cancelTicket();
            case 3 -> showFlightDetails();
            default -> System.out.println("Enter valid option");
        }
    }

    private static void bookTicket() {
        try {
            System.out.println("Enter name: ");
            String name = getString();
            System.out.println("Enter age: ");
            int age = getInt();
            System.out.println("Enter flight name: (Airbus/Boeing)");
            String flight = getString();

            if (flight.equalsIgnoreCase("airbus")) {
                Ticket ticket = new Ticket();
                ticket.setPassengerName(name);
                ticket.setFlightName(flight);

                Passenger passenger = new Passenger();
                passenger.setTicket(ticket.getTicketId());
                passenger.setName(name);
                passenger.setAge(age);

                airbus.bookTicket(passenger);
            }
            else if (flight.equalsIgnoreCase("boeing")) {
                Ticket ticket = new Ticket();
                ticket.setPassengerName(name);
                ticket.setFlightName(flight);

                Passenger passenger = new Passenger();
                passenger.setTicket(ticket.getTicketId());
                passenger.setName(name);
                passenger.setAge(age);

                boeing.bookTicket(passenger);
            }
            else {
                System.out.println("Enter a valid flight name");
            }
        }
        catch (FlightException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void cancelTicket() {
        try {
            System.out.println("Enter ticket id");
            int ticketId = getInt();
            System.out.println("Enter flight name");
            String flight = getString();

            if (flight.equalsIgnoreCase("airbus")) {
                airbus.cancelTicket(ticketId);
            }
            else if (flight.equalsIgnoreCase("boeing")) {
                boeing.cancelTicket(ticketId);
            }
            else {
                System.out.println("Enter a valid flight name");
            }
        }
        catch (FlightException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showFlightDetails() {
        System.out.println(airbus);
        System.out.println(boeing);
    }

    private static int getInt() throws FlightException {
        int number = 0;
        try {
            number = Integer.parseInt(input.readLine());
        } catch (IOException | NumberFormatException e) {
            throw new FlightException("Enter valid number");
        }
        return number;
    }

    private static String getString() throws FlightException {
        String word = "";
        try {
            word = input.readLine();
        }
        catch (IOException e) {
            throw new FlightException("Enter a valid name");
        }
        return word;
    }


}
