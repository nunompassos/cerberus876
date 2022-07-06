package br.com.letscode.Classes;

import java.math.BigDecimal;

import br.com.letscode.App;

public class Conta {
    Integer numeroDaConta;
    static TipoDeConta tipo;
    BigDecimal saldo;
    BigDecimal taxaRendimento;
    // saque ou transferencia
    BigDecimal taxa; // Será 0.05 para PJ e 0 para PF.

    // Construtor
    public Conta(int numero, int tipo) {
        this.numeroDaConta = numero;
        this.tipo = TipoDeConta.values()[tipo];
        this.saldo = new BigDecimal("0,00");
    }

    // Getters e Setters
    public BigDecimal getSaldo() {
        return saldo;
    }

    // Outros métodos


    private static void criarConta(String tipoStr) {
        switch (tipo) {
            case CORRENTE:
                contasCorrentes.add(new ContaCorrente(tipoDeConta));
                countContas++;
                break;
            case INVESTIMENTO:
                contasInvestimento.add(new ContaInvestimento(tipoDeConta));
                countContas++;
                break;
            case POUPANCA:
                contasPoupancas.acc(new ContaPoupanca(tipoDeConta));
                countContas++;
                break;
            default:
                System.out.println("O comando que digitou é invalido.");
        }
        System.out.printf("%i Anota aí! O número da sua conta é", countContas);

    }

    public void fazRender() {
        this.saldo = this.saldo.multiply(taxaRendimento);
    }

}
