package com.sachin.CountryCityOneMany.controller;
import com.sachin.CountryCityOneMany.DTO.CountryCitiesDTO;
import com.sachin.CountryCityOneMany.entity.City;
import com.sachin.CountryCityOneMany.entity.Country;
import com.sachin.CountryCityOneMany.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController
{
    @Autowired
    private CountryService countryService;

    @PutMapping("/update/{code}")
    public Country updateCountry(@PathVariable String code, @RequestBody CountryCitiesDTO dto)
    {
        return countryService.update(code, dto);
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountryWithCities(@RequestBody CountryCitiesDTO dto)
    {
        System.out.println("=========addCountryWithCities========" + dto.getName());

        List<City> ciList = dto.getCity();
        for (City c : ciList)
        {
            System.out.println("City details are " + c.getId() + ", " + c.getCountry() + ", " + c.getName());
        }

        Country newCo = countryService.addCountryCities(dto);
        return new ResponseEntity<>(newCo, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{code}")
    public void deleteCountryCities(@PathVariable("code") String code)
    {
        countryService.delete(code);
    }

    @GetMapping("/all")
    public List<Country> findAllCountries()
    {
        return countryService.findAllCountries();
    }

    @GetMapping("/{code}")
    public Optional<Country> findDesh(@PathVariable("code") String cd)
    {
        return countryService.findDesh(cd);
    }

    @GetMapping("/capital/{code}")
    public Optional<String> findCapital(@PathVariable("code") String cd)
    {
        return countryService.findCapital(cd);
    }
}
