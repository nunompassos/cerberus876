package br.com.mybank.models.conta;
import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.mybank.interfaces.OperacaoConsultaSaldo;
import br.com.mybank.models.cliente.ClientePessoaFisica;


public class ContaPoupanca extends Conta implements OperacaoConsultaSaldo{
    private BigDecimal taxaRendimento = new BigDecimal(1.5);

    public ContaPoupanca(String agencia, int conta, ClientePessoaFisica titular){
        super(agencia, conta, titular);
    }

    public BigDecimal jurosPoupanca(){
        return super.getSaldo().multiply(this.taxaRendimento);
    }

    public BigDecimal getsaldoPoupancaComJuros() {
        return super.getSaldo().add(jurosPoupanca());
    }

    public BigDecimal getsaldoPoupancaSemJuros() {
        return super.getSaldo();
    }
    
    public BigDecimal getTaxaRendimento() {
        return taxaRendimento;
    }
    public void setTaxaRendimento(BigDecimal taxa) {
        this.taxaRendimento = taxaRendimento.divide(new BigDecimal(100));   
    }

    @Override
    public BigDecimal investir() {
        setSaldo(getSaldo().multiply(this.taxaRendimento.divide(new BigDecimal(100))).add(getSaldo()).setScale(2,RoundingMode.DOWN));
        return getSaldo();
    }

    @Override
    public BigDecimal consultarSaldo() {
        return getSaldo();
    }
}
