package com.sachin.CountryCityOneMany.controller;
import com.sachin.CountryCityOneMany.entity.Country;
import com.sachin.CountryCityOneMany.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController
{
    @Autowired
    private CountryService countryService;

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
