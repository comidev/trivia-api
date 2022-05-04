package comidev.triviaapi.exceptions;

import lombok.Getter;

@Getter
public class ErrorMessage {
    private String message;
    private String path;
    private String exception;

    public ErrorMessage(Exception exception, String path) {
        this.message = exception.getMessage();
        this.exception = exception.getClass().getSimpleName();
        this.path = path;
    }

    @Override
    public String toString() {
        return "ErrorMessage{ "
                + "exception : " + exception + '\'' + ", "
                + "message : " + message + '\'' + ", "
                + "path : " + path + '\''
                + "  }";
    }
}
