package page.onram.schnitzelhoelle.backend.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import page.onram.schnitzelhoelle.backend.controller.exception.RestaurantNotFoundException;
import page.onram.schnitzelhoelle.backend.controller.exception.SchnitzelNotFoundException;
import page.onram.schnitzelhoelle.backend.dao.IRestaurantDao;
import page.onram.schnitzelhoelle.backend.dao.RestaurantDao;
import page.onram.schnitzelhoelle.backend.model.Restaurant;

@Component
public class RestaurantRepo {

    private IRestaurantDao restaurantDao;

    @Autowired
    public RestaurantRepo(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public Restaurant findById(int id) throws RestaurantNotFoundException {
        var restaurant = restaurantDao.findById(id);
        if (restaurant == null) {
            throw new RestaurantNotFoundException("restaurant with id " + id + " not found");
        } else {
            return restaurant;
        }
    }

    public List<Restaurant> findAll() throws RestaurantNotFoundException {
        var allRestaurants = restaurantDao.findAll();
        if (allRestaurants.isEmpty()) {
            throw new RestaurantNotFoundException("no restaurants found in db");
        } else {
            return allRestaurants;
        }
    }

    public void deleteById(int id) throws Exception {
        restaurantDao.delete(id);
    }

    public void create(Restaurant r) {
        restaurantDao.create(r);
    }

    public void update(Restaurant r) {
        restaurantDao.update(r);

    }
}
