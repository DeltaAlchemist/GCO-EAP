package br.com.fiap.jpa.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;


import javax.persistence.*;

@Entity
@Table(name = "T_GCO_VISITANTE")
@SequenceGenerator(name = "visitante", sequenceName = "SQ_TB_VISITANTE", allocationSize = 1)
public class Visitante implements Serializable {

    private static final long serialVersionUID = 1L;

    public Visitante() {
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Visitante(String visitante, String cpf, String rg, LocalDate dataNascimento) {
        this();
        this.visitante = visitante;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visitante")
    private Long id;

    @Column(name = "nm_visitante", length = 25, nullable = false)
    private String visitante;

    @Column(name = "dt_nasc", length = 50, nullable = false, unique = true)
    private LocalDate dataNascimento;

    @Column(name = "nr_cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "nr_rg", length = 8, nullable = false, unique = true)
    private String rg;

    @OneToMany(mappedBy = "visitante")
    private Set<Movimentacao> movimentacao;

    @Column(name = "st_ativo")
    private Boolean ativo;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    public Set<Movimentacao> getMovimentacao() {
        return movimentacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {

        return "\nVisitante: " + this.getVisitante()
                + "\nData de Nascimento: " + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + "\nCPF: " + this.getCpf()
                + "\nCPF: " + this.getRg();

    }
}