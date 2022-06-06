package br.com.fiap.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_GCO_PORTARIA")
@SequenceGenerator(name = "portaria", sequenceName = "SQ_T_GCO_PORTARIA", allocationSize = 1)
public class Portaria implements Serializable {

    private static final long serialVersionUID = -4342056606534756998L;

    public Portaria() {
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Portaria(Integer numero, String nome, LocalDate dataInicio, LocalDate dataTermino, Condominio condominio) {
        this();
        this.numero = numero;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.condominio = condominio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "portaria")
    private Long id;

    @Column(name = "nr_portaria", nullable = false)
    private Integer numero;

    @Column(name = "nm_portaria", nullable = false)
    private String nome;

    @Column(name = "dt_inicio")
    private LocalDate dataInicio;

    @Column(name = "dt_termino")
    private LocalDate dataTermino;

    @ManyToOne
    @JoinColumn(name = "condominio_id")
    private Condominio condominio;

    @Column(name = "st_status")
    private Boolean ativo;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Condominio getCondominio() {
        return condominio;
    }

    /* Getters and Setters */

    public Long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Portaria{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", condominio=" + condominio +
                '}';
    }
}
