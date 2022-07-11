package br.com.letscode.contas;

import java.math.BigDecimal;
import br.com.letscode.clientes.Cliente;

public class ContaCorrente extends Conta {

    private BigDecimal taxaAdministrativa;
    
    public ContaCorrente(Cliente cliente){
        super(cliente);
        this.setTaxaAdministrativa();
    }

    public void recolherTaxaAdministrativa(){
        this.setSaldo(
            this.getSaldo()
            .subtract(this.getTaxaAdministrativa())
        );
    }

    public void setTaxaAdministrativa(){
        this.taxaAdministrativa = BigDecimal.valueOf(15);
    }

    public BigDecimal getTaxaAdministrativa(){
        return this.taxaAdministrativa;
    }

}
