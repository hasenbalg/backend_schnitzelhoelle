package page.onram.schnitzelhoelle.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import page.onram.schnitzelhoelle.backend.controller.exception.RestaurantNotFoundException;
import page.onram.schnitzelhoelle.backend.dao.IRestaurantRepo;
import page.onram.schnitzelhoelle.backend.model.Restaurant;

@Service
public class RestaurantService implements IRestaurantService {

    private IRestaurantRepo restaurantRepo;

    @Autowired
    public RestaurantService(IRestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    public Restaurant create(Restaurant r) {
        r.setId(0);
        return restaurantRepo.save(r);
    }

    public Restaurant findById(int id) throws RestaurantNotFoundException {
        var restaurant = restaurantRepo.findById(id);
        if (restaurant == null) {
            throw new RestaurantNotFoundException("restaurant with id " + id + " not found");
        } else {
            return restaurant.get();
        }
    }

    public List<Restaurant> findAll() throws RestaurantNotFoundException {
        var allRestaurants = restaurantRepo.findAll();
        if (allRestaurants.isEmpty()) {
            throw new RestaurantNotFoundException("No restaurants in db");
        } else {
            return allRestaurants;
        }
    }

    public Restaurant update(Restaurant r) {
        return restaurantRepo.save(r);
    }

    public void delete(int id) {
        restaurantRepo.deleteById(id);
    }

}
