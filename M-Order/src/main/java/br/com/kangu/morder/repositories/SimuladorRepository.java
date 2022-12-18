package br.com.kangu.morder.repositories;

import br.com.kangu.morder.entities.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimuladorRepository extends JpaRepository<Simulation, Long> {
}
