package com.example.sample.exceptionhandler;
import com.example.sample.DTO.NotFoundExceptionDto;
import com.example.sample.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<NotFoundExceptionDto> handleInvalidProductIdException(ProductNotFoundException exception) {
        NotFoundExceptionDto exceptionDto = new NotFoundExceptionDto(exception.getProductId(), exception.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
