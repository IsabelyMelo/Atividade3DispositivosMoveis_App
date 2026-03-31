package com.example.atividade3dispositivosmoveis_app.Model;

public class Musica extends Midia {
    private String artista;
    private String album;

    public Musica(String titulo, int ano, String artista, String album) {
        super(titulo, ano);
        this.artista = artista;
        this.album = album;
    }

    @Override
    public String reproduzir() {
        return "Tocando música: " + titulo + " de " + artista;
    }

    @Override
    public String exibirDetalhes() {
        return "Tipo: Música\n"
                + "Título: " + titulo + "\n"
                + "Ano: " + ano + "\n"
                + "Artista: " + artista + "\n"
                + "Álbum: " + album;
    }
}
