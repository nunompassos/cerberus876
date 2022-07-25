package br.com.letscode;

import java.math.BigDecimal;

public class Aluguel {

    private Cliente cliente;
    private Veiculo veiculo;
    private int dias;

    public Aluguel(Cliente cliente, Veiculo veiculo, int dias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public int getDias() {
        return dias;
    }

    public BigDecimal calcula() {
        BigDecimal valorFinal = veiculo.getPrecoBaseDiaria();
        valorFinal = valorFinal.multiply(BigDecimal.valueOf(dias));
        if (dias >= cliente.getMinimoDias()) {
            BigDecimal desc = BigDecimal.valueOf(100 - cliente.getDescontoDiaria());
            desc = desc.divide(BigDecimal.valueOf(100));
            valorFinal = valorFinal.multiply(desc);
        }
        return valorFinal;
    }

}
