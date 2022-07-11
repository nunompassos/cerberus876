package br.com.letscode.contas;

import java.math.BigDecimal;

import br.com.letscode.clientes.Cliente;

public class ContaInvestimento extends Conta {

    private BigDecimal jurosDeRendimento;
    
    public ContaInvestimento(Cliente titular) {
        super(titular);
        this.setJurosDeRendimento();
    }

    public void investir(){
        this.setSaldo(
            this.getSaldo()
            .multiply(this.getJurosDeRendimento())
        );
    }

    public void setJurosDeRendimento(){
        if(this.isPessoaJuridica()){
            this.jurosDeRendimento = BigDecimal.valueOf(1.12);
        } else {
            this.jurosDeRendimento = BigDecimal.valueOf(1.10);
        }
    }

    public BigDecimal getJurosDeRendimento(){
        return this.jurosDeRendimento;
    }

}
