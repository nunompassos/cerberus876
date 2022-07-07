package br.com.pedro.modelos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public abstract class ContaCorrente extends Conta {

    public ContaCorrente(Agencia agencia, int numeroConta) throws ContaException {
        super(agencia, numeroConta);
    }

    /*
     * O investimento tem uma taxa de juros variável, entre 0 e 10% a.a.
     * O investidor escolhe o valor e o número de dias para investir, o método
     * converte essa taxa de anual para diária
     * e retorna o valor do rendimento.
     */
    public Number[] investir(BigDecimal valor, int dias) throws ContaException {
        if (valor.compareTo(this.getSaldo()) > 0) {
            throw new ContaException("Saldo insuficiente");
        }
        this.setSaldo(this.getSaldo().subtract(valor));
        double taxaAnual = new Random().nextInt(1000) / 10000.0;
        double taxaDia = Math.pow(1.0 + taxaAnual, (1 / 360.0)) - 1;
        BigDecimal taxaAplicada = BigDecimal.valueOf(Math.pow(1 + taxaDia, dias) - 1).setScale(5, RoundingMode.HALF_UP);
        BigDecimal rendimento = valor.multiply(taxaAplicada).setScale(2, RoundingMode.HALF_UP);
        this.setSaldo(this.getSaldo().add(valor.add(rendimento)));
        return new Number[]{taxaAplicada, taxaAnual, rendimento};
    }
}
