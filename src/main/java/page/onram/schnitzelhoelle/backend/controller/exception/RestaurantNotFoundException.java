package page.onram.schnitzelhoelle.backend.controller.exception;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(String cause) {
        super(cause);
    }
}