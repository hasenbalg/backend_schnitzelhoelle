package page.onram.schnitzelhoelle.backend.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SchnitzelRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<SchnitzelErrorResponse> handleException(SchnitzelNotFoundException exc) {
        SchnitzelErrorResponse errorResponse = new SchnitzelErrorResponse(HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<SchnitzelErrorResponse> handleException(Exception exc) {
        SchnitzelErrorResponse errorResponse = new SchnitzelErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
