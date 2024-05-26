package br.com.dio.desafio.dominio;

import lombok.Data;

@Data
public abstract class Conteudo {

    public static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;


    public abstract double calcularXp();
}
