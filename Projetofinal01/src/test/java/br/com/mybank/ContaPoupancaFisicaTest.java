package br.com.mybank;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import br.com.mybank.models.cliente.ClientePessoaFisica;
import br.com.mybank.models.conta.ContaPoupanca;
import br.com.mybank.models.exceptions.MensagemErro;


@TestMethodOrder(OrderAnnotation.class)
public class ContaPoupancaFisicaTest{

  public static ContaPoupanca contaPoupanca;
    
  @BeforeAll
  @DisplayName("Inicializa a conta com R$ 1000 de saldo")
  public static void  setup() throws MensagemErro{
      contaPoupanca = new ContaPoupanca("001", 111, new ClientePessoaFisica("Bernardo"));
      contaPoupanca.depositar(new BigDecimal("1000.00"));   
  }

  @Test
  @DisplayName("Deposita na conta mais R$ 500.00")
  @Order(1)
  public void testDeposito() throws MensagemErro{
    contaPoupanca.depositar(new BigDecimal("500.00"));
    assertTrue(contaPoupanca.getSaldo().compareTo(new BigDecimal("400.00")) == 1);
  }

  @Test
  @DisplayName("Saca da conta R$ 500.00")
  @Order(2)
  public void testsaque() throws MensagemErro{
    contaPoupanca.sacar(new BigDecimal("500.00"));
    assertTrue(contaPoupanca.getSaldo().compareTo(new BigDecimal("1000.00")) == 0);
  }


  // @BeforeEach
  // public void initEach(TestInfo testInfo){
  //     System.out.println(testInfo.getDisplayName());
  // }

  @AfterEach
  public void endEach(TestInfo testInfo){
      System.out.println(testInfo.getDisplayName());
      System.out.println("Saldo Conta poupanca " + contaPoupanca.getSaldo());;
  }

}