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

    @GetMapping("/schnitzels")
    public List<Schnitzel> getAll() throws SchnitzelNotFoundException {
        return schnitzelService.findAll();
    }

    @GetMapping("/schnitzels/{id}")
    public Schnitzel getById(@PathVariable("id") int id) throws Exception {
        return schnitzelService.findById(id);
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

    @PostMapping("/schnitzels")
    public ResponseEntity<?> create(@RequestBody Schnitzel newSchnitzel) {
        try {
            schnitzelService.create(newSchnitzel);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/schnitzels")
    public ResponseEntity<?> update(
            @RequestBody Schnitzel updatedSchnitzel) {
        try {
            schnitzelService.update(updatedSchnitzel);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
