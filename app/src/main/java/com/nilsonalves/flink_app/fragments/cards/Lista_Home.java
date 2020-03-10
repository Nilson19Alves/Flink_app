package com.nilsonalves.flink_app.fragments.cards;

import android.widget.ImageView;

public class Lista_Home {
    private String titulo;
    private String status;
    private String classifica;
    private double distancia;
    private String endereco;
    private String URL_logo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String descricao) {
        this.status = descricao;
    }

    public String getClassifica() {
        return classifica;
    }

    public void setClassifica(String classifica) {
        this.classifica = classifica;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getURL_logo() {
        return URL_logo;
    }

    public void setURL_logo(String URL_logo) {
        this.URL_logo = URL_logo;
    }
}