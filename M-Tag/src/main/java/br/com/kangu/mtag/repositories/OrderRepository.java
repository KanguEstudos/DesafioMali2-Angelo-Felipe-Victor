package br.com.kangu.mtag.repositories;

import br.com.kangu.mtag.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
