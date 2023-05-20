package page.onram.schnitzelhoelle.backend.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
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

    // no setters
    @CreationTimestamp
    @Column(updatable = false)
    protected Instant createdAt;
    @UpdateTimestamp
    @Column(updatable = false)
    protected Instant lastModifiedAt;

    public Schnitzel() {
    }

    public Schnitzel(int id, String name, Instant createdAt, Instant lastModifiedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.lastModifiedAt = lastModifiedAt;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Instant getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", createdAt='" + getCreatedAt() + "'" +
                ", lastModifiedAt='" + getLastModifiedAt() + "'" +
                "}";
    }

}
