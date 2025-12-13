package com.sachin.CountryCityOneMany.controller;
import com.sachin.CountryCityOneMany.DTO.CapitalDTO;
import com.sachin.CountryCityOneMany.entity.City;
import com.sachin.CountryCityOneMany.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController
{
    @Autowired
    private CityService cityService;

    @GetMapping("/capitals")
    public List<CapitalDTO> findCapitalsById()
    {
        return cityService.findCapitalsById();
    }

    @GetMapping("/all")
    public List<City> findAllCities()
    {
        return cityService.findAllCities();
    }

    @GetMapping("/{id}")
    public Optional<City> findCity(@PathVariable int id)
    {
        return cityService.getCity(id);
    }

    @GetMapping("/addBoth/{passfail}")
    public String status(@PathVariable("passfail") String passfail)
    {
        System.out.println("Pass Fail param is " + passfail);
        String status = "";

        try
        {
            status = cityService.addCountryCity(passfail);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return status;
        }
    }
}
