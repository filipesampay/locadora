package br.ueg.progweb1.locadora.repository;

import br.ueg.progweb1.locadora.model.Locadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocadoraRepository extends JpaRepository<Locadora, Long> {
}
