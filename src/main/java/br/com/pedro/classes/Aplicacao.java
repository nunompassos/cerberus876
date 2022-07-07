package br.com.pedro.classes;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import br.com.pedro.classes.ClientePessoaFisica.EstadoCivil;

public class Aplicacao {

    public static void main(String[] args) throws IOException, ClienteException, ContaException {

        new Carga();

        Scanner sc = new Scanner(System.in);

        menuInicial(sc);

        System.out.println();
        sc.close();
    }

    private static void menuInicial(Scanner sc) throws ClienteException, ContaException {
        Util.logo("Menu Inicial");
        System.out.println("01.   Abertura de Conta");
        System.out.println("02.   Consultas");
        System.out.println("03.   Transações");
        System.out.println("04.   Sair");
        System.out.println();

        int escolhido;
        do {
            System.out.print("Informe a opção:  ");
            while (!sc.hasNextInt()) {
                System.out.print("Informe a opção:  ");
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 4 || escolhido < 1);

        switch (escolhido) {
            case 1:
                menuAberturaDeConta(sc, null);
                return;
            case 2:
                menuConsultas(sc, null);
                return;
            case 3:
                menuTransacoes(sc, null);
                return;
            case 4:
                return;
            default:
                System.out.println("Erro!");
        }
    }

    private static void menuAberturaDeConta(Scanner sc, String mensagem) throws ClienteException, ContaException {
        Util.logo("Abertura de Conta");
        System.out.println("01.   Abrir Conta Corrente Pessoa Física");
        System.out.println("02.   Abrir Conta Corrente Pessoa Jurídica");
        System.out.println("03.   Abrir Conta Poupanca");
        System.out.println("04.   Retornar ao menu anterior");
        System.out.println();

        if (mensagem != null) {
            System.out.println(mensagem);
            System.out.println();
        }

        int escolhido;
        do {
            System.out.print("Informe a opção:  ");
            while (!sc.hasNextInt()) {
                System.out.print("Informe a opção:  ");
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 4 || escolhido < 1);

        switch (escolhido) {
            case 1:
                aberturaDeContaPessoaFisica(sc);
                menuAberturaDeConta(sc, null);
                return;
            case 2:
                aberturaDeContaPessoaJuridica(sc);
                menuAberturaDeConta(sc, null);
                return;
            case 3:
                aberturaDeContaPoupanca(sc);
                menuAberturaDeConta(sc, null);
                return;
            case 4:
                menuInicial(sc);
                return;
            default:
                System.out.println("Erro!");
        }
    }

    private static void aberturaDeContaPessoaFisica(Scanner sc) throws ClienteException, ContaException {
        Util.logo("Abertura de Conta Pessoa Física");
        sc.nextLine();

        System.out.print("Digite o nome do cliente ....:   ");
        String nome;
        do {
            nome = sc.nextLine();
            if (nome.length() < 3) {
                System.out.println("Nome invalido\n");
                System.out.print("Digite o nome do cliente ....:   ");
            }
        } while (nome.length() < 3);

        System.out.print("Digite o CPF do cliente .....:   ");
        String cpf;
        do {
            cpf = sc.nextLine();
            if (cpf.length() < 11) {
                System.out.println("CPF invalido\n");
                System.out.print("Digite o CPF do cliente .....:   ");
            }
        } while (cpf.length() < 11);

        System.out.println();
        EstadoCivil.imprimirOpcoes();
        System.out.print("Digite o estado civil .......:   ");
        int numeroEstadoCivil;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroEstadoCivil = sc.nextInt();
        } while (numeroEstadoCivil < 1 || numeroEstadoCivil > EstadoCivil.values().length);

        System.out.print("Digite o número da agência ..:   ");
        int numeroAgencia;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroAgencia = sc.nextInt();
        } while (numeroAgencia < 1);

        if (!Agencia.agenciaExiste(numeroAgencia)) {
            menuAberturaDeConta(sc, "Agência não localizada");
            return;
        }

        System.out.print("Digite o número da conta ....:   ");
        int numeroConta;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroConta = sc.nextInt();
        } while (numeroConta < 1);

        if (Agencia.getAgencia(numeroAgencia).contaExiste(numeroConta)) {
            menuTransacoes(sc, "Conta já existe");
            return;
        }

        ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica(
                nome,
                cpf,
                EstadoCivil.estadoCivilNumero(numeroEstadoCivil));

        new ContaCorrentePessoaFisica(
                Agencia.getAgencia(numeroAgencia),
                numeroConta,
                clientePessoaFisica);

