package br.com.fiap.jpa.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;


import javax.persistence.*;

@Entity
@Table(name = "T_GCO_FUNC_PORTARIA")
@SequenceGenerator(name = "funcionario", sequenceName = "SQ_T_GCO_FUNCIONARIO", allocationSize = 1)
public class FuncPortaria implements Serializable {

    private static final long serialVersionUID = 1L;


    public FuncPortaria() {
        this.dataCadastro = LocalDateTime.now();

    }

    public FuncPortaria(String funcionario, String cpf, String rg, LocalDate dataNascimento) {
        this();
        this.funcionario = funcionario;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
    private Long id;

    @Column(name = "nm_funcionario", length = 100, nullable = false)
    private String funcionario;

    @Column(name = "dt_nasc")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "funcionario")
    private Set<Movimentacao> movimentacao;

    @Column(name = "nr_cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "nr_rg", length = 8, nullable = false, unique = true)
    private String rg;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String visitante) {
        this.funcionario = visitante;
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

    @Override
    public String toString() {

        return "\nFuncionario: " + this.getFuncionario()
                + "\nData de Nascimento: " + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + "\nCPF: " + this.getCpf()
                + "\nCPF: " + this.getRg();

    }
}