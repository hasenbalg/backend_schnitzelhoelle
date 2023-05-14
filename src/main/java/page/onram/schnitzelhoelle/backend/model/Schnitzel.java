package page.onram.schnitzelhoelle.backend.model;

import java.util.Date;

public class Schnitzel {
    protected final int id;
    protected final String name;
    protected final Date createdAt;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Schnitzel(int id, String name, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
    }

}
