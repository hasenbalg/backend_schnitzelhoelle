package page.onram.schnitzelhoelle.backend.dao;

import java.util.List;

import page.onram.schnitzelhoelle.backend.model.Schnitzel;

public interface ISchnitzelDao {
    public void create(Schnitzel schnitzel);

    public List<Schnitzel> findAll();

    public Schnitzel findById(int id);

    public void update(Schnitzel schnitzel);

    public void delete(int id);

    public int deleteAll();
}