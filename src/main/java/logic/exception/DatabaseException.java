package logic.exception;

public class DatabaseException extends Exception{

    public DatabaseException() {
        super("Problem with connection to the DB.");
    }
}
