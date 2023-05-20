package page.onram.schnitzelhoelle.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import page.onram.schnitzelhoelle.backend.model.Schnitzel;

public interface ISchnitzelRepo extends JpaRepository<Schnitzel, Integer>{
    
}
