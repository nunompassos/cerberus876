package br.com.letscode.Classes;

public enum OpcoesMenu {
    INICIO(0, "Trocar de usuário"),
    ABRIR(1, "Abrir Conta"),
    SACAR(2, "Efetuar Saque"),
    DEPOSITAR(3, "Depositar"),
    TRANSFERIR(4, "Transferir"),
    INVESTIR(5, "Investir"),
    SALDO(6, "Ver Saldo"),
    PASSARUMMES(7, "Passar um mês para ver os rendimentos."),
    TODASASCONTAS(8, "Imprimir todas as contas."),
    x(7, "Sem Definição");

    final int option;
    final String titulo;

    OpcoesMenu(int option, String titulo) {
        this.option = option;
        this.titulo = titulo;
    }

}