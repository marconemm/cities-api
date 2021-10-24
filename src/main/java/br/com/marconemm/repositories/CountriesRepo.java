package br.com.marconemm.repositories;

import br.com.marconemm.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepo extends JpaRepository<Country, Integer> {
}
