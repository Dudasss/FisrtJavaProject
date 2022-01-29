package com.desafioBanco;

public abstract class Conta implements iConta {

    private static final int AG_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AG_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public int sacar(double valor){
        saldo -= valor;
        return 1;
    }
    @Override
    public int depositar(double valor){
        saldo += valor;
        return 1;
    }
    @Override
    public int transferir(double valor, Conta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
        return 1;
    }


    public int getAgencia() {
        return agencia;
    }

    public int getConta(int numConta) {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns(){
        System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.conta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
