package com.sachin.CountryCityOneMany.DTO;
import com.sachin.CountryCityOneMany.entity.City;
import java.util.List;

public class CountryCitiesDTO
{
    private String code;
    private String name;
    private String continent;
    private List<City> city;
    private int Capital;

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

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
}
