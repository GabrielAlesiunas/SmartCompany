package model;

public class Caixa {
    private double saldo;
    
    public Caixa(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarEntrada(double valor) {
        saldo += valor;
    }

    public void adicionarSaida(double valor) {
        saldo -= valor;
    }
}

