package com.sachin.CountryCityOneMany.service;
import com.sachin.CountryCityOneMany.DTO.CapitalDTO;
import com.sachin.CountryCityOneMany.entity.City;
import com.sachin.CountryCityOneMany.entity.Country;
import com.sachin.CountryCityOneMany.repository.CityRepository;
import com.sachin.CountryCityOneMany.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.ApplicationEventPublisher;

@EnableTransactionManagement
@Service
public class CityService
{
    private final ApplicationEventPublisher publisher;

    public CityService(ApplicationEventPublisher publisher)
    {
        this.publisher = publisher;
    }

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    public List<City> findAllCities()
    {
        return cityRepository.findAll();
    }

    public List<CapitalDTO> findCapitalsById()
    {
        Sort sort = Sort.by(
                Sort.Order.asc("continent"),
                Sort.Order.desc("name")
        );

        Pageable ps = PageRequest.of(0, 6, sort);
        return cityRepository.findCapitalsById(ps);
    }

    public Optional<City> getCity(int id)
    {
        Optional<City> op = cityRepository.findById(id);
        return op;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW,
            rollbackFor = {NullPointerException.class, Exception.class})
    public String addCountryCity(String passfail) throws Exception
    {
        Country ctry = new Country("ENG", "England", "Europe", 6);
        countryRepository.save(ctry);

        List<City> cities = new ArrayList<City>();
        City c1 = new City("60", "ENG", "London");
        City c2 = new City("70", "ENG", "Liverpool");
        cities.add(c1);
        cities.add(c2);
        cityRepository.saveAll(cities);

        if ("pass".equalsIgnoreCase(passfail))
        {
            publisher.publishEvent("Transaction Committed");
            return "Success";
        }
        else
        {
            publisher.publishEvent("Transaction failed so rollback");
            throw new Exception();
        }
    }
}