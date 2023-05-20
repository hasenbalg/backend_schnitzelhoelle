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
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
    protected String country;
    protected String zipCode;
    protected String city;
    protected String street;
    protected String houseNum;

    // no setters
    @CreationTimestamp
    @Column(updatable = false)
    protected Instant createdAt;
    @UpdateTimestamp
    @Column(updatable = false)
    protected Instant lastModifiedAt;

    public Restaurant() {
    }

    public Restaurant(int id, String name, String country, String zipCode, String city, String street, String houseNum,
            Instant createdAt, Instant lastModifiedAt) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.houseNum = houseNum;
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

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNum() {
        return this.houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
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
                ", country='" + getCountry() + "'" +
                ", zipCode='" + getZipCode() + "'" +
                ", city='" + getCity() + "'" +
                ", street='" + getStreet() + "'" +
                ", houseNum='" + getHouseNum() + "'" +
                ", createdAt='" + getCreatedAt() + "'" +
                ", lastModifiedAt='" + getLastModifiedAt() + "'" +
                "}";
    }

}
