package com.sachin.CountryCityOneMany.repository;
import com.sachin.CountryCityOneMany.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>
{
    @Query(value = "select city from citycountry.city ci, citycountry.country co where ci.country=:CID and co.Capital=ci.id", nativeQuery=true)
    Optional<String> findCapital(@Param("CID") String CID);
}
