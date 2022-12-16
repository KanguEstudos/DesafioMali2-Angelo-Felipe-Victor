package br.com.kangu.morder.repositories;

import br.com.kangu.morder.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
