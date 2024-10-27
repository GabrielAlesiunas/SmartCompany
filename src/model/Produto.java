package model;

import java.time.LocalDate;
import java.util.Objects;

public class Produto {
    private String nome;
    private String categoria;
    private double preco;
    private int quantidadeEstoque;
    private int limiteEstoque;
    private LocalDate dataAdicao;
    private int idFornecedor;

    public Produto(String nome, String categoria, double preco, int quantidadeEstoque, int limiteEstoque, LocalDate dataAdicao, int idFornecedor) {
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        if (categoria == null || categoria.isEmpty()) throw new IllegalArgumentException("Categoria não pode ser nula ou vazia");
        if (preco < 0) throw new IllegalArgumentException("Preço não pode ser negativo");
        if (quantidadeEstoque < 0) throw new IllegalArgumentException("Quantidade em estoque não pode ser negativa");
        if (limiteEstoque < 0) throw new IllegalArgumentException("Limite de estoque não pode ser negativo");

        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.limiteEstoque = limiteEstoque;
        this.dataAdicao = (dataAdicao != null) ? dataAdicao : LocalDate.now();
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

    public LocalDate getDataAdicao() {
        return dataAdicao;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setQuantidadeEstoque(int quantidade) {
        if (quantidade < 0) throw new IllegalArgumentException("Quantidade em estoque não pode ser negativa");
        this.quantidadeEstoque = quantidade;
    }

    public void setLimiteEstoque(int limiteEstoque) {
        if (limiteEstoque < 0) throw new IllegalArgumentException("Limite de estoque não pode ser negativo");
        this.limiteEstoque = limiteEstoque;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Double.compare(produto.preco, preco) == 0 &&
                quantidadeEstoque == produto.quantidadeEstoque &&
                limiteEstoque == produto.limiteEstoque &&
                idFornecedor == produto.idFornecedor &&
                nome.equals(produto.nome) &&
                categoria.equals(produto.categoria) &&
                dataAdicao.equals(produto.dataAdicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, categoria, preco, quantidadeEstoque, limiteEstoque, dataAdicao, idFornecedor);
    }
}
