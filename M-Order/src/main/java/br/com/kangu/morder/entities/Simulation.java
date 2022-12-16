package br.com.kangu.morder.entities;

import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_simulation")
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double vlrFrete;
    private Integer prazoEnt;
    private Date dtPrevEnt;
    private String transp_nome;
    private String descricao;
    private Long idSimulacao;

}
