package br.com.kangu.mclient.repositories;


import br.com.kangu.mclient.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
