package br.com.marconemm.services;

import br.com.marconemm.models.State;
import br.com.marconemm.repositories.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class StateService {

    private ServiceRepo serviceRepo;

    @Autowired
    public StateService(final ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    public List<State> getAll() {
        return serviceRepo.findAll();
    }

    public Page<State> getAllByPage(Pageable page) {
        return serviceRepo.findAll(page);
    }

    public State getByCode(String uf) {
        return  serviceRepo.getByCode(uf.toUpperCase());
    }
}
