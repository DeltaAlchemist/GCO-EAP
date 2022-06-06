package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "T_GCO_MOVIMENTACAO_PORTARIA")
@SequenceGenerator(name = "movimentacao", sequenceName = "SQ_TB_MOVIMENTACAO", allocationSize = 1)
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;

    public Movimentacao() { }

    public Movimentacao(String movimentacao, LocalDateTime dataMovimentacao, Portaria portaria, FuncPortaria funcionario, Visitante visitante) {
        this.movimentacao = movimentacao;
        this.dataMovimentacao = dataMovimentacao;
        this.portaria = portaria;
        this.visitante = visitante;
        this.funcionario = funcionario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimentacao")
    private Long id;

    @Column(name = "tp_movimentacao")
    private String movimentacao;

    @Column(name = "dt_movimentacao")
    private LocalDateTime dataMovimentacao;

    @ManyToOne
    @JoinColumn(name = "portaria_id")
    private Portaria portaria;

    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private Visitante visitante;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private FuncPortaria funcionario;

    public FuncPortaria getFuncionario() {
        return funcionario;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public Portaria getPortaria() {
        return portaria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(String movimentacao) {
        this.movimentacao = movimentacao;
    }

    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

}
