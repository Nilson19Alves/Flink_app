package com.nilsonalves.flink_app.fragments.card_lista;

public class Card_Lista_Modelo {
    private String descricaoProduto,qtdAddCarrinho,qtdAddFavorito;
    private double valorproduto;

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getQtdAddCarrinho() {
        return qtdAddCarrinho;
    }

    public void setQtdAddCarrinho(String qtdAddCarrinho) {
        this.qtdAddCarrinho = qtdAddCarrinho;
    }

    public String getQtdAddFavorito() {
        return qtdAddFavorito;
    }

    public void setQtdAddFavorito(String qtdAddFavorito) {
        this.qtdAddFavorito = qtdAddFavorito;
    }

    public double getValorproduto() {
        return valorproduto;
    }

    public void setValorproduto(double valorproduto) {
        this.valorproduto = valorproduto;
    }
}