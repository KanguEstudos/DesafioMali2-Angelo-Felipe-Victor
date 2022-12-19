package br.com.kangu.morder.repositories;

import br.com.kangu.morder.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
