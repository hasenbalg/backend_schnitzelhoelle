package page.onram.schnitzelhoelle.backend.service;

import java.util.List;

import page.onram.schnitzelhoelle.backend.model.Schnitzel;

public interface ISchnitzelService {
    Schnitzel create(Schnitzel s);

    List<Schnitzel> findAll();

    Schnitzel findById(int id);

    Schnitzel update(Schnitzel s);

    void delete(int id);
}
