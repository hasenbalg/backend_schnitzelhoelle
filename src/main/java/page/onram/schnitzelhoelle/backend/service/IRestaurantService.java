package page.onram.schnitzelhoelle.backend.service;

import java.util.List;

import page.onram.schnitzelhoelle.backend.model.Restaurant;

public interface IRestaurantService {
    void create(Restaurant s);

    List<Restaurant> findAll();

    Restaurant findById(int id);

    void update(Restaurant s);

    void delete(int id);
}
