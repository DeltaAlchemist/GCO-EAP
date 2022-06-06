package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

@Entity
@Table(name = "T_GCO_CONDOMINIO")
@SequenceGenerator(name = "condominio", sequenceName = "SQ_TB_CONDOMINIO", allocationSize = 1)
public class Condominio implements Serializable {

    private static final long serialVersionUID = 1L;

    public Condominio() {
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Condominio(String cnpj, String razaoSocial, String fantasia, LocalDate dataFundacao) {
        this();
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.fantasia = fantasia;
        this.dataFundacao = dataFundacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "condominio")
    private Long id;

    @Column(name = "nr_cnpj", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "ds_razao_social", length = 50, nullable = false, unique = true)
    private String razaoSocial;

    @Column(name = "nm_fantasia", length = 80, nullable = false, unique = true)
    private String fantasia;

    @Column(name = "dt_fundacao")
    private LocalDate dataFundacao;

    @OneToOne(mappedBy = "condominio", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Portaria portaria;

    @Column(name = "st_ativo")
    private Boolean ativo;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
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
        return "\nCNPJ: " + this.getCnpj()
                + "\nNome: " + this.getRazaoSocial()
                + "\nCPF: " + this.getFantasia()
                + "\nNascimento: " + this.getDataFundacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}