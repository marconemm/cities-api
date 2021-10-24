package br.com.marconemm.controllers;

import br.com.marconemm.models.State;
import br.com.marconemm.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/V1/states")
public class StatesController {

    private StateService stateService;

    @Autowired
    public StatesController(final StateService countryService) {
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
    public State getByCode(@PathVariable String uf){
        if (uf != null){
            return stateService.getByCode(uf);
        }
        // TODO treat the 404 possibilities
        return null;
    }
}
