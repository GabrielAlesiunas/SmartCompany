package model;

import java.time.LocalDate;

public class AlertaEstoque {
    private int id;
    private int idProduto;
    private LocalDate dataAlerta;
    private String mensagem;

    public AlertaEstoque() {
    }

    public AlertaEstoque(int id, int idProduto, LocalDate dataAlerta, String mensagem) {
        this.id = id;
        this.idProduto = idProduto;
        this.dataAlerta = dataAlerta;
        this.mensagem = mensagem;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public LocalDate getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(LocalDate dataAlerta) {
        this.dataAlerta = dataAlerta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    // Método toString para facilitar o debug
    @Override
    public String toString() {
        return "AlertaEstoque [id=" + id + ", idProduto=" + idProduto + ", dataAlerta=" + dataAlerta + ", mensagem=" + mensagem + "]";
    }
}
