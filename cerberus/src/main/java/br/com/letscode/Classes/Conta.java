package br.com.letscode.Classes;
import java.math.BigDecimal;
import br.com.letscode.App;

public class Conta {
    Integer numeroDaConta;
    static TipoDeConta tipo;
    static Personalidade personalidade;
    BigDecimal saldo;
    BigDecimal rendimento;  
    BigDecimal rendimentoExtra = ;
    // saque ou transferencia
    BigDecimal taxa; // Será 0.05 para PJ e 0 para PF.

    // Construtor
    public Conta(int numero, int tipo, int personalidade) {
        this.numeroDaConta = numero;
        this.tipo = TipoDeConta.values()[tipo];
        this.personalidade = Personalidade.values()[personalidade];
        this.saldo = new BigDecimal("0,00");
    }

    // Getters e Setters
    public BigDecimal getSaldo() {
        return saldo;
    }

    // Outros métodos


    private static void criarConta(int tipoInt, int personalidade) {
        App.countContas++;
        App.contas.add(new Conta(App.countContas, tipoInt, personalidade));
        System.out.printf("Anota aí! O número da sua conta é", App.countContas);
    }

    public void fazRender() {
        this.saldo = this.saldo.multiply(this.rendimento.add(this.rendimentoExtra));
    }

}
