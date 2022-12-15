package br.com.kangu.mproduct.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Double factor;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
