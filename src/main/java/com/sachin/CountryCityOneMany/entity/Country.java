package com.sachin.CountryCityOneMany.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Country
{
    @Id
    @Column(name="Cid")
    private String Cid;
    @Column(name="Name")
    private String Name;
    @Column(name="Continent")
    private String Continent;
    @Column(name="Population")
    private int Population;
    @Column(name="Capital")
    private int Capital;

    public Country(String Cid, String Name, String Continent, int Population, int Capital)
    {
        this.Cid = Cid;
        this.Name = Name;
        this.Continent = Continent;
        this.Population = Population;
        this.Capital = Capital;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public int getCapital() {
        return Capital;
    }

    public void setCapital(int capital) {
        Capital = capital;
    }

    @OneToMany(targetEntity = City.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Country", referencedColumnName = "Cid")
    private List<City> city;
}