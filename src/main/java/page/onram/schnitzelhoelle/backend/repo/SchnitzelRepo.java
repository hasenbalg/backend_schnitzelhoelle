package page.onram.schnitzelhoelle.backend.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public List<Schnitzel> findAll() throws Exception {
        return schnitzelDao.findAll();
    }

    public void deleteById(int id) {
        schnitzelDao.delete(id);
    }

    public void create(Schnitzel s) {
        schnitzelDao.create(s);
    }

    public void update(Schnitzel s) throws Exception {
        schnitzelDao.update(s);

    }
}
