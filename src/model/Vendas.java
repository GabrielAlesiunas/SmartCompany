package model;
import java.util.Date;

public class Vendas {
    private int id;               // Identificador da venda
    private Date dataVenda;      // Data da venda
    private double valorTotal;    // Valor total da venda
    private int idCliente;        // Identificador do cliente

    // Construtor
    public Vendas(int id, Date dataVenda, double valorTotal, int idCliente) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.idCliente = idCliente;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", dataVenda=" + dataVenda +
                ", valorTotal=" + valorTotal +
                ", idCliente=" + idCliente +
                '}';
    }
}
