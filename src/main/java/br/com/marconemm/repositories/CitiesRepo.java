package br.com.marconemm.repositories;

import br.com.marconemm.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepo extends JpaRepository<City, Integer> {
}
