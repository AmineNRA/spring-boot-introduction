package tech.chillo.sa_backend.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import tech.chillo.sa_backend.dto.ErrorEntity;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ EntityNotFoundException.class })
    public ErrorEntity handleException(EntityNotFoundException exception) {
        return new ErrorEntity(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }
}
