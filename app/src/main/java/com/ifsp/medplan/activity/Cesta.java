package com.ifsp.medplan.activity;

public class Cesta {
    private String nome_med;
    private String quantidade_estoque;

    public Cesta() {
    }

    public Cesta(String nome_med, String quantidade_estoque) {
        this.nome_med = nome_med;
        this.quantidade_estoque = quantidade_estoque;
        //this.tipo_med = tipo_med;
    }

    public String getNome_med() {
        return nome_med;
    }

    public String getQuantidade_med() {
        return quantidade_estoque;
    }

   /* public int getTipo_med() {
        return tipo_med;
    }*/

    public void setNome_med(String nome_med) {
        this.nome_med = nome_med;
    }

    public void setDosagem_med(String quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

}
