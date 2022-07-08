package br.com.letscode;

import java.math.BigDecimal;

import br.com.letscode.Utils.Utils;
import br.com.letscode.models.Conta;
import br.com.letscode.models.ContaCorrente;
import br.com.letscode.models.ContaCorrentePF;
import br.com.letscode.models.ContaCorrentePJ;
import br.com.letscode.models.ContaPoupanca;

final public class Simulation {
  static void start() throws InterruptedException {
    limpaTela();
    System.out.println("- Criando corrente PF...");
    dorme();
    ContaCorrentePF contaCorrentePF = new ContaCorrentePF();
    System.out.println("- Gerando o numero da conta...");
    dorme();
    analisandoDados();
    dorme();
    contaCorrentePF.setLimite(new BigDecimal(10000));
    ContaCorrente.contas.add(contaCorrentePF);
    useSuaContaComCarinho(contaCorrentePF);
    dorme(7500);
    limpaTela();
    dorme();
    System.out.println("- Ah, você de novo! Obrigado por vir novamente ao Let's bank!");
    dorme();
    System.out.println("- Criando uma conta corrente PJ...");
    dorme();
    ContaCorrentePJ contaCorrentePJ = new ContaCorrentePJ();
    analisandoDados();
    contaCorrentePJ.setLimite(new BigDecimal(10000000));
    ContaCorrente.contas.add(contaCorrentePJ);
    useSuaContaComCarinho(contaCorrentePJ);
    dorme(7500);
    System.out.println("- Olá, Bom dia");
    System.out.println("- Vi aqui que depositaram um dinheirinho na sua conta pra você!");
    contaCorrentePF.depositar(new BigDecimal("2010.100"));
    System.out.println("- Que legal!!");
    dorme();
    System.out.println("- Ah");
    dorme();
    System.out.println("- É seu salario?");
    dorme();
    System.out.println("- Me desculpa, to aprendendo ainda 😅");
    dorme();
    System.out.println("Vou buscar aqui na base de dados!");
    ContaCorrente contaDaBase = Utils.findCorrenteById(contaCorrentePF.getNumeroDaConta());
    System.out.println(contaDaBase);
    dorme();
    System.out.println("Tranferindo o dinheiro que você pediu...");
    contaDaBase.transfere(contaCorrentePJ.getNumeroDaConta(), contaCorrentePF.getSaldo());
    System.out.println("Transferindo...");
    dorme();
    System.out.println(contaCorrentePJ);
    dorme();
    limpaTela();
    System.out.println("Bom dia, quer uma conta poupança? É pra já!");
    dorme();
    System.out.println("Criando...");
    dorme();
    ContaPoupanca contaPoupancaDoPai = new ContaPoupanca();

    System.out.println(contaPoupancaDoPai);
    ContaPoupanca.contas.add(contaPoupancaDoPai);
    contaPoupancaDoPai.setLimite(new BigDecimal(600));
    contaPoupancaDoPai.depositar(new BigDecimal(1500));
    analisandoDados();
    useSuaContaComCarinho(contaPoupancaDoPai);
    System.out.println("Vai criar uma pra sua filha também? Que legal, ensinando educação financeira desde cedo!");
    dorme();
    ContaPoupanca contaPoupancaDaFilha = new ContaPoupanca();
    System.out.println("Como sua filha não possui formas de análise de crédito nós não poderemos dá-la crédito");
    useSuaContaComCarinho(contaPoupancaDaFilha);
    ContaPoupanca contaATrasferirDaFilha = Utils.findPoupancaById(contaPoupancaDoPai.getNumeroDaConta());
    contaPoupancaDoPai.transfere(contaATrasferirDaFilha.getNumeroDaConta(),
        new BigDecimal(750));
    dorme();
  }

  private static void dorme() throws InterruptedException {
    int delay = 1500;
    Thread.sleep(delay);
  }

  private static void dorme(int delayInMilliseconds) throws InterruptedException {
    Thread.sleep(delayInMilliseconds);
  }

  private static void analisandoDados() throws InterruptedException {
    System.out.println("- Analisando dados...");
    System.out.println("- Isso pode demorar um pouco, que tal um café? ☕");
    dorme(5000);
    System.out.println("- Gerando o limite da conta baseado nos dados recebidos...");
  }

  private static void useSuaContaComCarinho(Conta conta) throws InterruptedException {
    System.out.println("- Aqui está sua conta! Use a com carinho ❤");
    System.out.println(conta);
  }

  static void limpaTela() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
