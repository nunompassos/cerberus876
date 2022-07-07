package br.com.letscode.Utils;

import java.math.BigDecimal;
import java.util.Scanner;

import br.com.letscode.models.ContaCorrente;
import br.com.letscode.models.ContaInvestimento;
import br.com.letscode.models.ContaPoupanca;

public class Utils {
  public static int checkNumber(int num, Scanner scanner, String field) {
    while (num == 0) {
      System.out.println(field);
      String numberString = scanner.nextLine();
      num = 0;
      try {
        num = Integer.parseInt(numberString);
      } catch (Exception e) {
        System.out.println("Por favor, selecione um numero válido");
      }
      if (num <= 0) {
        num = 0;
      }
    }
    return num;
  }

  public static BigDecimal checkNumber(BigDecimal num, Scanner scanner, String field) {
    while (num == null) {
      try {
        System.out.println(field);
        num = new BigDecimal(scanner.nextLine());
      } catch (Exception e) {
        System.out.println("Por favor, digite um numero válido");
      }
    }
    return num;
  }

  public static ContaCorrente findCorrenteById(int idConta) {
    ContaCorrente conta = ContaCorrente.contas.stream()
        .filter(conta -> (conta.getNumeroDaConta() == idConta))
        .findAny()
        .orElse(null);
    return conta;
  }

  public static ContaPoupanca findPoupancaById(int idConta) {
    ContaPoupanca conta = ContaPoupanca.contas.stream()
        .filter(conta -> (conta.getNumeroDaConta() == idConta))
        .findAny()
        .orElse(null);
    return conta;

  }

  public static ContaInvestimento findCorrenteById(int idConta) {
    ContaCorrente conta = ContaCorrente.contas.stream()
        .filter(conta -> (conta.getNumeroDaConta() == idConta))
        .findAny()
        .orElse(null);
    return conta;

  }
}
