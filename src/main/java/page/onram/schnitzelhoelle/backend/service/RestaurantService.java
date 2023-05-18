package page.onram.schnitzelhoelle.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import page.onram.schnitzelhoelle.backend.controller.exception.RestaurantNotFoundException;
import page.onram.schnitzelhoelle.backend.dao.IRestaurantDao;
import page.onram.schnitzelhoelle.backend.model.Restaurant;

@Service
public class RestaurantService implements IRestaurantService {

    private IRestaurantDao restaurantDao;

    @Autowired
    public RestaurantService(IRestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @Transactional
    public void create(Restaurant s) {
        restaurantDao.create(s);
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
            throw new RestaurantNotFoundException("No restaurants in db");
        } else {
            return allRestaurants;
        }
    }

    @Transactional
    public void update(Restaurant s) {
        restaurantDao.update(s);

    }

    @Transactional
    public void delete(int id) {
        restaurantDao.delete(id);
    }

}
