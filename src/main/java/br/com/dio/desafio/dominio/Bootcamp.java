package br.com.dio.desafio.dominio;

import lombok.Data;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);

    private Set<Dev> devsInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();
}
