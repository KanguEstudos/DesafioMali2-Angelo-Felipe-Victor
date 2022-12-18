package br.com.kangu.morder.repositories;

import br.com.kangu.morder.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
