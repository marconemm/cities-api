package br.com.marconemm.services;

import br.com.marconemm.models.Country;
import br.com.marconemm.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private CountryRepo countryRepo;

    @Autowired
    public CountryService(final CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public String itsOk() {
        return "Osadfasdfasdfs!";
    }

    public List<Country> getAll(){
        return countryRepo.findAll();
    }
}
