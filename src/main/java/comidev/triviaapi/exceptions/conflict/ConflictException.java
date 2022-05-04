package comidev.triviaapi.exceptions.conflict;

public class ConflictException extends RuntimeException {
    private static final String TITLE = "Error de Conflicto";

    public ConflictException(String details) {
        super(TITLE + ": " + details);
    }
}
