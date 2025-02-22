package br.ufpb.dcx.diogo.sistemamercado;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {
    private String codigoProduto;
    private String nomeProduto;
    private int quantidade;
    private double preco;


    public Produto(String codigoProduto, String nomeProduto, int quantidade, double preco) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters e Setters
    public String getCodigoProduto() {
        return codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto com " +
                "nome:'" + nomeProduto + '\'' +
                ", quantidade: " + quantidade +
                ", preco: R$" + preco +
                '.';
    }
}