package br.com.marconemm.repositories;

import br.com.marconemm.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepo extends JpaRepository<State, Integer> {
    @Query(value = "SELECT * FROM states WHERE state = ?1", nativeQuery = true)
    State getByCode(String uf);
}
