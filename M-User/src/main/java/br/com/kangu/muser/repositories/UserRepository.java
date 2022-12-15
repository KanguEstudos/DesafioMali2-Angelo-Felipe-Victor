package br.com.kangu.muser.repositories;

import br.com.kangu.muser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
