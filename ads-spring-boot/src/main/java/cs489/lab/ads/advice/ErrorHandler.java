package cs489.lab.ads.advice;

import cs489.lab.ads.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFoundException(NotFoundException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("ErrorMessage", exception.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleDataValidationErrors(MethodArgumentNotValidException methodArgumentNotValidException) {
        var errorMap = new HashMap<String, String>();
        methodArgumentNotValidException.getBindingResult()
                .getFieldErrors()
                .forEach(
                        error -> errorMap.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );
        return errorMap;
    }
}
