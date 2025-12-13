package com.sachin.CountryCityOneMany.service;
import com.sachin.CountryCityOneMany.DTO.CountryCitiesDTO;
import com.sachin.CountryCityOneMany.entity.City;
import com.sachin.CountryCityOneMany.entity.Country;
import com.sachin.CountryCityOneMany.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService
{
    @Autowired
    private CountryRepository countryRepository;

    public Country update(String code, CountryCitiesDTO dto)
    {
        Country co = new Country();
        Optional<Country> opt = countryRepository.findById(code);

        if (opt.isPresent())
        {
            co.setCode(dto.getCode());
            co.setName(dto.getName());
            co.setContinent(dto.getContinent());
            co.setCity(dto.getCity());
            co.setCapital(dto.getCapital());

            return countryRepository.save(co);
        }
        else
        {
            return null;
        }
    }

    public Country addCountryCities(CountryCitiesDTO dto)
    {
        System.out.println("======Service===addCountryCities====");

        Country co = new Country();

        co.setCode(dto.getCode());
        co.setName(dto.getName());
        co.setContinent(dto.getContinent());
        co.setCity(dto.getCity());
        co.setCapital(dto.getCapital());

        co = countryRepository.save(co);
        return co;
    }

    public void delete(String code)
    {
        countryRepository.deleteById(code);
    }

    public List<Country> findAllCountries()
    {
        return countryRepository.findAll();
    }

    public Optional<Country> findDesh(String cd)
    {
        return countryRepository.findById(cd);
    }

    public Optional<String> findCapital(String cd)
    {
        return countryRepository.findCapital(cd);
    }
}
