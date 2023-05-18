package page.onram.schnitzelhoelle.backend.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Restaurant findById(int id) throws Exception {
        return restaurantDao.findById(id);

    }

    public List<Restaurant> findAll() throws Exception {
        return restaurantDao.findAll();
    }

    public void deleteById(int id) {
        restaurantDao.delete(id);
    }

    public void create(Restaurant r) {
        restaurantDao.create(r);
    }

    public void update(Restaurant r) throws Exception {
        restaurantDao.update(r);

    }
}
