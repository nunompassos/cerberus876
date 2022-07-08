package br.com.letscode.Classes;

public enum OpcoesMenu {
    SAIR(0, "Fechar Programa"),
    ABRIR(1, "Abrir Conta"),
    SACAR(2, "Efetuar Saque"),
    DEPOSITAR(3, "Depositar"),
    TRANSFERIR(4, "Transferir"),
    INVESTIR(5, "Investir"),
    SALDO(6, "Ver Saldo"),
    PASSAR_UM_MES(7, "Passar um mês para ver os rendimentos."),
    TODAS_AS_CONTAS(8, "Imprimir todas as contas."),
    TROCAR_USUARIO(9, "retornar para login");

    final int option;
    final String titulo;

    OpcoesMenu(int option, String titulo) {
        this.option = option;
        this.titulo = titulo;
    }

}