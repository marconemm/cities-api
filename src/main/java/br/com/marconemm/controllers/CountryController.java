package br.com.marconemm.controllers;

import br.com.marconemm.models.Country;
import br.com.marconemm.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/V1/countries")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(final CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public Page<Country> getAll(Pageable page) {
        return countryService.getAll(page);
    }
}
