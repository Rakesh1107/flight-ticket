package exception;

public class FlightException extends Throwable {
    String message;

    public FlightException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
