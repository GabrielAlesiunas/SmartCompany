package model;

import dao.CaixaDAO;
import java.util.ArrayList;
import java.util.List;

public class Caixa {
    private double saldo;
    private String dataAbertura;
    private String dataFechamento;
    private List<String> registros;

    public Caixa(String dataAbertura) {
        this.dataAbertura = dataAbertura;
        this.saldo = 0.0;
        this.registros = new ArrayList<>();
    }

    public void registrarVenda(double valor) {
        saldo += valor;
        registros.add("Venda: R$" + valor);
    }

    public void registrarPagamento(double valor) {
        saldo -= valor;
        registros.add("Pagamento: R$" + valor);
    }

    public void fecharCaixa(String dataFechamento) {
        this.dataFechamento = dataFechamento;
        CaixaDAO caixaDAO = new CaixaDAO();
        caixaDAO.salvarCaixa(this);
    }

    public double getSaldo() {
        return saldo;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public List<String> getRegistros() {
        return registros;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
