package br.com.kangu.mtag.repositories;

import br.com.kangu.mtag.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}