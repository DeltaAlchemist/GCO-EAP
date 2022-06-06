package br.com.fiap.jpa;

import br.com.fiap.jpa.entity.*;
import br.com.fiap.jpa.service.impl.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {

        CondominioServiceImpl condominioService = CondominioServiceImpl.getInstance();
        PortariaServiceImpl portariaService = PortariaServiceImpl.getInstance();
        VisitanteServiceImpl visitanteService = VisitanteServiceImpl.getInstance();
        MovimentacaoServiceImpl movimentacaoService = MovimentacaoServiceImpl.getInstance();
        FuncPortariaServiceImpl funcionarioService = FuncPortariaServiceImpl.getInstance();


        /* 9.1 – Cadastre um novo Condomínio */
        Condominio condominio1 = new Condominio("856478234", "Vila Prudente", "VL", LocalDate.of(2022, 1, 1) );
        condominioService.inserir(condominio1);

        Condominio condominio2 = new Condominio("542658756", "Brecheret", "BR", LocalDate.of(2021, 1, 1) );
        condominioService.inserir(condominio2);

        /* Cadastre duas Portarias, uma com o nome “Principal” e outra com o
         nome “Serviço”, associando a elas o condomínio criado no item 9.1 */
        Portaria portaria1 = new Portaria(1, "Principal", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), condominio1);
        Portaria portaria2 = new Portaria(2, "Serviço", LocalDate.of(2021, 1, 1), LocalDate.of(2024, 1, 1), condominio2);

        portariaService.inserir(portaria1);
        portariaService.inserir(portaria2);

        Visitante visitante1 = visitanteService.obter(1L);
        Visitante visitante2 = visitanteService.obter(2L);

        FuncPortaria funcionario1 = funcionarioService.obter(1L);
        FuncPortaria funcionario2 = funcionarioService.obter(2L);

        Movimentacao movimentacao1 = new Movimentacao("E", LocalDateTime.of(2022, 6, 1, 15, 00, 0), portaria1, funcionario1, visitante1);
        Movimentacao movimentacao2 = new Movimentacao("E", LocalDateTime.of(2022, 6, 1, 15, 30, 0), portaria1, funcionario1, visitante2);
        Movimentacao movimentacao3 = new Movimentacao("S", LocalDateTime.of(2022, 6, 1, 15, 45, 0), portaria1, funcionario2, visitante1);

        movimentacaoService.inserir(movimentacao1);
        movimentacaoService.inserir(movimentacao2);
        movimentacaoService.inserir(movimentacao3);

        /*
        movimentacaoService.listarTipo("E").forEach(System.out::println);
        movimentacaoService.listarTipo("S").forEach(System.out::println);

        visitanteService.pesquisar("j", null, null).forEach(System.out::println);
        visitanteService.pesquisar("j", "111.111.111-11", null).forEach(System.out::println);
        */


    }
}
