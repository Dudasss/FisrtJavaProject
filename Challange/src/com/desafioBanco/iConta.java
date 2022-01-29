package com.desafioBanco;

public interface iConta {
    int sacar(double valor);

    int depositar(double valor);

    int transferir(double valor, Conta contaDestino);

    void imprimirExtrato();

}