

import java.math.BigDecimal;

public class ClienteEspecial extends Cliente implements Cliente.OperacaoSaldoAtualizado {
    private BigDecimal bonus = new BigDecimal("0");

    public ClienteEspecial(BigDecimal valor) {
        this.bonus = valor;
    }
       
    @Override
    public BigDecimal saldoAtualizado() {
        BigDecimal saldoAtual = getSaldo();
        saldoAtual = saldoAtual.add(bonus);
        System.out.println("O valor do saldo atual é: " + saldoAtual);
        return saldoAtual;
    }
}
