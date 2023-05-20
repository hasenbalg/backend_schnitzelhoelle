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

    @PostMapping("/restaurants")
    public Restaurant create(@RequestBody Restaurant newRestaurant) {
        newRestaurant.setId(0);
        var createdRestaurant = restaurantService.create(newRestaurant);
        return createdRestaurant;
    }

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

    @PutMapping("/restaurants")
    public Restaurant update(
            @RequestBody Restaurant updatedRestaurant) {
        return restaurantService.update(updatedRestaurant);

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

}
