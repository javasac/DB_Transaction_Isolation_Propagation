package com.sachin.CountryCityOneMany.repository;
import com.sachin.CountryCityOneMany.DTO.CapitalDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sachin.CountryCityOneMany.entity.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>
{
    @Query(value = "select ci.name Capital, co.name Country, co.continent Continent\n" +
            "from citycountry.country co, citycountry.city ci \n" +
            "where co.code = ci.country and co.capital = ci.id", nativeQuery=true)
    List<CapitalDTO> findCapitalsById(Pageable page);
}
