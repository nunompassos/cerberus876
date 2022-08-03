package br.com.letscode.contas;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

import br.com.letscode.clientes.Cliente;
import br.com.letscode.clientes.ClientePJ;
import br.com.letscode.clientes.OperacoesTaxadas;
import br.com.letscode.contas.exception.ContaException;

public abstract class Conta {

    private final String numeroConta;
    private BigDecimal saldo = BigDecimal.ZERO;
    private Cliente titular;

    public Conta(String _numeroConta, Cliente _titular) {
        this.numeroConta = _numeroConta;
        this.titular = _titular;
    }

    public BigDecimal sacar(BigDecimal valor) throws ContaException {
        validarValorTransacao(valor);
        if (saldo.subtract(valor).compareTo(BigDecimal.ZERO) < 0) {
            throw ContaException.saldoInsuficiente();
        }
        BigDecimal taxa = BigDecimal.ZERO;
        if (titular.isTaxavel()) {
            taxa = OperacoesTaxadas.taxa;
        }
        saldo = saldo.subtract(valor);
        return saldo;
    }

    public BigDecimal depositar(BigDecimal valor) {
        validarValorTransacao(valor);
        saldo = saldo.add(valor);
        return saldo;
    }

    public void transferir(BigDecimal valor, Conta contaDestino) throws ContaException {
        if (contaDestino == null) {
            throw ContaException.contaInvalida();
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    private void validarValorTransacao(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidParameterException("Valor negativo");
        }
    }
}
