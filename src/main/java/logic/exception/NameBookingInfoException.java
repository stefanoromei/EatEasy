package logic.exception;

public class NameBookingInfoException extends Exception{

    public NameBookingInfoException() {
        super("Insert at least 3 characters.");
    }
}
