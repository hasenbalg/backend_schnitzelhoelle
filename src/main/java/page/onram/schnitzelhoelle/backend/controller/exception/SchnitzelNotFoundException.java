package page.onram.schnitzelhoelle.backend.controller.exception;

public class SchnitzelNotFoundException extends RuntimeException {
    public SchnitzelNotFoundException(String message) {
        super(message);
    }
}