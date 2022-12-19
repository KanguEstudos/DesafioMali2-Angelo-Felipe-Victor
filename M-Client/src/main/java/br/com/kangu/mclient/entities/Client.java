package br.com.kangu.mclient.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String document;
    private String email;

    private String type;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String CEP;


}
