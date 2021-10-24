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
}
