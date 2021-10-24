package br.com.marconemm.repositories;

import br.com.marconemm.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ServiceRepo extends JpaRepository<State, Integer> {
    @Query(value = "SELECT * FROM states WHERE state = ?1", nativeQuery = true)
    Optional<State> getByCode(String uf);
}
