package com.sachin.CountryCityOneMany.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "country")
public class Country
{
    @Id
    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @Column(name="continent")
    private String continent;

    @Column(name="capital")
    private int Capital;

    public Country(String code, String name, String continent, int Capital)
    {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.Capital = Capital;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getCapital() {
        return Capital;
    }

    public void setCapital(int capital) {
        Capital = capital;
    }

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, orphanRemoval = true)
    // name column is from City table and code is from Country table.
    @JoinColumn(name = "country", referencedColumnName = "code")
    @BatchSize(size=100)
    private List<City> city;
}