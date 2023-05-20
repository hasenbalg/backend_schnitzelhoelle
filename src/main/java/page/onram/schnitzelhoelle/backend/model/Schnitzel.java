package page.onram.schnitzelhoelle.backend.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Schnitzel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
    @CreationTimestamp
    protected Date createdAt;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return this.name;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Schnitzel() {
    }

    public Schnitzel(String name, Date createdAt) {
        this.createdAt = createdAt;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", createdAt='" + getCreatedAt() + "'" +
                "}";
    }

}
