package page.onram.schnitzelhoelle.backend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import page.onram.schnitzelhoelle.backend.model.Schnitzel;

@Repository
public class SchnitzelDao implements ISchnitzelDao {
    public EntityManager entityManager;

    @Autowired
    public SchnitzelDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Schnitzel schnitzel) {
        entityManager.persist(schnitzel);
    }

    @Override
    public List<Schnitzel> findAll() {
        TypedQuery<Schnitzel> allSchnitzelsQuery = entityManager.createQuery("FROM Schnitzel", Schnitzel.class);
        return allSchnitzelsQuery.getResultList();
    }

    public List<Schnitzel> findAllOorderedByName() {
        TypedQuery<Schnitzel> allSchnitzelsQuery = entityManager.createQuery("FROM Schnitzel ORDERED BY name ASC",
                Schnitzel.class);
        return allSchnitzelsQuery.getResultList();
    }

    public List<Schnitzel> findByName(String name) {
        TypedQuery<Schnitzel> schnitzelsQuery = entityManager.createQuery("FROM Schnitzel WHERE name = nameValue",
                Schnitzel.class);
        schnitzelsQuery.setParameter("nameValue", name);
        return schnitzelsQuery.getResultList();
    }

    @Override
    public Schnitzel findById(int id) {
        return entityManager.find(Schnitzel.class, id);
    }

    @Override
    public Schnitzel update(Schnitzel schnitzel) {
      var updatedSchnitzel =   entityManager.merge(schnitzel);
      return updatedSchnitzel;
    }

    @Override
    public void delete(int id) {
        var schnitzel = entityManager.find(Schnitzel.class, id);
        entityManager.remove(schnitzel);
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETEFROM Schnitzel").executeUpdate();
    }

}
