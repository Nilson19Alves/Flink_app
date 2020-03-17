package com.nilsonalves.flink_app.fragments.card_lista;

public class Lista_Modelo {
    private String descricaoProduto;
    private Integer qtdAddCarrinho;
    private Integer qtdAddFavorito;
    private Integer valorproduto;

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Integer getQtdAddCarrinho() {
        return qtdAddCarrinho;
    }

    public void setQtdAddCarrinho(Integer qtdAddCarrinho) {
        this.qtdAddCarrinho = qtdAddCarrinho;
    }

    public Integer getQtdAddFavorito() {
        return qtdAddFavorito;
    }

    public void setQtdAddFavorito(Integer qtdAddFavorito) {
        this.qtdAddFavorito = qtdAddFavorito;
    }

    public Integer getValorproduto() {
        return valorproduto;
    }

    public void setValorproduto(Integer valorproduto) {
        this.valorproduto = valorproduto;
    }
}