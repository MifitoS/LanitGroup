package ru.lanit.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ErrorDTO> onMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ) {
        final List<ErrorDTO> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorDTO(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return errors;
    }

}