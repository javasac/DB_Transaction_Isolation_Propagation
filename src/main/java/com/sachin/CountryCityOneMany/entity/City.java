package com.sachin.CountryCityOneMany.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "city")
public class City
{
    @Id
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    public City()
    {
    }

    public City(String ID, String country, String name)
    {
        this.id = ID;
        this.name = name;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}