package br.com.marconemm.controllers;

import br.com.marconemm.exceptions.StateNotFoundException;
import br.com.marconemm.models.City;
import br.com.marconemm.models.State;
import br.com.marconemm.services.CitiesService;
import br.com.marconemm.services.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/V1/cities")
public class CitiesController {

    private CitiesService citiesService;

    @Autowired
    public CitiesController(final CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/pageable")
    public Page<City> getAllByPage(Pageable page) {
        return citiesService.getAllByPage(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getByCode(@PathVariable Integer id) throws StateNotFoundException {
        if (id < 1 || id > 5609) {
            final City invalidCity = new City();
            invalidCity.setName("Invalid ID informed.");

            return ResponseEntity.badRequest().body(invalidCity);
        }

        final Optional<City> result = citiesService.getByID(id);

        return ResponseEntity.ok().body(result.get());
    }
}
