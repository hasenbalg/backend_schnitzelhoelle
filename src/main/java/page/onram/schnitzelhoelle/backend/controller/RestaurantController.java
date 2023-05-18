package page.onram.schnitzelhoelle.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import page.onram.schnitzelhoelle.backend.controller.exception.RestaurantNotFoundException;
import page.onram.schnitzelhoelle.backend.model.Restaurant;
import page.onram.schnitzelhoelle.backend.service.IRestaurantService;

@RestController
@RequestMapping("/api")
public class RestaurantController {
    private IRestaurantService restaurantService;

    public RestaurantController(IRestaurantService restaurantRepo) {
        this.restaurantService = restaurantRepo;
    };

    @GetMapping("/restaurants")
    public List<Restaurant> getAll() throws RestaurantNotFoundException {

        var allRestaurants = restaurantService.findAll();
        if (allRestaurants.isEmpty()) {
            throw new RestaurantNotFoundException("no restaurants found");
        }

        return allRestaurants;

    }

    @GetMapping("/restaurants/{id}")
    public Restaurant getById(@PathVariable("id") int id) throws Exception {
        return restaurantService.findById(id);
    }

    @DeleteMapping("/restaurants/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            restaurantService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@RequestBody Restaurant newRestaurant) {
        try {
            restaurantService.create(newRestaurant);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/restaurants")
    public ResponseEntity<?> update(
            @RequestBody Restaurant updatedRestaurant) {
        try {
            restaurantService.update(updatedRestaurant);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

   
}
