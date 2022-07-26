package br.com.letscode.aula6;

import java.math.BigDecimal;

import br.com.letscode.aula6.bancario.contas.ContaCorrente;
import br.com.letscode.aula6.bancario.contas.ContaPoupanca;
import br.com.letscode.aula6.bancario.contas.ContaPoupancaPrazo;
import br.com.letscode.aula6.bancario.ServicoSacarAppBancaria;

public class Aula6 {

    public static void main(String[] args) {
        ServicoSacarAppBancaria servicoSacar = new ServicoSacarAppBancaria();
        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();
        ContaPoupancaPrazo cpp = new ContaPoupancaPrazo();

        cc.depositar(BigDecimal.valueOf(1000));
        cp.depositar(BigDecimal.valueOf(1000));
        cpp.depositar(BigDecimal.valueOf(1000));


        servicoSacar.adicionarConta(cc);
        servicoSacar.adicionarConta(cp);
        // servicoSacar.adicionarConta(cpp);

        System.out.printf("Saquei 50 da conta corrente e fiquei com %f",
        servicoSacar.sacarConta(1, BigDecimal.valueOf(50)).doubleValue());
        System.out.println();
        System.out.printf("Saquei 500 da conta poupança e fiquei com %f",
        servicoSacar.sacarConta(2, BigDecimal.valueOf(500)).doubleValue());
        // System.out.printf("Saquei 50 da conta poupança prazo e fiquei com %f",
        //                   servicoSacar.sacarConta(3, BigDecimal.valueOf(500)).doubleValue());


    }
}