        System.out.println();
        System.out.println("Conta Aberta com sucesso!");
        Util.aguardarEnter(sc);
    }

    private static void aberturaDeContaPessoaJuridica(Scanner sc) throws ClienteException, ContaException {
        Util.logo("Abertura de Conta Pessoa Jurídica");

        System.out.print("Digite o nome da empresa ....:   ");
        String nome;
        do {
            while (!sc.hasNext()) {
                sc.next();
            }
            nome = sc.next();
        } while (nome.length() < 3);

        System.out.print("Digite o CNPJ da empresa ....:   ");
        String cnpj;
        do {
            while (!sc.hasNext()) {
                sc.next();
            }
            cnpj = sc.next();
        } while (cnpj.length() < 15);

        System.out.print("Digite o número da agência ..:   ");
        int numeroAgencia;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroAgencia = sc.nextInt();
        } while (numeroAgencia < 1);

        if (!Agencia.agenciaExiste(numeroAgencia)) {
            menuTransacoes(sc, "Agência não localizada");
            return;
        }

        System.out.print("Digite o número da conta ....:   ");
        int numeroConta;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroConta = sc.nextInt();
        } while (numeroConta < 1);

        if (Agencia.getAgencia(numeroAgencia).contaExiste(numeroConta)) {
            menuTransacoes(sc, "Conta já existe");
            return;
        }

        ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica(
                nome,
                cnpj);

        new ContaCorrentePessoaJuridica(
                Agencia.getAgencia(numeroAgencia),
                numeroConta,
                clientePessoaJuridica);

        System.out.println();
        System.out.println("Conta Aberta com sucesso!");
        Util.aguardarEnter(sc);
    }

    private static void aberturaDeContaPoupanca(Scanner sc) throws ClienteException, ContaException {
        Util.logo("Abertura de Conta Poupança");

        System.out.print("Digite o nome do cliente ....:   ");
        String nome;
        do {
            while (!sc.hasNext()) {
                sc.next();
            }
            nome = sc.next();
        } while (nome.length() < 3);

        System.out.print("Digite o CPF do cliente .....:   ");
        String cpf;
        do {
            while (!sc.hasNext()) {
                sc.next();
            }
            cpf = sc.next();
        } while (cpf.length() < 11);

        System.out.println();
        EstadoCivil.imprimirOpcoes();
        System.out.print("Digite o estado civil .......:   ");
        int numeroEstadoCivil;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroEstadoCivil = sc.nextInt();
        } while (numeroEstadoCivil < 1 || numeroEstadoCivil > EstadoCivil.values().length);

        System.out.print("Digite o número da agência ..:   ");
        int numeroAgencia;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroAgencia = sc.nextInt();
        } while (numeroAgencia < 1);

        if (!Agencia.agenciaExiste(numeroAgencia)) {
            menuTransacoes(sc, "Agência não localizada");
            return;
        }

        System.out.print("Digite o número da conta ....:   ");
        int numeroConta;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroConta = sc.nextInt();
        } while (numeroConta < 1);

        if (Agencia.getAgencia(numeroAgencia).contaExiste(numeroConta)) {
            menuTransacoes(sc, "Conta já existe");
            return;
        }

        ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica(
                nome,
                cpf,
                EstadoCivil.estadoCivilNumero(numeroEstadoCivil));

        new ContaPoupanca(
                Agencia.getAgencia(numeroAgencia),
                numeroConta,
                clientePessoaFisica);

        System.out.println();
        System.out.println("Conta Aberta com sucesso!");
        Util.aguardarEnter(sc);
    }

    private static void menuConsultas(Scanner sc, String mensagem) throws ClienteException, ContaException {
        Util.logo("Menu Consultas");
        System.out.println("01.   Consulta Conta Corrente Pessoa Física");
        System.out.println("02.   Consulta Conta Corrente Pessoa Jurídica");
        System.out.println("03.   Consulta Conta Poupanca");
        System.out.println("04.   Retornar ao menu anterior");
        System.out.println();

        if (mensagem != null) {
            System.out.println(mensagem);
            System.out.println();
        }

        int escolhido;
        do {
            System.out.print("Informe a opção:  ");
            while (!sc.hasNextInt()) {
                System.out.print("Informe a opção:  ");
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 4 || escolhido < 1);

        switch (escolhido) {
            case 1:
                ContaCorrentePessoaFisica pf = null;
                try {
                    pf = (ContaCorrentePessoaFisica) consultaConta(sc, "Consulta Conta Corrente Pessoa Física");
                } catch (ClassCastException e) {
                    menuConsultas(sc, "Conta selecionada não é Conta Corrente Pessoa Física");
                }

                if (pf == null) {
                    menuConsultas(sc, "Agência ou conta não localizada!");
                    return;
                }
                Util.logo("Consulta Conta Corrente Pessoa Física");
                System.out.println(pf);
                System.out.println();
                Util.aguardarEnter(sc);
                menuConsultas(sc, null);
                return;
            case 2:
                ContaCorrentePessoaJuridica pj = null;
                try {
                    pj = (ContaCorrentePessoaJuridica) consultaConta(sc, "Consulta Conta Corrente Pessoa Jurídica");
                } catch (ClassCastException e) {
                    menuConsultas(sc, "Conta selecionada não é Conta Corrente Pessoa Jurídica");
                }

                if (pj == null) {
                    menuConsultas(sc, "Agência ou conta não localizada!");
                    return;
                }
                Util.logo("Consulta Conta Corrente Pessoa Jurídica");
                System.out.println(pj);
                System.out.println();
                Util.aguardarEnter(sc);
                menuConsultas(sc, null);
                return;
            case 3:
                ContaPoupanca poup = null;
                try {
                    poup = (ContaPoupanca) consultaConta(sc, "Consulta Conta Poupanca");
                } catch (ClassCastException e) {
                    menuConsultas(sc, "Conta selecionada não é Conta Poupança");
                }

                if (poup == null) {
                    menuConsultas(sc, "Agência ou conta não localizada!");
                    return;
                }

                Util.logo("Consulta Conta Poupanca");
                System.out.println(poup);
                System.out.println();
                Util.aguardarEnter(sc);
                menuConsultas(sc, null);
                return;
            case 4:
                menuInicial(sc);
                return;
            default:
                System.out.println("Erro!");
        }
    }

    private static Conta consultaConta(Scanner sc, String menuCabecalho) {
        Util.logo(menuCabecalho);
        System.out.print("Digite o número da agência ..:   ");

        int numeroAgencia;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroAgencia = sc.nextInt();
        } while (numeroAgencia < 1);

        if (!Agencia.agenciaExiste(numeroAgencia)) {
            return null;
        }

        System.out.print("Digite o número da conta ....:   ");
        int numeroConta;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroConta = sc.nextInt();
        } while (numeroConta < 1);

        if (!Agencia.getAgencia(numeroAgencia).contaExiste(numeroConta)) {
            return null;
        }

        return Agencia.getAgencia(numeroAgencia).getConta(numeroConta);
    }

    private static void menuTransacoes(Scanner sc, String mensagem) throws ClienteException, ContaException {
        Util.logo("Menu Transações");
        System.out.println("01.   Depositar");
        System.out.println("02.   Sacar");
        System.out.println("03.   Transferir");
        System.out.println("04.   Investir");
        System.out.println("05.   Poupar");
        System.out.println("06.   Retornar ao menu anterior");
        System.out.println();

        if (mensagem != null) {
            System.out.println(mensagem);
            System.out.println();
        }

        int escolhido;
        do {
            System.out.print("Informe a opção:  ");
            while (!sc.hasNextInt()) {
                System.out.print("Informe a opção:  ");
                sc.next();
            }
            escolhido = sc.nextInt();
        } while (escolhido > 6 || escolhido < 1);

        switch (escolhido) {
            case 1:
                depositar(sc);
                menuTransacoes(sc, null);
                return;
            case 2:
                sacar(sc);
                menuTransacoes(sc, null);
                return;
            case 3:
                transferir(sc);
                menuTransacoes(sc, null);
                return;
            case 4:
                investir(sc);
                menuTransacoes(sc, null);
                return;
            case 5:
                poupar(sc);
                menuTransacoes(sc, null);
                return;
            case 6:
                menuInicial(sc);
                return;
            default:
                System.out.println("Erro!");
        }
    }

    private static void depositar(Scanner sc) throws ClienteException, ContaException {
        Conta conta = consultaConta(sc, "Depositar");

        if (conta == null) {
            menuTransacoes(sc, "Agência ou conta não localizada!");
            return;
        }

        System.out.print("Digite o valor do depósito ..:   ");

        BigDecimal valor;
        do {
            while (!sc.hasNextDouble()) {
                sc.next();
            }
            valor = BigDecimal.valueOf(sc.nextDouble());
        } while (valor.compareTo(BigDecimal.valueOf(0.01)) < 0);

        conta.depositar(valor);
    }

    private static void sacar(Scanner sc) throws ClienteException, ContaException {
        Conta conta = consultaConta(sc, "Sacar");

        if (conta == null) {
            menuTransacoes(sc, "Agência ou conta não localizada!");
            return;
        }

        System.out.print("Digite o valor do saque .....:   ");

        BigDecimal valor;
        do {
            while (!sc.hasNextDouble()) {
                sc.next();
            }
            valor = BigDecimal.valueOf(sc.nextDouble());
        } while (valor.compareTo(BigDecimal.valueOf(0.01)) < 0);

        try {
            conta.sacar(valor);
        } catch (ContaException e) {
            menuTransacoes(sc, e.getMessage());
            return;
        }
    }

    private static Conta consultaParaTransferir(Scanner sc) {
        System.out.print("Digite o número da agência ..:   ");

        int numeroAgencia;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroAgencia = sc.nextInt();
        } while (numeroAgencia < 1);

        if (!Agencia.agenciaExiste(numeroAgencia)) {
            System.out.println("Agência não localizada");
            return null;
        }

        System.out.print("Digite o número da conta ....:   ");
        int numeroConta;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            numeroConta = sc.nextInt();
        } while (numeroConta < 1);

        if (!Agencia.getAgencia(numeroAgencia).contaExiste(numeroConta)) {
            System.out.println("Conta não localizada");
            return null;
        }

        return Agencia.getAgencia(numeroAgencia).getConta(numeroConta);
    }

    private static void transferir(Scanner sc) throws ClienteException, ContaException {
        Util.logo("Transferir");

        System.out.println("Informe os dados da conta de origem: \n");

        Conta contaOrigem = consultaParaTransferir(sc);

        if (contaOrigem == null) {
            menuTransacoes(sc, "Agência ou conta de origem não localizada!");
            return;
        }

        System.out.println("\nInforme os dados da conta de destino: \n");

        Conta contaDestino = consultaParaTransferir(sc);

        if (contaDestino == null) {
            menuTransacoes(sc, "Agência ou conta de destino não localizada!");
            return;
        }

        System.out.print("\nDigite o valor a transferir .:   ");

        BigDecimal valor;
        do {
            while (!sc.hasNextDouble()) {
                sc.next();
            }
            valor = BigDecimal.valueOf(sc.nextDouble());
        } while (valor.compareTo(BigDecimal.valueOf(0.01)) < 0);

        try {
            contaOrigem.transferir(contaDestino.getAgencia().getNumero(), contaDestino.getNumeroConta(), valor);
        } catch (AgenciaException | ContaException e) {
            menuTransacoes(sc, e.getMessage());
            return;
        }
    }

    private static void investir(Scanner sc) throws ClienteException, ContaException {

        ContaCorrente conta = null;
        try {
            conta = (ContaCorrente) consultaConta(sc, "Investir");
        } catch (ClassCastException e) {
            menuTransacoes(sc, "Conta selecionada não é Conta Corrente");
        }

        if (conta == null) {
            menuTransacoes(sc, "Agência ou conta não localizada!");
            return;
        }

        System.out.print("Digite o valor a investir ...:   ");

        BigDecimal valor;
        do {
            while (!sc.hasNextDouble()) {
                sc.next();
            }
            valor = BigDecimal.valueOf(sc.nextDouble());
        } while (valor.compareTo(BigDecimal.valueOf(0.01)) < 0);

        System.out.print("Digite o prazo em dias ......:   ");

        int dias;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            dias = sc.nextInt();
        } while (dias < 1);

        Number[] resultadoInvestimento = null;
        try {
            resultadoInvestimento =  conta.investir(valor, dias);
        } catch (ContaException e) {
            menuTransacoes(sc, e.getMessage());
            return;
        }

        double taxaAnual = (double) resultadoInvestimento[1] * 100;
        BigDecimal rendimento = (BigDecimal) resultadoInvestimento[2];

        System.out.println();
        System.out.println("Taxa de juros do investimento: " + taxaAnual + "% a.a.");
        System.out.println("Rendimento do investimento: R$ " + rendimento + "\n");
        Util.aguardarEnter(sc);
    }

    private static void poupar(Scanner sc) throws ClienteException, ContaException {
        ContaPoupanca conta = null;
        try {
            conta = (ContaPoupanca) consultaConta(sc, "Poupar");
        } catch (ClassCastException e) {
            menuTransacoes(sc, "Conta selecionada não é Conta Poupança");
        }

        if (conta == null) {
            menuTransacoes(sc, "Agência ou conta não localizada!");
            return;
        }

        System.out.print("Digite o valor a poupar .....:   ");

        BigDecimal valor;
        do {
            while (!sc.hasNextDouble()) {
                sc.next();
            }
            valor = BigDecimal.valueOf(sc.nextDouble());
        } while (valor.compareTo(BigDecimal.valueOf(0.01)) < 0);

        System.out.print("Digite o prazo em dias ......:   ");

        int dias;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            dias = sc.nextInt();
        } while (dias < 1);

        Number[] resultadoPoupanca = null;
        try {
            resultadoPoupanca =  conta.poupar(valor, dias);
        } catch (ContaException e) {
            menuTransacoes(sc, e.getMessage());
            return;
        }

        double correcaoPoupancaAnual = (double) resultadoPoupanca[1] * 100;
        BigDecimal rendimento = (BigDecimal) resultadoPoupanca[2];

        System.out.println();
        System.out.println("Taxa de juros do investimento: " + correcaoPoupancaAnual + "% a.a.");
        System.out.println("Rendimento do investimento: R$ " + rendimento + "\n");
        Util.aguardarEnter(sc);
    }
}