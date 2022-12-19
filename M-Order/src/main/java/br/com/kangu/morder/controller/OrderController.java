package br.com.kangu.morder.controller;

import br.com.kangu.morder.entities.Order;
import br.com.kangu.morder.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @PatchMapping(value = "/pay")
    public Order paymentOrder(@RequestBody Order order) {

        Order order_to_update = orderRepository.findById(order.getId()).get();
        order_to_update.setPaymentStatus(true);
        return orderRepository.save(order_to_update);

    }


}
