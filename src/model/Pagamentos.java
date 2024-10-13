package model;

import java.util.Date;

public class Pagamentos {
    private int id;
    private int idVenda;
    private String metodoPagamento;
    private Date dataPagamento;
    private double valorPago;

    // Construtor
    public Pagamentos(int idVenda, String metodoPagamento, Date dataPagamento, double valorPago) {
        this.idVenda = idVenda;
        this.metodoPagamento = metodoPagamento;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
