package com.sachin.CountryCityOneMany.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@ToString
@Entity
public class City
{
    @Id
    @Column(name="ID")
    private String ID;
    @Column(name="City")
    private String City;
    @Column(name="Country")
    private String Country;

    public City()
    {
    }

    public City(String ID, String Country, String City)
    {
        this.ID = ID;
        this.City = City;
        this.Country = Country;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}