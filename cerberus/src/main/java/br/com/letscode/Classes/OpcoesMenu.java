package br.com.letscode.Classes;


public enum OpcoesMenu {
    TROCARUSUARIO(7,"Trocar de usuário"),
    ABRIR(1, "Abrir Conta"),
    SACAR(2, "Efetuar Saque"),
    DEPOSITAR(3, "Depositar"),
    TRANSFERIR(4,"Transferir"),
    INVESTIR(5, "Investir"),
    SALDO(6, "Ver Saldo"),
    TODASASCONTAS(8, "Imprimir todas as contas.");

    final int option;
    final String titulo;
    
    OpcoesMenu(int option, String titulo) {
        this.option = option;
        this.titulo = titulo;
    }

}