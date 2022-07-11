package br.com.letscode;

import java.util.HashMap;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Aplicacao {

    static int ms = 750;
    static boolean sair = false;
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Conta> contas = new HashMap<Integer, Conta>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println();
        System.out.println("================================");
        System.out.println("        BANCO LET'S CODE        ");
        System.out.println("================================");
        esperar();
        System.out.println(" Olá! Eu sou o Nuno, seu");
        System.out.println(" assistente virtual.");
        mainMenu();
        while (!sair) {
            esperar();
            System.out.println(" Eu posso lhe ajudar com");
            System.out.println(" mais alguma coisa?");
            esperar();
            System.out.println(" (1) Sim");
            System.out.println(" (2) Não");
            System.out.println();
            System.out.print(" » ");
            switch (sc.nextInt()) {
                case 1:
                    mainMenu();
                    break;
                default:
                    sair = true;
            }
        }
        esperar();
        System.out.println(" Obrigado por utilizar");
        System.out.println(" o Banco Let's Code!");
        System.out.println();
    }

    public static void mainMenu() throws InterruptedException {
        esperar();
        System.out.println(" O que você deseja fazer?");
        esperar();
        System.out.println(" (1) Saldo");
        System.out.println(" (2) Sacar");
        System.out.println(" (3) Depositar");
        System.out.println(" (4) Transferir");
        System.out.println(" (5) Investir");
        System.out.println(" (6) Abrir Conta");
        System.out.println(" (7) Listar Contas");
        System.out.println(" (8) Executar Testes");
        System.out.println();
        System.out.print(" » ");
        switch (sc.nextInt()) {
            case 1:
                saldo();
                break;
            case 2:
                sacar();
                break;
            case 3:
                depositar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                investir();
                break;
            case 6:
                abrirConta();
                break;
            case 7:
                listarContas();
                break;
            case 8:
                executarTestes();
                break;
            default:
                sair = true;
        }
    }

    public static void saldo() throws InterruptedException {
        int numeroConta;
        esperar();
        System.out.println(" Está certo! E qual é o");
        System.out.println(" número da conta?");
        System.out.println();
        System.out.print(" » ");
        numeroConta = sc.nextInt();
        Conta conta = contas.get(numeroConta);
        esperar(1);
        if (conta == null) {
            System.out.println(" Hum... Eu não consegui");
            System.out.println(" localizar essa conta.");
            return;
        }
        System.out.println(" O saldo é " + conta.saldo() + ".");
    }

    public static void sacar() throws InterruptedException {
        int numeroConta;
        esperar();
        System.out.println(" Está certo! E qual é o");
        System.out.println(" número da conta?");
        System.out.println();
        System.out.print(" » ");
        numeroConta = sc.nextInt();
        Conta conta = contas.get(numeroConta);
        esperar();
        if (conta == null) {
            System.out.println(" Hum... Eu não consegui");
            System.out.println(" localizar essa conta.");
            return;
        }
        if (conta.getTipoConta() == TipoConta.CI) {
            System.out.println(" Hum... É impossível sacar");
            System.out.println(" de uma conta-investimento");
            return;
        }
        System.out.println(" E qual é o valor que você");
        System.out.println(" gostaria de sacar?");
        System.out.println();
        System.out.print(" » ");
        BigDecimal valor = sc.nextBigDecimal();
        esperar(1);
        if (conta.sacar(valor)) {
            contas.put(conta.getNumeroConta(), conta);
            System.out.println(" Pronto! O saque foi");
            System.out.println(" realizado com sucesso.");
        } else {
            System.out.println(" Hum... Infelizmente você");
            System.out.println(" não tem saldo suficiente.");
        }
    }

    public static void depositar() throws InterruptedException {
        int numeroConta;
        esperar();
        System.out.println(" Está certo! E qual é o");
        System.out.println(" número da conta?");
        System.out.println();
        System.out.print(" » ");
        numeroConta = sc.nextInt();
        Conta conta = contas.get(numeroConta);
        esperar();
        if (conta == null) {
            System.out.println(" Hum... Eu não consegui");
            System.out.println(" localizar essa conta.");
            return;
        }
        if (conta.getTipoConta() == TipoConta.CI) {
            System.out.println(" Hum... É impossível depositar");
            System.out.println(" em uma conta-investimento");
            return;
        }
        System.out.println(" E qual é o valor que você");
        System.out.println(" gostaria de depositar?");
        System.out.println();
        System.out.print(" » ");
        BigDecimal valor = sc.nextBigDecimal();
        esperar(1);
        if (conta.depositar(valor)) {
            contas.put(conta.getNumeroConta(), conta);
            System.out.println(" Pronto! O depósito foi");
            System.out.println(" realizado com sucesso.");
        } else {
            System.out.println(" Hum... Eu não consegui");
            System.out.println(" fazer o seu depósito.");
        }
    }

    public static void transferir() throws InterruptedException {
        int numeroConta;
        esperar();
        System.out.println(" Certo! Qual é o número");
        System.out.println(" da conta de origem?");
        System.out.println();
        System.out.print(" » ");
        numeroConta = sc.nextInt();
        Conta contaOrigem = contas.get(numeroConta);
        esperar();
        if (contaOrigem == null) {
            System.out.println(" Hum... Eu não consegui");
            System.out.println(" localizar essa conta.");
            return;
        }
        if (contaOrigem.getTipoConta() == TipoConta.CI) {
            System.out.println(" Hum... É impossível transferir");
            System.out.println(" de uma conta-investimento");
            return;
        }
        System.out.println(" Certo! Qual é o número");
        System.out.println(" da conta de destino?");
        System.out.println();
        System.out.print(" » ");
        numeroConta = sc.nextInt();
        Conta contaDestino = contas.get(numeroConta);
        esperar();
        if (contaDestino == null) {
            System.out.println(" Hum... Eu não consegui");
            System.out.println(" localizar essa conta.");
            return;
        }
        if (contaDestino.getTipoConta() == TipoConta.CI) {
            System.out.println(" Hum... É impossível transferir");
            System.out.println(" para uma conta-investimento");
            return;
        }
        System.out.println(" E qual é o valor que você");
        System.out.println(" gostaria de transferir?");
        System.out.println();
        System.out.print(" » ");
        BigDecimal valor = sc.nextBigDecimal();
        esperar(1);
        if (contaOrigem.sacar(valor)) {
            if (contaDestino.depositar(valor)) {
                contas.put(contaOrigem.getNumeroConta(), contaOrigem);
                contas.put(contaDestino.getNumeroConta(), contaDestino);
                System.out.println(" Pronto! Transferência");
                System.out.println(" realizada com sucesso.");
            } else {
                System.out.println(" Hum... Eu não consegui");
                System.out.println(" fazer a transferência.");
            }
        } else {
            System.out.println(" Hum... Infelizmente você");
            System.out.println(" não tem saldo suficiente.");
        }
    }

    public static void investir() throws InterruptedException {
        int numeroConta;
        esperar();
        System.out.println(" Certo! Qual é o número");
        System.out.println(" da conta de origem?");
        System.out.println();
        System.out.print(" » ");
        numeroConta = sc.nextInt();
        Conta contaOrigem = contas.get(numeroConta);
        esperar();
        if (contaOrigem == null) {
            System.out.println(" Hum... Eu não consegui");
            System.out.println(" localizar essa conta.");
            return;
        }
        if (contaOrigem.getTipoConta() == TipoConta.CI) {
            System.out.println(" Hum... É impossível investir");
            System.out.println(" de uma conta-investimento");
            return;
        }
        System.out.println(" Certo! Qual é o número");
        System.out.println(" da conta de destino?");
        System.out.println();
        System.out.print(" » ");
        numeroConta = sc.nextInt();
        Conta contaDestino = contas.get(numeroConta);
        esperar();
        if (contaDestino == null) {
            System.out.println(" Hum... Eu não consegui");
            System.out.println(" localizar essa conta.");
            return;
        }
        if (contaDestino.getTipoConta() != TipoConta.CI) {
            System.out.println(" Hum... A conta de destino");
            System.out.println(" precisar ser de investimento.");
            return;
        }
        System.out.println(" E qual é o valor que você");
        System.out.println(" gostaria de investir?");
        System.out.println();
        System.out.print(" » ");
        BigDecimal valor = sc.nextBigDecimal();
        esperar(1);
        if (contaOrigem.investir(valor)) {
            if (contaDestino.depositar(valor)) {
                contas.put(contaOrigem.getNumeroConta(), contaOrigem);
                contas.put(contaDestino.getNumeroConta(), contaDestino);
                System.out.println(" Pronto! Investimento");
                System.out.println(" realizado com sucesso.");
            } else {
                System.out.println(" Hum... Eu não consegui");
                System.out.println(" fazer o investimento.");
            }
        } else {
            System.out.println(" Hum... Infelizmente você");
            System.out.println(" não tem saldo suficiente.");
        }
    }

    public static void abrirConta() throws InterruptedException {
        TipoCliente tipoCliente = null;
        TipoConta tipoConta = null;
        esperar();
        System.out.println(" Certo! Para que tipo de");
        System.out.println(" cliente será a conta?");
        esperar();
        System.out.println(" (1) Pessoa Física");
        System.out.println(" (2) Pessoa Jurídica");
        System.out.println();
        System.out.print(" » ");
        switch (sc.nextInt()) {
            case 1:
                tipoCliente = TipoCliente.PF;
                esperar();
                System.out.println(" Entendi! E qual será");
                System.out.println(" o tipo da conta?");
                esperar();
                System.out.println(" (1) Conta-Corrente");
                System.out.println(" (2) Conta-Poupança");
                System.out.println(" (3) Conta-Investimento");
                System.out.println();
                System.out.print(" » ");
                switch (sc.nextInt()) {
                    case 1:
                        tipoConta = TipoConta.CC;
                        break;
                    case 2:
                        tipoConta = TipoConta.CP;
                        break;
                    case 3:
                        tipoConta = TipoConta.CI;
                        break;
                    default:
                        tipoConta = null;
                }
                break;
            case 2:
                tipoCliente = TipoCliente.PJ;
                esperar();
                System.out.println(" Entendi! E qual será");
                System.out.println(" o tipo da conta?");
                esperar();
                System.out.println(" (1) Conta-Corrente");
                System.out.println(" (2) Conta-Investimento");
                System.out.println();
                System.out.print(" » ");
                switch (sc.nextInt()) {
                    case 1:
                        tipoConta = TipoConta.CC;
                        break;
                    case 2:
                        tipoConta = TipoConta.CI;
                        break;
                    default:
                        tipoConta = null;
                }
                break;
            default:
                tipoCliente = null;
        }
        if ((tipoCliente != null) && (tipoConta != null)) {
            int numeroConta = contas.size() + 1001;
            Conta conta = new Conta(numeroConta, tipoCliente, tipoConta, new BigDecimal("0.00"));
            contas.put(numeroConta, conta);
            esperar(1);
            System.out.println(" Pronto! Sua nova conta");
            System.out.println(" foi aberta com sucessso.");
            esperar();
            System.out.println(" Por favor, anote o número");
            System.out.println(" da sua nova conta: " + numeroConta + ".");
        } else {
            esperar();
            System.out.println(" Hum... Eu não consegui");
            System.out.println(" abrir a nova conta.");
        }
    }

    public static void listarContas() throws InterruptedException {
        esperar(1);
        if (contas.size() == 0) {
            System.out.println(" Hum... Eu não encontrei");
            System.out.println(" nunhuma conta cadastrada.");
        } else {
            System.out.println(" Pronto! Segue a lista");
            System.out.println(" das contas cadastradas.");
            verHashMap();
        }
    }

    public static void executarTestes() throws InterruptedException {
        int aux = ms;
        ms = 0;
        System.out.println();
        System.out.println("================================");
        System.out.println("        EXECUTANDO TESTES       ");
        System.out.println("================================");
        System.out.println();
        System.out.println(" » Instanciando 5 contas...");
        Conta c1001 = new Conta(1001, TipoCliente.PF, TipoConta.CC, new BigDecimal("0.00"));
        Conta c1002 = new Conta(1002, TipoCliente.PF, TipoConta.CP, new BigDecimal("0.00"));
        Conta c1003 = new Conta(1003, TipoCliente.PF, TipoConta.CI, new BigDecimal("0.00"));
        Conta c1004 = new Conta(1004, TipoCliente.PJ, TipoConta.CC, new BigDecimal("0.00"));
        Conta c1005 = new Conta(1005, TipoCliente.PJ, TipoConta.CI, new BigDecimal("0.00"));
        System.out.println();
        System.out.println(" » Persistindo no HashMap...");
        contas.put(c1001.getNumeroConta(), c1001);
        contas.put(c1002.getNumeroConta(), c1002);
        contas.put(c1003.getNumeroConta(), c1003);
        contas.put(c1004.getNumeroConta(), c1004);
        contas.put(c1005.getNumeroConta(), c1005);
        verHashMap();
        System.out.println();
        System.out.println(" » Depositando R$ 1000,00...");
        c1001.depositar(new BigDecimal("1000"));
        c1002.depositar(new BigDecimal("1000"));
        c1003.depositar(new BigDecimal("1000"));
        c1004.depositar(new BigDecimal("1000"));
        c1005.depositar(new BigDecimal("1000"));
        verHashMap();
        System.out.println();
        System.out.println(" » Sacando R$ 100,00...");
        c1001.sacar(new BigDecimal("100"));
        c1002.sacar(new BigDecimal("100"));
        c1003.sacar(new BigDecimal("100"));
        c1004.sacar(new BigDecimal("100"));
        c1005.sacar(new BigDecimal("100"));
        verHashMap();
        System.out.println();
        System.out.println(" » Sacando R$ 950,00...");
        c1001.sacar(new BigDecimal("950"));
        c1002.sacar(new BigDecimal("950"));
        c1003.sacar(new BigDecimal("950"));
        c1004.sacar(new BigDecimal("950"));
        c1005.sacar(new BigDecimal("950"));
        verHashMap();
        System.out.println();
        System.out.println(" » Transferindo R$ 100,00...");
        System.out.println(" Conta 1001 => 1004");
        if (c1001.sacar(new BigDecimal("100"))) {
            c1004.depositar(new BigDecimal("100"));
        }
        verHashMap();
        System.out.println();
        System.out.println(" » Transferindo R$ 100,00...");
        System.out.println(" Conta 1004 => 1001");
        if (c1004.sacar(new BigDecimal("100"))) {
            c1001.depositar(new BigDecimal("100"));
        }
        verHashMap();
        System.out.println();
        System.out.println(" » Investindo R$ 100,00...");
        System.out.println(" Conta 1001 => 1002");
        if (c1001.investir(new BigDecimal("100"))) {
            c1002.depositar(new BigDecimal("100"));
        }
        verHashMap();
        System.out.println();
        System.out.println(" » Investindo R$ 100,00...");
        System.out.println(" Conta 1001 => 1003");
        if (c1001.investir(new BigDecimal("100"))) {
            c1003.depositar(new BigDecimal("100"));
        }
        verHashMap();
        System.out.println();
        System.out.println(" » Investindo R$ 100,00...");
        System.out.println(" Conta 1004 => 1005");
        if (c1004.investir(new BigDecimal("100"))) {
            c1005.depositar(new BigDecimal("100"));
        }
        verHashMap();
        System.out.println();
        System.out.println("================================");
        ms = aux;
    }

    public static void verHashMap() throws InterruptedException {
        System.out.println();
        for (int i = 1001; i < contas.size() + 1001; i++) {
            System.out.print(" " + contas.get(i).getNumeroConta() + " ");
            System.out.print(contas.get(i).getTipoConta() + " ");
            System.out.print(contas.get(i).getTipoCliente() + " ");
            System.out.println(contas.get(i).saldo());
        }
    }

    public static void esperar() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(ms);
        System.out.println();
    }

    public static void esperar(int msg) throws InterruptedException {
        esperar();
        if (ms != 0) {
            switch (msg) {
                case 1:
                    System.out.println(" Só um minuto...");
                    break;
            }
            esperar();
        }
    }

}
