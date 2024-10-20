package model;

public class Estoque {
    private int id;           // ID do item no estoque
    private int idVenda;      // ID da venda relacionada
    private int idProduto;    // ID do produto
    private int quantidade;    // Quantidade do produto em estoque
    private double precoUnitario; // Preço unitário do produto

    // Getter e Setter para o ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter e Setter para o ID da Venda
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    // Getter e Setter para o ID do Produto
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    // Getter e Setter para a Quantidade
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Getter e Setter para o Preço Unitário
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
