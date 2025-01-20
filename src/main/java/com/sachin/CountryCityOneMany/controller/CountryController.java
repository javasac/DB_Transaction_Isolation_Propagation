package com.sachin.CountryCityOneMany.controller;
import com.sachin.CountryCityOneMany.entity.City;
import com.sachin.CountryCityOneMany.entity.Country;
import com.sachin.CountryCityOneMany.repository.CityRepository;
import com.sachin.CountryCityOneMany.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController
{
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/all")
    public List<Country> findAllCountries()
    {
        return countryRepository.findAll();
    }

    @GetMapping("/{code}")
    public Optional<Country> findDesh(@PathVariable("code") String cd)
    {
        return countryRepository.findById(cd);
    }

    @GetMapping("/capital/{code}")
    public Optional<String> findCapital(@PathVariable("code") String cd)
    {
        return countryRepository.findCapital(cd);
    }

}
