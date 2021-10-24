package br.com.marconemm.services;

import br.com.marconemm.exceptions.StateNotFoundException;
import br.com.marconemm.models.State;
import br.com.marconemm.repositories.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatesService {

    private ServiceRepo serviceRepo;

    @Autowired
    public StatesService(final ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    public List<State> getAll() {
        return serviceRepo.findAll();
    }

    public Page<State> getAllByPage(Pageable page) {
        return serviceRepo.findAll(page);
    }

    public Optional<State> getByCode(String uf) throws StateNotFoundException {
        final Optional<State> result = serviceRepo.getByCode(uf.toUpperCase());

        if (result.isEmpty()){
            throw new StateNotFoundException(uf);
        }

        return  result;
    }
}
