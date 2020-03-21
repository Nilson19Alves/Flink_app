package com.nilsonalves.flink_app.fragments.card_lista;

public class Card_Lista_Modelo {
    private String descricaoProduto;
    private int imagemProduto, qtdAddCarrinho;
    private int qtdAddFavorito;
    private double valorproduto;

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public int getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(int imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public int getQtdAddCarrinho() {
        return qtdAddCarrinho;
    }

    public void setQtdAddCarrinho(int qtdAddCarrinho) {
        this.qtdAddCarrinho = qtdAddCarrinho;
    }

    public int getQtdAddFavorito() {
        return qtdAddFavorito;
    }

    public void setQtdAddFavorito(int qtdAddFavorito) {
        this.qtdAddFavorito = qtdAddFavorito;
    }

    public double getValorproduto() {
        return valorproduto;
    }

    public void setValorproduto(double valorproduto) {
        this.valorproduto = valorproduto;
    }
}