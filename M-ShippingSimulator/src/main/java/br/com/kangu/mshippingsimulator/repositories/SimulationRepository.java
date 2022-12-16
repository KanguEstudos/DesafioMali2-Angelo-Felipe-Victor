package br.com.kangu.mshippingsimulator.repositories;

import br.com.kangu.mshippingsimulator.entities.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationRepository extends JpaRepository<Simulation, Long> {
}
