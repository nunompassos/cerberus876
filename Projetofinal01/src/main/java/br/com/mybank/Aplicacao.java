package br.com.mybank;

import java.math.BigDecimal;
import java.rmi.server.RemoteStub;
import java.util.Scanner;

import br.com.mybank.db.MyBankDB;
import br.com.mybank.models.cliente.Cliente;
import br.com.mybank.models.cliente.ClientePessoaFisica;
import br.com.mybank.models.cliente.ClientePessoaJuridica;
import br.com.mybank.models.conta.Conta;
import br.com.mybank.models.conta.ContaCorrente;
import br.com.mybank.models.conta.ContaInvestimento;
import br.com.mybank.models.conta.ContaPoupanca;
import br.com.mybank.models.exceptions.MensagemErro;

public class Aplicacao {
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws MensagemErro {
        basePovoar();
        
        menuPrincipal();
    }
    public static void menuPrincipal() throws MensagemErro{
        clear();
        System.out.println("___________________________________");
        System.out.println("|          __SISBB__              |");
        System.out.println("|                                 |");
        System.out.println("|1 - NOVA CONTA                   |");
        System.out.println("|2 - LOGIN                        |");
        System.out.println("|_________________________________|");
        int escolha = scanner.nextInt();
        switch(escolha){
            case 1:
                menuNovaConta();
                break;
            case 2:
                menuLogin();
                break;
            default:
                System.out.println("opção inválida");
        }
    }

    private static void menuNovaConta() throws MensagemErro {
        clear();
        System.out.println("___________________________________");
        System.out.println("           --SISBB--               ");

        System.out.println("Agencia da conta: ");
        String agencia = scanner.next();
        System.out.println("Numero da conta: ");
        int numero = scanner.nextInt();
        System.out.println("Nome do cliente: ");
        scanner.nextLine();
        String nomeCliente = scanner.nextLine();
        System.out.println("Você é pessoa fisica ou juridica?");
        System.out.println("1 - FISICA");
        System.out.println("2 - JURIDICA");
        int clienteTipo = scanner.nextInt();
        Cliente cliente = verificaTipoCliente(clienteTipo, nomeCliente);
        Conta c = menuTipoConta(agencia, numero, cliente);
        MyBankDB.abrirConta(c);
        menuPrincipal();
    }

    private static Cliente verificaTipoCliente(int cliente, String nomeCliente){
        if(cliente == 1){
            return new ClientePessoaFisica(nomeCliente);
        }
        return new ClientePessoaJuridica(nomeCliente);
    }

    private static Conta menuTipoConta(String agencia, int numero, Cliente tipoCliente) throws MensagemErro {
        clear();
        System.out.println("Qual tipo de conta voce deseja abrir?");
        System.out.println("1 - CONTA CORRENTE");
        System.out.println("2 - CONTA POUPANÇA");
        System.out.println("3 - CONTA INVESTIMENTO");
        int escolha = scanner.nextInt();
        if(escolha == 2 && (tipoCliente instanceof ClientePessoaJuridica)){
            System.out.println("Pessoa jurídica não pode abrir conta poupança");
            menuPrincipal();
        }
        switch(escolha){
            case 1:
                return new  ContaCorrente(agencia, numero, tipoCliente);  
            case 2:
                return new ContaPoupanca(agencia, numero, (ClientePessoaFisica)tipoCliente);
            case 3:
                return new ContaInvestimento(agencia, numero, tipoCliente); 
            default:
                throw new MensagemErro("Escolha invalida");  
        }
    }

    private static void menuLogin() throws MensagemErro {
        clear();
        System.out.println("Numero da conta pra logar: ");
        int numero = scanner.nextInt();
        Conta c = MyBankDB.login(numero);
        if(c != null){
            menuConta(numero);
        }
    }

    private static Conta contaDestino() {
        clear();
        System.out.println("Numero da conta de destino: ");
        int numero = scanner.nextInt();
        Conta dest = MyBankDB.login(numero);
        if(dest == null){
            System.out.println("conta inválida");
            scanner.close();
        }
        return dest;
    }

    private static void menuConta(int numero) throws MensagemErro {
        clear();
        Conta conta = MyBankDB.login(numero);
        System.out.println("Olá, " + conta.getTitular().getNome());
        System.out.println("Saldo da sua conta: " + conta.getSaldo());
        System.out.println("1 - DEPOSITAR");
        System.out.println("2 - SACAR");
        System.out.println("3 - TRANSFERIR");
        System.out.println("4 - INVESTIR");
        System.out.println("5 - SAIR");
        int escolha = scanner.nextInt();
        System.out.println("Informe valor no formato 9999.99");
        switch(escolha){
            case 1:
                {
                    double infoValor = scanner.nextDouble();
                    BigDecimal valor = BigDecimal.valueOf(infoValor);
                    menuDepositar(valor, conta);
                    menuConta(conta.getConta());
                    break;
                }
            case 2:
                {
                    double infoValor = scanner.nextDouble();
                    BigDecimal valor = BigDecimal.valueOf(infoValor);
                    menuSacar(valor, conta);
                    menuConta(conta.getConta());
                    break;
                }
            case 3:
                {
                    double infoValor = scanner.nextDouble();
                    BigDecimal valor = BigDecimal.valueOf(infoValor);
                    Conta dest = contaDestino();
                    menuTransferir(valor, conta, dest);
                    menuConta(conta.getConta());
                    break;
                }
            case 4:
                conta.investir();
                menuConta(conta.getConta());
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                System.out.println("opcao invalida");
                break;
        }
    }
 
    private static void menuDepositar(BigDecimal valor, Conta conta) throws MensagemErro {
        conta.depositar(valor);
    }

    private static void menuSacar(BigDecimal valor, Conta conta) throws MensagemErro {
        conta.sacar(valor);
    }

    private static void menuTransferir(BigDecimal valor, Conta conta, Conta dest) throws MensagemErro {
        conta.transferir(valor, dest);
    }

 
    public static void basePovoar() throws MensagemErro{
        Conta contaCorrente = new ContaCorrente("00", 0, new ClientePessoaJuridica("Bernardo"));
        Conta contaPoupanca = new ContaPoupanca("00", 11, new ClientePessoaFisica("Ana"));
        Conta contaInvestimento = new ContaInvestimento("00", 22, new ClientePessoaJuridica("Kennedy"));
        
        contaCorrente.depositar(new BigDecimal("1000.00"));
        contaPoupanca.depositar(BigDecimal.valueOf(500.00d));
        contaInvestimento.depositar(BigDecimal.valueOf(1000.00d));

        MyBankDB.abrirConta(contaCorrente);
        MyBankDB.abrirConta(contaPoupanca);
        MyBankDB.abrirConta(contaInvestimento);

    }
    
    private static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
