package com.example.atividade3dispositivosmoveis_app.Model;

public abstract class Midia {
    protected String titulo;
    protected int ano;

    public Midia(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getAno() {
        return this.ano;
    }

    public abstract String reproduzir();
    public abstract  String exibirDetalhes();
}
