package br.com.dio.desafio.dominio;

import lombok.Data;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Data
public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    private LocalDate dataFinal;

    public void inscreverBootCamp (Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        this.dataFinal = bootcamp.getDataFinal();
        bootcamp.getDevsInscritos().add(this);
    }

    public void sairBootcamp(Bootcamp bootcamp){
        bootcamp.getConteudos().stream().forEach(conteudo -> {
            this.conteudosInscritos.remove(conteudo);
        });
    }

    public void progredir () {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(LocalDate.now().isAfter(this.dataFinal)){
            System.err.println("Data para realização do bootcamp encerrada!");
            return;
        }
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não esta matriculado em nenhum conteudo!");
        }
    }

    public double calcularTotalXp () {
        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }
}
