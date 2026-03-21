package in.kb.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandelar {

    @ExceptionHandler({RuntimeException.class, AccountNotFountException.class, AccountCloseException.class})
    public ResponseEntity<Map<String, Object>> exceptionHandelar(Exception exception){
        Map<String, Object> list = new HashMap<>();
        list.put("status", HttpStatus.BAD_REQUEST.value());
        list.put("timetrem", LocalDate.now());
        list.put("erro", "BAD_REQUEST");
        list.put("message", exception.getMessage());
        return  new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);

    }
}
