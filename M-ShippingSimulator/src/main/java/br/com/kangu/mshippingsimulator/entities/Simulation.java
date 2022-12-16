package br.com.kangu.mshippingsimulator.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public Simulation(Double vlrFrete, Integer prazoEnt, String dtPrevEnt,
                      String transp_nome, String descricao, Long idSimulacao) throws ParseException {

        this.vlrFrete    = vlrFrete;
        this.prazoEnt    = prazoEnt;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dtPrevEnt   = formatter.parse(dtPrevEnt);
        this.transp_nome = transp_nome;
        this.descricao   = descricao;
        this.idSimulacao = idSimulacao;

    }

}
