package page.onram.schnitzelhoelle.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import page.onram.schnitzelhoelle.backend.controller.exception.SchnitzelNotFoundException;
import page.onram.schnitzelhoelle.backend.model.Schnitzel;
import page.onram.schnitzelhoelle.backend.service.ISchnitzelService;

@RestController
@RequestMapping("/api")
public class SchnitzelController {
    private ISchnitzelService schnitzelService;

    public SchnitzelController(ISchnitzelService schnitzelService) {
        this.schnitzelService = schnitzelService;
    };

    @PostMapping("/schnitzels")
    public Schnitzel create(@RequestBody Schnitzel newSchnitzel) {
        newSchnitzel.setId(0);
        return schnitzelService.create(newSchnitzel);

    }

    @GetMapping("/schnitzels")
    public List<Schnitzel> getAll() throws SchnitzelNotFoundException {
        return schnitzelService.findAll();
    }

    @GetMapping("/schnitzels/{id}")
    public Schnitzel getById(@PathVariable("id") int id) throws Exception {
        return schnitzelService.findById(id);
    }

    @PutMapping("/schnitzels")
    public Schnitzel update(
            @RequestBody Schnitzel updatedSchnitzel) {
        return schnitzelService.update(updatedSchnitzel);

    }

    @DeleteMapping("/schnitzels/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            schnitzelService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
