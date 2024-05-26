package br.com.dio.desafio.dominio;

import lombok.Data;

@Data
public class Curso extends Conteudo {

    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    @Override
    public String toString(){
        return "[" + this.getTitulo() + ", " +
                this.getCargaHoraria() + " horas, " +
                this.getDescricao() + "]";
    }
}
