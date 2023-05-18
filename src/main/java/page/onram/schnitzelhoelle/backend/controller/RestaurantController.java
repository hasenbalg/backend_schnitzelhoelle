package page.onram.schnitzelhoelle.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import page.onram.schnitzelhoelle.backend.controller.exception.RestaurantErrorResponse;
import page.onram.schnitzelhoelle.backend.controller.exception.RestaurantNotFoundException;
import page.onram.schnitzelhoelle.backend.model.Restaurant;
import page.onram.schnitzelhoelle.backend.repo.RestaurantRepo;

@RestController
@RequestMapping("/api")
public class RestaurantController {
    private RestaurantRepo restaurantRepo;

    public RestaurantController(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    };

    @GetMapping("/restaurant")
    public List<Restaurant> getAll() throws RestaurantNotFoundException {

        var allRestaurants = restaurantRepo.findAll();
        if (allRestaurants.isEmpty()) {
            throw new RestaurantNotFoundException("no restaurants found");
        }

        return allRestaurants;

    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getById(@PathVariable("id") int id) throws Exception {
        return restaurantRepo.findById(id);
    }

    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            restaurantRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/restaurant")
    public ResponseEntity<?> create(@RequestBody Restaurant newRestaurant) {
        try {
            restaurantRepo.create(newRestaurant);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/restaurant")
    public ResponseEntity<?> update(
            @RequestBody Restaurant updatedRestaurant) {
        try {
            restaurantRepo.update(updatedRestaurant);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ExceptionHandler
    public ResponseEntity<RestaurantErrorResponse> handleException(RestaurantNotFoundException exc) {
        RestaurantErrorResponse errorResponse = new RestaurantErrorResponse(HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<RestaurantErrorResponse> handleException(Exception exc) {
        RestaurantErrorResponse errorResponse = new RestaurantErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
