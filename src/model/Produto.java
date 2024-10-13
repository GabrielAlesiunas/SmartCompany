package model;

import java.util.Date;

public class Produto {
    private String nome;
    private String categoria;
    private double preco;
    private int quantidadeEstoque;
    private int limiteEstoque;
    private Date dataAdicao;
    private int idFornecedor;

    public Produto(String nome, String categoria, double preco, int quantidadeEstoque, int limiteEstoque, Date dataAdicao, int idFornecedor) {
        if (preco < 0) throw new IllegalArgumentException("Preço não pode ser negativo");
        if (quantidadeEstoque < 0) throw new IllegalArgumentException("Quantidade em estoque não pode ser negativa");
        if (limiteEstoque < 0) throw new IllegalArgumentException("Limite de estoque não pode ser negativo");
        
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.limiteEstoque = limiteEstoque;
        this.dataAdicao = dataAdicao;
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public int getLimiteEstoque() {
        return limiteEstoque;
    }

    public Date getDataAdicao() {
        return dataAdicao;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setQuantidadeEstoque(int quantidade) {
        if (quantidade < 0) throw new IllegalArgumentException("Quantidade em estoque não pode ser negativa");
        this.quantidadeEstoque = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", preco=" + preco +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", limiteEstoque=" + limiteEstoque +
                ", dataAdicao=" + dataAdicao +
                ", idFornecedor=" + idFornecedor +
                '}';
    }
}
