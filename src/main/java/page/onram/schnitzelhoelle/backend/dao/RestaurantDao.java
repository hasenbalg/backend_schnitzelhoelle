package page.onram.schnitzelhoelle.backend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import page.onram.schnitzelhoelle.backend.model.Restaurant;

@Repository
public class RestaurantDao implements IRestaurantDao {
    public EntityManager entityManager;

    @Autowired
    public RestaurantDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Restaurant restaurant) {
        entityManager.persist(restaurant);
    }

    @Override
    public List<Restaurant> findAll() {
        TypedQuery<Restaurant> allRestaurantsQuery = entityManager.createQuery("FROM Restaurant", Restaurant.class);
        return allRestaurantsQuery.getResultList();
    }

    public List<Restaurant> findAllOorderedByName() {
        TypedQuery<Restaurant> allRestaurantsQuery = entityManager.createQuery("FROM Restaurant ORDERED BY name ASC",
        Restaurant.class);
        return allRestaurantsQuery.getResultList();
    }

    public List<Restaurant> findByName(String name) {
        TypedQuery<Restaurant> restaurantsQuery = entityManager.createQuery("FROM Restaurant WHERE name = nameValue",
        Restaurant.class);
        restaurantsQuery.setParameter("nameValue", name);
        return restaurantsQuery.getResultList();
    }

    @Override
    public Restaurant findById(int id) {
        return entityManager.find(Restaurant.class, id);
    }

    @Override
    public void update(Restaurant restaurant) {
        entityManager.merge(restaurant);
    }

    @Override
    public void delete(int id) {
        var restaurant = entityManager.find(Restaurant.class, id);
        entityManager.remove(restaurant);
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETEFROM Restaurant").executeUpdate();
    }

}
