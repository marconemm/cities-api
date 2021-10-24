package br.com.marconemm.services;

import br.com.marconemm.models.Country;
import br.com.marconemm.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private CountryRepo countryRepo;

    @Autowired
    public CountryService(final CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public Page<Country> getAll(Pageable page) {
        return countryRepo.findAll(page);
    }
}
