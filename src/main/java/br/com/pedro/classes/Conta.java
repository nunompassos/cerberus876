package br.com.pedro.classes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Conta {

    private Agencia agencia;
    private int numeroConta;
    private BigDecimal saldo = BigDecimal.valueOf(0);

    public Conta(Agencia agencia, int numeroConta) throws ContaException {
        if (numeroConta < 1) {
            throw new ContaException("Número da conta precisa ser maior que zero");
        }
        if (agencia == null) {
            throw new ContaException("Agência não pode ser null");
        }
        if (agencia.contaExiste(numeroConta)) {
            throw new ContaException("Conta já existente");
        }
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.agencia.adicionarConta(this);
    }

    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    public void sacar(BigDecimal valor) throws ContaException {
        if (valor.compareTo(this.saldo) > 0) {
            throw new ContaException("Saldo insuficiente");
        }
        this.saldo = this.saldo.subtract(valor);
    }

    public void transferir(int numeroAgencia, int numeroConta, BigDecimal valor) throws ContaException, AgenciaException {
        this.sacar(valor);
        Agencia.getAgencia(numeroAgencia).getConta(numeroConta).depositar(valor);
    }

    /*
     * O investimento tem uma taxa de juros variável, entre 0 e 10% a.a.
     * O investidor escolhe o valor e o número de dias para investir, o método
     * converte essa taxa de anual para diária
     * e retorna o valor do rendimento.
     */
    public BigDecimal investir(BigDecimal valor, int dias) throws ContaException {
        if (valor.compareTo(this.saldo) > 0) {
            throw new ContaException("Saldo insuficiente");
        }
        this.saldo = this.saldo.subtract(valor);
        double taxaAnual = new Random().nextInt(1000) / 10000.0;
        double taxaDia = Math.pow(1.0 + taxaAnual, (1 / 360.0)) - 1;
        BigDecimal taxaAplicada = BigDecimal.valueOf(Math.pow(1 + taxaDia, dias) - 1).setScale(5, RoundingMode.UP);
        BigDecimal rendimento = valor.multiply(taxaAplicada).setScale(2, RoundingMode.UP);
        this.saldo = saldo.add(valor.add(rendimento));
        return taxaAplicada;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return this.agencia.toString() + "\n"
                + "Conta ......: " + this.numeroConta + "\n"
                + "Saldo ......: " + this.saldo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
        result = prime * result + numeroConta;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if (agencia == null) {
            if (other.agencia != null)
                return false;
        } else if (!agencia.equals(other.agencia))
            return false;
        if (numeroConta != other.numeroConta)
            return false;
        return true;
    }
}
