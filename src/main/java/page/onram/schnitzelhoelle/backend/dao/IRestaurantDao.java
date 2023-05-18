package page.onram.schnitzelhoelle.backend.dao;

import java.util.List;

import page.onram.schnitzelhoelle.backend.model.Restaurant;


public interface IRestaurantDao {
    public void create(Restaurant restaurant);

    public List<Restaurant> findAll();

    public Restaurant findById(int id);

    public void update(Restaurant restaurant);

    public void delete(int id);

    public int deleteAll();
}
