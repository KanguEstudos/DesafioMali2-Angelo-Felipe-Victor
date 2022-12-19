package br.com.kangu.mtag.repositories;

import br.com.kangu.mtag.entity.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationRepository extends JpaRepository<Simulation, Long> {
}
