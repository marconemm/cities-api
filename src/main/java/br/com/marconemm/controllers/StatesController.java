package br.com.marconemm.controllers;

import br.com.marconemm.exceptions.StateNotFoundException;
import br.com.marconemm.models.State;
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
@RequestMapping("/V1/states")
public class StatesController {

    private StatesService stateService;

    @Autowired
    public StatesController(final StatesService countryService) {
        this.stateService = countryService;
    }

    @GetMapping
    public List<State> getAll() {
        return stateService.getAll();
    }

    @GetMapping("/pageable")
    public Page<State> getAllByPage(Pageable page) {
        return stateService.getAllByPage(page);
    }

    @GetMapping("/{uf}")
    public ResponseEntity<State> getByCode(@PathVariable String uf) throws StateNotFoundException {
        if (uf.length() > 2) {
            final State invalidState = new State();
            invalidState.setState("Invalid UF code.");

            return ResponseEntity.badRequest().body(invalidState);
        }

        final Optional<State> result = stateService.getByCode(uf);

        return ResponseEntity.ok().body(result.get());
    }
}
