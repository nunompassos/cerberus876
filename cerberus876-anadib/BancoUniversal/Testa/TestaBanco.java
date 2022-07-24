package Testa;

import java.math.BigDecimal;
import java.util.Scanner;
import Cliente.Arrojado;
import Cliente.Conservador;
import Cliente.Moderado;

public class TestaBanco {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int idade;
    BigDecimal saldo = new BigDecimal("0");
    BigDecimal valor = new BigDecimal("0");
    try {
        System.out.println("Informe a idade do cliente");
        idade = sc.nextInt();
        System.out.println("idade = " + idade);
        System.out.println("Informe valor a investir no formato 9999,99");
        valor = sc.nextBigDecimal();
        if(idade < 21) {
            System.out.println("cliente do tipo arrojado");
            Arrojado arrojado = new Arrojado("jose");
            arrojado.setPerfil("arrojado");
            saldo = arrojado.investirAcao(valor);
    //        arrojado.investirCDB(valor);
            System.out.println(arrojado.getNome() + " investiu: R$ " + saldo + " em ação");
            saldo = arrojado.investirFundoImobiliario(valor);
            System.out.println(arrojado.getNome() + " investiu: R$ " + saldo + " no Fundo Imobiliário");

        }

        if(idade > 20 && idade < 61) {
            System.out.println("cliente do tipo moderado");
            Moderado moderado = new Moderado("jose");
            moderado.setPerfil("moderado");
            moderado.investirTesouro(valor);
        //    saldo = moderado.investirCDB(valor);
            System.out.println(moderado.getNome() + " investiu: R$ " + saldo + " em CDB");
        //    saldo = moderado.investirTesouro(valor);
            System.out.println(moderado.getNome() + " investiu: R$ " + saldo + " no Tesouro");

        }

        if(idade > 60) {
            System.out.println("cliente conservador");
            Conservador conservador = new Conservador("jose");
    //        conservador.investirAcao(valor);
            conservador.investirCDB(valor);
            saldo = conservador.investirTesouro(valor);
            conservador.setPerfil("conservador");
            System.out.println(conservador.getNome() + " investiu: R$ " + saldo + " no Tesouro");
        }

    }
    catch (Exception e) {
        System.out.println("Cliente não pode efetuar esse tipo de operação " + e);   
    }
    finally{
       sc.close();
    }

    }
}
