package comidev.triviaapi.exceptions.badrequest;

public class BadRequestException extends RuntimeException {
    private static final String TITLE = "Error 400 :( mala petición";

    public BadRequestException(String details) {
        super(TITLE + ": " + details);
    }
}
