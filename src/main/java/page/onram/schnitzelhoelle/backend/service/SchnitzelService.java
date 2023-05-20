package page.onram.schnitzelhoelle.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import page.onram.schnitzelhoelle.backend.controller.exception.SchnitzelNotFoundException;
import page.onram.schnitzelhoelle.backend.dao.ISchnitzelRepo;
import page.onram.schnitzelhoelle.backend.model.Schnitzel;

@Service
public class SchnitzelService implements ISchnitzelService {

    private ISchnitzelRepo schnitzelRepo;

    @Autowired
    public SchnitzelService(ISchnitzelRepo schnitzelRepo) {
        this.schnitzelRepo = schnitzelRepo;
    }

    public Schnitzel create(Schnitzel s) {
        s.setId(0);
        return schnitzelRepo.save(s);
    }

    public Schnitzel findById(int id) throws SchnitzelNotFoundException {
        var schnitzel = schnitzelRepo.findById(id);
        if (schnitzel == null) {
            throw new SchnitzelNotFoundException("schnitzel with id " + id + " not found");
        } else {
            return schnitzel.get();
        }

    }

    public List<Schnitzel> findAll() throws SchnitzelNotFoundException {

        var allSchnitzels = schnitzelRepo.findAll();
        if (allSchnitzels.isEmpty()) {
            throw new SchnitzelNotFoundException("No schnitzels in db");
        } else {
            return allSchnitzels;
        }
    }

    public Schnitzel update(Schnitzel s) {
        return schnitzelRepo.save(s);
    }

    public void delete(int id) {
        schnitzelRepo.deleteById(id);
    }

}
