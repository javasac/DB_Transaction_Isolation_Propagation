package com.sachin.CountryCityOneMany.service;
import com.sachin.CountryCityOneMany.entity.City;
import com.sachin.CountryCityOneMany.entity.Country;
import com.sachin.CountryCityOneMany.repository.CityRepository;
import com.sachin.CountryCityOneMany.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

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

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW,
            rollbackFor = {NullPointerException.class, Exception.class})
    public String addCountryCity(String passfail) throws Exception
    {
        Country ctry = new Country("ENG", "England", "Europe", 6500000, 6);
        countryRepository.save(ctry);

        List<City> cities = new ArrayList<City>();
        City c1 = new City("6", "ENG", "London");
        City c2 = new City("7", "ENG", "Liverpool");
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
