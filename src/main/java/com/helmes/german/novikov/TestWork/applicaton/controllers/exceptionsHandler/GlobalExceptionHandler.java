package com.helmes.german.novikov.TestWork.applicaton.controllers.exceptionsHandler;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler({RuntimeException.class})
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ApiError handleRunTimeException(RuntimeException exception) {
        log.error("Unhandled error.", exception);
        return new ApiError("Internal server error. Please try again. If error persists please contact support.");
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(BAD_REQUEST)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(hidden = true)
    public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return convert(exception);
    }

    private ApiError convert(BindingResult bindingResult) {
        var fieldErrors = bindingResult.getFieldErrors().stream().distinct().collect(Collectors.toList());
        Map<String, ApiErrorItem[]> errors = fieldErrors.stream().collect(
            Collectors.collectingAndThen(Collectors.groupingBy(FieldError::getField),
            errorsHashMap -> errorsHashMap.entrySet().stream().collect(
                Collectors.toMap(
                    Entry::getKey,
                    pair -> pair.getValue().stream().map(fieldError -> new ApiErrorItem(fieldError.getDefaultMessage())).toArray(ApiErrorItem[]::new)
                ))));
        return new ApiError(errors);
    }

}