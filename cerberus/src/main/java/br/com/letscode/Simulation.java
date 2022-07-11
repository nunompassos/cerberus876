package br.com.letscode;

import java.math.BigDecimal;

import br.com.letscode.Utils.Utils;
import br.com.letscode.models.Conta;
import br.com.letscode.models.ContaCorrente;
import br.com.letscode.models.ContaCorrentePF;
import br.com.letscode.models.ContaCorrentePJ;
import br.com.letscode.models.ContaInvestimento;
import br.com.letscode.models.ContaInvestimentoPF;
import br.com.letscode.models.ContaInvestimentoPJ;
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
        System.out.println(contaATrasferirDaFilha);
        System.out.println("Que legal! Pais e filhos utilizando a conta juntos!");
        dorme();
        limpaTela();
        System.out.println("passado um ano...");
        dorme();
        limpaTela();
        BigDecimal saldoAntigo = contaPoupancaDoPai.getSaldo();
        contaPoupancaDoPai.rende();
        BigDecimal rendimento = contaPoupancaDoPai.getSaldo().subtract(saldoAntigo);
        System.out.println("A conta do pai rendeu " + rendimento);
        System.out.println("Legal, não é? Esse é o rendimento anual!");
        // falta conta investimento pf e conta investimento pj
        // checar conta corrente para tranferencia e rendimento da investimento
        dorme();
        limpaTela();
        System.out.println("Bom dia!!");
        System.out.println("Gostaria de criar uma conta investimento?");
        dorme();
        System.out.println("Para voce e para sua empresa? Interessante!");
        System.out.println("Criando...");
        dorme(3000);
        ContaInvestimentoPF contaInvestimentoPF = new ContaInvestimentoPF(contaCorrentePF);
        ContaInvestimentoPJ contaInvestimentoPJ = new ContaInvestimentoPJ(contaCorrentePJ);
        contaCorrentePF.depositar(new BigDecimal(10000));
        contaCorrentePJ.depositar(new BigDecimal(23000000));
        ContaInvestimento.contas.add(contaInvestimentoPF);
        ContaInvestimento.contas.add(contaInvestimentoPJ);
        System.out.print("Conta corrente titular ->: " + contaCorrentePF);
        System.out.println(contaInvestimentoPF);
        dorme(2000);
        System.out.print("Conta corrente titular ->: " + contaCorrentePJ);
        System.out.println(contaInvestimentoPJ);
        dorme();
        limpaTela();
        System.out.println("Voce gostaria de aportar quanto?");
        dorme();
        System.out.println("R$2000?");
        dorme();
        System.out.println("Certinho, fazendo o aporte...");
        contaInvestimentoPF.aportar(new BigDecimal(2000));
        dorme(2000);
        limpaTela();
        System.out.println("Voce gostaria de aportar na sua conta da empresa também?");
        dorme();
        System.out.println("É pra já!");
        contaInvestimentoPJ.aportar(new BigDecimal(200000));
        dorme();
        limpaTela();
        BigDecimal saldoContaPFAnterior = contaInvestimentoPF.getSaldo();
        BigDecimal saldoContaPJAnterior = contaInvestimentoPJ.getSaldo();
        contaInvestimentoPF.rende();
        contaInvestimentoPJ.rende();
        BigDecimal rendimentoContaPF = contaInvestimentoPF.getSaldo().subtract(saldoContaPFAnterior);
        BigDecimal rendimentoContaPJ = contaInvestimentoPJ.getSaldo().subtract(saldoContaPJAnterior);
        dorme();
        System.out.println("Olha que legal, ambas suas contas renderam!");
        System.out.println("Rendimento da " + contaInvestimentoPF.getClass().getSimpleName() + " " + rendimentoContaPF);
        System.out.println("Rendimento da " + contaInvestimentoPJ.getClass().getSimpleName() + " " + rendimentoContaPJ);
        System.out.println(contaInvestimentoPF);
        System.out.println(contaInvestimentoPJ);
        dorme();
        limpaTela();
        System.out.println("Obrigado por usar o Let's Bank, a gente se ve por aí!");
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

    private static void useSuaContaComCarinho(Conta conta) {
        System.out.println("- Aqui está sua conta! Use a com carinho ❤");
        System.out.println(conta);
    }

    static void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
