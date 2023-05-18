package page.onram.schnitzelhoelle.backend.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import page.onram.schnitzelhoelle.backend.controller.exception.SchnitzelNotFoundException;
import page.onram.schnitzelhoelle.backend.dao.ISchnitzelDao;
import page.onram.schnitzelhoelle.backend.dao.SchnitzelDao;
import page.onram.schnitzelhoelle.backend.model.Schnitzel;

@Component
public class SchnitzelRepo {

    private ISchnitzelDao schnitzelDao;

    @Autowired
    public SchnitzelRepo(SchnitzelDao schnitzelDao) {
        this.schnitzelDao = schnitzelDao;
    }

    public Schnitzel findById(int id) throws Exception {
        return schnitzelDao.findById(id);

    }

    public List<Schnitzel> findAll() throws SchnitzelNotFoundException {

        var allSchnitzels = schnitzelDao.findAll();
        if (allSchnitzels.isEmpty()) {
            throw new SchnitzelNotFoundException("No schnitzels in db");
        } else {
            return allSchnitzels;
        }
    }

    public void deleteById(int id) throws SchnitzelNotFoundException {

        schnitzelDao.delete(id);
    }

    public void create(Schnitzel s) {
        schnitzelDao.create(s);
    }

    public void update(Schnitzel s) throws SchnitzelNotFoundException {

        schnitzelDao.update(s);

    }
}
