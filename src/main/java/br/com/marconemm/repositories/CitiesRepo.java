package br.com.marconemm.repositories;

import br.com.marconemm.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepo extends JpaRepository<City, Integer> {

    @Query(value = "select earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance;", nativeQuery = true)
    Double getDistanceBetween(final Double city1Lat, final Double city1Lon, final Double city2Lat, final Double city2Lon);
}
