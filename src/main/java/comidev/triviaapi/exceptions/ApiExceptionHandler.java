package comidev.triviaapi.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import comidev.triviaapi.exceptions.badrequest.BadRequestException;
import comidev.triviaapi.exceptions.conflict.ConflictException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.dao.DuplicateKeyException.class,
            org.springframework.web.HttpRequestMethodNotSupportedException.class,
            org.springframework.web.bind.MethodArgumentNotValidException.class,
            org.springframework.web.bind.MissingRequestHeaderException.class,
            org.springframework.web.bind.MissingServletRequestParameterException.class,
            org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class })
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage badRequest(Exception exception, HttpServletRequest request) {
        return new ErrorMessage(exception, request.getRequestURI());
    }

    @ExceptionHandler({ ConflictException.class })
    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorMessage onflict(Exception exception, HttpServletRequest request) {
        return new ErrorMessage(exception, request.getRequestURI());
    }
}
