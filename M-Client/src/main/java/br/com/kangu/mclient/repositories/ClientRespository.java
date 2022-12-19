package br.com.kangu.mclient.repositories;

import br.com.kangu.mclient.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRespository extends JpaRepository<Client, Long> {
}
