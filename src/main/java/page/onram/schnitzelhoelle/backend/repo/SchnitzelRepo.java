package page.onram.schnitzelhoelle.backend.repo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import page.onram.schnitzelhoelle.backend.model.Schnitzel;

@Component
public class SchnitzelRepo {

    Schnitzel[] schnitzels;

    public SchnitzelRepo() {
        schnitzels = new Schnitzel[] {
                new Schnitzel(0, "Jager", new Date()),
                new Schnitzel(1, "Zigeuner", new Date()),
                new Schnitzel(2, "Wiener", new Date()),
        };
    }

    public Schnitzel findById(int id) throws Exception {
        var schnitzel = Arrays.asList(schnitzels).stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        return schnitzel.get();

    }

    public List<Schnitzel> findAll() throws Exception {
        return Arrays.asList(schnitzels);
    }

    public void deleteById(int id) {
        Schnitzel[] newSchnitzels = new Schnitzel[schnitzels.length - 1];
        for (int i = 0, k = 0; i < schnitzels.length; i++) {
            if (schnitzels[i].getId() != id) {
                newSchnitzels[k] = schnitzels[i];
                k++;
            }
        }
        schnitzels = newSchnitzels;
    }

    public void create(Schnitzel s) {
        Schnitzel[] newSchnitzels = new Schnitzel[schnitzels.length + 1];

        int newId = Arrays.asList(schnitzels).stream().max((x, y) -> x.getId() - y.getId()).get().getId() + 1;
        for (int i = 0; i < schnitzels.length; i++) {
            newSchnitzels[i] = schnitzels[i];
        }
        newSchnitzels[newSchnitzels.length - 1] = new Schnitzel(newId, s.getName(), new Date());
        schnitzels = newSchnitzels;
    }

    public void update(Schnitzel s) throws Exception {
        try {
            Schnitzel foundSchnitzel = findById(s.getId());

            for (int i = 0; i < schnitzels.length; i++) {
                if (schnitzels[i].getId() == foundSchnitzel.getId()) {
                    schnitzels[i] = new Schnitzel(foundSchnitzel.getId(), s.getName(), foundSchnitzel.getCreatedAt());
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
}
