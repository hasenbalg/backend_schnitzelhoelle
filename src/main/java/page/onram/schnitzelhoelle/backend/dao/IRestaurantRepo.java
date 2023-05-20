package page.onram.schnitzelhoelle.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import page.onram.schnitzelhoelle.backend.model.Restaurant;


public interface IRestaurantRepo extends JpaRepository<Restaurant, Integer>{
    
}
