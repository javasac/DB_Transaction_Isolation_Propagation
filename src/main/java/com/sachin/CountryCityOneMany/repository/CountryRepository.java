package com.sachin.CountryCityOneMany.repository;
import com.sachin.CountryCityOneMany.entity.Country;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>
{
    @Query(value = "select ci.name from world.city ci, world.country co where ci.country=:CID and co.Capital=ci.id", nativeQuery=true)
    Optional<String> findCapital(@Param("CID") String CID);

    // solves the N+1 problem. All 4 countries and their cities are fetched in 1 Query.
    //@EntityGraph(attributePaths = {"city"})
    @Query("SELECT c from Country c JOIN FETCH c.city")
    List<Country> findAll();
}
