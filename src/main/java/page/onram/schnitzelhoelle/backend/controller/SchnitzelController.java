package page.onram.schnitzelhoelle.backend.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import page.onram.schnitzelhoelle.backend.model.Schnitzel;
import page.onram.schnitzelhoelle.backend.repo.SchnitzelRepo;

@RestController
public class SchnitzelController {
    private SchnitzelRepo schnitzelRepo;

    public SchnitzelController(SchnitzelRepo schnitzelRepo) {
        this.schnitzelRepo = schnitzelRepo;
    };

    @GetMapping("/schnitzel")
    public List<Schnitzel> getAll() throws Exception {
        return schnitzelRepo.findAll();
    }

    @GetMapping("/schnitzel/{id}")
    public Schnitzel getById(@PathVariable("id") int id) throws Exception {
        return schnitzelRepo.findById(id);
    }

    @DeleteMapping("/schnitzel/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            schnitzelRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/schnitzel")
    public ResponseEntity<?> create(@RequestBody Schnitzel newSchnitzel) {
        try {
            schnitzelRepo.create(newSchnitzel);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/schnitzel")
    public ResponseEntity<?> update(
        @RequestBody Schnitzel updatedSchnitzel) {
        try {
            schnitzelRepo.update(updatedSchnitzel);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
