package br.com.kangu.morder.controller;

import br.com.kangu.morder.entities.Order;
import br.com.kangu.morder.repositories.OrderRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private OrderRepository orderRepository;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    public Order paymentOrder(@RequestBody Order order) {

        Order order_to_update = orderRepository.findById(order.getId()).get();
        order_to_update.setPaymentStatus(true);
        return orderRepository.save(order_to_update);

    }


}
