package com.cityList.repository;

import com.cityList.entity.City;
import com.cityList.entity.CityProjection;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    String search_by_term = """
        SELECT * from city WHERE name LIKE CONCAT('%',:term,'%')
        """;

    Page<CityProjection> findCityBy(Pageable pageable);

    @Query(value = search_by_term, nativeQuery = true)
    List<City> findCityByTerm(String term);


//    @Query(value = "SELECT * FROM City c WHERE c.name LIKE CONCAT('%',:term,'%')")
//    List<City> findAllCityByTerm(String term);


    List<CityProjection> findAllByNameContaining(String term);
}
