package br.com.kangu.morder.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User Seller;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User Buyer;

    @OneToOne
    @JoinColumn(name = "simulation_id")
    private Simulation simulation;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(columnDefinition = "boolean default false")
    private Boolean paymentStatus;

    private Double totalAmount;

    private String CEPDestin;
    private String CEPOrigin;

    private String Status;

}
