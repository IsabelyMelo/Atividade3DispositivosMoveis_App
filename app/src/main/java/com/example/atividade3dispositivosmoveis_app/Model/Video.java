package com.example.atividade3dispositivosmoveis_app.Model;

public class Video extends Midia{
    private String diretor;
    private int duracao;

    public Video(String titulo, int ano, String diretor, int duracao) {
        super(titulo, ano);
        this.diretor = diretor;
        this.duracao = duracao;
    }

    @Override
    public String reproduzir() {
        return "Reproduzindo vídeo: " + titulo + " dirigido por " + diretor;
    }

    @Override
    public String exibirDetalhes() {
        return "Tipo: Vídeo\n"
                + "Título: " + titulo + "\n"
                + "Ano: " + ano + "\n"
                + "Diretor: " + diretor + "\n"
                + "Duração: " + duracao + " minutos";
    }
}
