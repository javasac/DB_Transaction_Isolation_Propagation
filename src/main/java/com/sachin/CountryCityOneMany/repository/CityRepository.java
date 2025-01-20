package com.sachin.CountryCityOneMany.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sachin.CountryCityOneMany.entity.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>
{
}
