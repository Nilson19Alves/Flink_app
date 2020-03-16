package com.nilsonalves.flink_app.fragments.card_lista;

public class Lista_Modelo {
    private String nomeMercado;
    private String nomeProduto;
    private Integer valorProduto;
    private Integer qtdCarrinho;
    private Integer qtdFavorito;

    public String getNomeMercado() {
        return nomeMercado;
    }

    public void setNomeMercado(String nomeMercado) {
        this.nomeMercado = nomeMercado;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Integer valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Integer getQtdCarrinho() {
        return qtdCarrinho;
    }

    public void setQtdCarrinho(Integer qtdCarrinho) {
        this.qtdCarrinho = qtdCarrinho;
    }

    public Integer getQtdFavorito() {
        return qtdFavorito;
    }

    public void setQtdFavorito(Integer qtdFavorito) {
        this.qtdFavorito = qtdFavorito;
    }

}