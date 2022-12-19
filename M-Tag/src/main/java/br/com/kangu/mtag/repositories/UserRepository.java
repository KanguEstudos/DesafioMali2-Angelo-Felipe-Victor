package br.com.kangu.mtag.repositories;

import br.com.kangu.mtag.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
