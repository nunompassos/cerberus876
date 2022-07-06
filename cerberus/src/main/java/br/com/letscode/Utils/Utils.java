package br.com.letscode.Utils;

import java.math.BigDecimal;
import java.util.Scanner;

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
  public static BigDecimal checkNumber(BigDecimal num, Scanner scanner,String field) {
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
}
