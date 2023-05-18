package page.onram.schnitzelhoelle.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import page.onram.schnitzelhoelle.backend.controller.exception.SchnitzelNotFoundException;
import page.onram.schnitzelhoelle.backend.dao.ISchnitzelDao;
import page.onram.schnitzelhoelle.backend.model.Schnitzel;

@Service
public class SchnitzelService implements ISchnitzelService {

    private ISchnitzelDao schnitzelDao;

    @Autowired
    public SchnitzelService(ISchnitzelDao schnitzelDao) {
        this.schnitzelDao = schnitzelDao;
    }

    @Transactional
    public void create(Schnitzel s) {
        schnitzelDao.create(s);
    }

    public Schnitzel findById(int id) throws SchnitzelNotFoundException {
        var schnitzel = schnitzelDao.findById(id);
        if (schnitzel == null) {
            throw new SchnitzelNotFoundException("schnitzel with id " + id + " not found");
        } else {
            return schnitzel;
        }

    }

    public List<Schnitzel> findAll() throws SchnitzelNotFoundException {

        var allSchnitzels = schnitzelDao.findAll();
        if (allSchnitzels.isEmpty()) {
            throw new SchnitzelNotFoundException("No schnitzels in db");
        } else {
            return allSchnitzels;
        }
    }

    @Transactional
    public void update(Schnitzel s) {

        schnitzelDao.update(s);
    }

    @Transactional
    public void delete(int id) {

        schnitzelDao.delete(id);
    }

}
