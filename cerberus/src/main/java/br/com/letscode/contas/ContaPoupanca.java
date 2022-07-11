package br.com.letscode.contas;

import java.math.BigDecimal;
import br.com.letscode.clientes.ClientePF;

public class ContaPoupanca extends Conta {

    private BigDecimal juros;
    
    public ContaPoupanca(ClientePF cliente) {
        super(cliente);
        this.setJuros();
    }

    public void renderJuros(){
        this.setSaldo(
            this.getSaldo()
            .multiply(this.getJuros())
        );
    }

    public void setJuros(){
        this.juros = BigDecimal.valueOf(1.10);
    }

    public BigDecimal getJuros(){
        return this.juros;
    }

}
