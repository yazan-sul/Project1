// this exception happens when the flight is full
public class NoTicketsAvailableException extends Exception {

    public NoTicketsAvailableException(String message) {
        super(message);
    }
}