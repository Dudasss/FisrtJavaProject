package com.desafioBanco;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(in);
        int opc;
        String nome = null;
        Conta cc = null;
        Conta poupanca = null;

        do {
            System.out.println("Digite: 0 para sair\n1 cadastrar uma Conta Corrente");
            System.out.println("2 para cadastrar uma Conta Poupança");
            System.out.println("3 para imprimir Conta Corrente");
            System.out.println("4 para imprimir Conta Poupança");
            System.out.println("5 para realizar deposito");
            System.out.println("6 para realizar saque");
            System.out.println("7 para realizar transferencia");
            opc = ler.nextInt();

            switch (opc) {
                case 0:
                    System.out.println("Saindo.");
                    break;
                case 1:
                    System.out.println("==== CADASTRAR CONTA CORRENTE ====");
                    cc = new ContaCorrente(cadastrarCliente(nome));
                    System.out.println("Conta criada com sucesso.");
                    cc.imprimirExtrato();
                    break;
                case 2:
                    System.out.println("==== CADASTRAR CONTA POUPANÇA ====");
                    poupanca = new ContaPoupança(cadastrarCliente(nome));
                    System.out.println("Conta criada com sucesso.");
                    poupanca.imprimirExtrato();
                    break;
                case 3:
                    if(cc != null)
                        cc.imprimirExtrato();
                    else{
                        System.out.println("Nenhuma conta cadastrada.");
                    }
                    break;
                case 4:
                    if(poupanca != null)
                        poupanca.imprimirExtrato();
                    else{
                        System.out.println("Nenhuma conta cadastrada.3" +
                                "");
                    }
                    break;
                case 5:
                    System.out.println("==== DEPOSITO  ====");
                    System.out.println("Digite 1 - Conta Corrente\n2 - Conta Poupança");
                    int deposito = ler.nextInt();
                    double valorDeposito;

                    if(deposito == 1 && cc != null) {
                        System.out.println("==== DEPOSITO CONTA CORRENTE====");
                        System.out.println("Qual valor deseja depositar?");
                        valorDeposito = ler.nextDouble();
                        cc.depositar(valorDeposito);
                        cc.imprimirExtrato();
                    }else if(deposito == 2 && poupanca != null) {
                        System.out.println("==== DEPOSITO CONTA POUPANÇA====");
                        System.out.println("Qual valor deseja depositar?");
                        valorDeposito = ler.nextDouble();
                        poupanca.depositar(valorDeposito);
                        poupanca.imprimirExtrato();
                    }else{
                        System.out.println("Erro.");
                    }
                    break;
                case 6:
                    System.out.println("==== SAQUE  ====");
                    System.out.println("Digite 1 - Conta Corrente\n2 - Conta Poupança");
                    int saque = ler.nextInt();
                    double valorSaque;

                    if(saque == 1 && cc != null) {
                        System.out.println("==== SAQUE CONTA CORRENTE ====");
                        System.out.println("Qual valor deseja sacar?");
                        valorSaque = ler.nextDouble();
                        cc.sacar(valorSaque);
                        cc.imprimirExtrato();
                    }else if(saque == 2 && poupanca != null) {
                        System.out.println("==== SAQUE CONTA POUPANÇA ====");
                        System.out.println("Qual valor deseja sacar?");
                        valorSaque = ler.nextDouble();
                        poupanca.sacar(valorSaque);
                        poupanca.imprimirExtrato();
                    }else{
                        System.out.println("Erro.");
                    }
                    break;
                case 7:
                    System.out.println("==== TRANSFERENCIA ====");
                    System.out.println("Qual o tipo de conta deseja transferir?");
                    System.out.println("Digite 1 - Conta Corrente\n2 - Conta Poupança");
                    int escolha = ler.nextInt();

                    if(escolha == 1){
                        System.out.println("==== TRANSFERENCIA DA CONTA CORRENTE ====");
                        System.out.println("Qual valor deseja transferir?");
                        double valorTransf = ler.nextDouble();
                        if(poupanca != null)
                            cc.transferir(valorTransf, poupanca);
                        else{
                            System.out.println("Não foi possível realizar a operação.");
                            cc.imprimirExtrato();}
                    }else if(escolha == 2){
                        System.out.println("==== TRANSFERENCIA DA CONTA POUPANÇA ====");
                        System.out.println("Qual valor deseja transferir?");
                        double valorTransf = ler.nextDouble();
                        if(cc != null)
                            poupanca.transferir(valorTransf, cc);
                        else{
                            System.out.println("Não foi possível realizar a operação.");
                            poupanca.imprimirExtrato();}
                    }else{
                        System.out.println("Escolha inválida.");
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opc);
            }
        }while(opc!=0);
    }
    static Cliente cadastrarCliente(String name){
        Scanner ler = new Scanner(in);
        Cliente client;
        client = new Cliente();
        System.out.println("==== CADASTRAR CLIENTE ==== \nDigite o nome do cliente:");
        name = ler.nextLine();
        client.setNome(name);
        return client;
    }
}
