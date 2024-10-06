package model;

public class Produto {
    private String nome;
    private double precoCompra;
    private double precoVenda;
    private int quantidade;

    public Produto(String nome, double precoCompra, double precoVenda, int quantidade) {
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
