package br.com.marconemm.services;

import br.com.marconemm.models.Country;
import br.com.marconemm.repositories.CountriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountiesService {

    private CountriesRepo countryRepo;

    @Autowired
    public CountiesService(final CountriesRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public List<Country> getAll() {
        return countryRepo.findAll();
    }

    public Page<Country> getAllByPage(Pageable page) {
        return  countryRepo.findAll(page);
    }
}
