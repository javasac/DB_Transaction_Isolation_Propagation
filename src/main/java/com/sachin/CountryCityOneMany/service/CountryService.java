package com.sachin.CountryCityOneMany.service;

import com.sachin.CountryCityOneMany.entity.Country;
import com.sachin.CountryCityOneMany.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService
{
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAllCountries()
    {
        return countryRepository.findAll();
    }

    public Optional<Country> findDesh(@PathVariable("code") String cd)
    {
        return countryRepository.findById(cd);
    }

    public Optional<String> findCapital(@PathVariable("code") String cd)
    {
        return countryRepository.findCapital(cd);
    }

}
