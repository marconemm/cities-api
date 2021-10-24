package br.com.marconemm.controllers;

import br.com.marconemm.models.Country;
import br.com.marconemm.services.CountiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/V1/countries")
public class CountiesController {

    private CountiesService countryService;

    @Autowired
    public CountiesController(final CountiesService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAll(){
        return countryService.getAll();
    }

    @GetMapping("/pageable")
    public Page<Country> getAllByPage(Pageable page) {
        return countryService.getAllByPage(page);
    }
}
