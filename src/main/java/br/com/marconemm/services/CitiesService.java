package br.com.marconemm.services;

import br.com.marconemm.models.City;
import br.com.marconemm.repositories.CitiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CitiesService {

    private CitiesRepo citiesRepo;

    @Autowired
    public CitiesService(final CitiesRepo citiesRepo) {
        this.citiesRepo = citiesRepo;
    }

    public Page<City> getAllByPage(Pageable page) {
        return citiesRepo.findAll(page);
    }

    public Optional<City> getByID(Integer id) {
        final Optional<City> result = citiesRepo.findById(id);

        return result;
    }

    public Double getDistanceBetween(Integer cityId1, Integer cityId2) {
        
        final Optional<City> city1 = getByID(cityId1);

        if (city1.isPresent()){
            final Double city1Lat = city1.get().getLatitude();
            final Double city1Lon = city1.get().getLongitude();
            final Optional<City> city2 = getByID(cityId2);

            if(city2.isPresent()){
                final Double city2Lat = city2.get().getLatitude();
                final Double city2Lon = city2.get().getLongitude();
                return citiesRepo.getDistanceBetween(city1Lat, city1Lon, city2Lat, city2Lon);

            }
        }

        return null;
    }
}
