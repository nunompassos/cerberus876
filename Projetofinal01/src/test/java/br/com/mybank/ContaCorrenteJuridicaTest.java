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

import br.com.mybank.models.cliente.ClientePessoaJuridica;
import br.com.mybank.models.conta.ContaCorrente;
import br.com.mybank.models.exceptions.MensagemErro;


@TestMethodOrder(OrderAnnotation.class)
public class ContaCorrenteJuridicaTest{

  public static ContaCorrente contaCorrente;
    
  @BeforeAll
  @DisplayName("Inicializa a conta com R$ 1000 de saldo")
  public static void  setup() throws MensagemErro{
      contaCorrente = new ContaCorrente("001", 111, new ClientePessoaJuridica("Bernardo"));
      contaCorrente.depositar(new BigDecimal("1000.00"));   
  }

  @Test
  @DisplayName("Deposita na conta mais R$ 500.00")
  @Order(1)
  public void testDeposito() throws MensagemErro{
    contaCorrente.depositar(new BigDecimal("500.00"));
    assertTrue(contaCorrente.getSaldo().compareTo(new BigDecimal("400.00")) == 1);
  }

  @Test
  @DisplayName("Saca da conta R$ 500.00")
  @Order(2)
  public void testsaque() throws MensagemErro{
    contaCorrente.sacar(new BigDecimal("500.00"));
    assertTrue(contaCorrente.getSaldo().compareTo(new BigDecimal("1000.00")) == -1);
  }

  @Test
  @DisplayName("Saca da conta R$ 100.00 com taxa de 10%")
  @Order(3)
  public void testsaquecomTaxaDiferente() throws MensagemErro{
    contaCorrente.setTaxa(new BigDecimal("50"));
    contaCorrente.sacar(new BigDecimal("100.00"));
    assertTrue(contaCorrente.getSaldo().compareTo(new BigDecimal("900.00")) == -1);
  }


  // @BeforeEach
  // public void initEach(TestInfo testInfo){
  //     System.out.println(testInfo.getDisplayName());
  // }

  @AfterEach
  public void endEach(TestInfo testInfo){
      System.out.println(testInfo.getDisplayName());
      System.out.println("Saldo Conta corrente " + contaCorrente.getSaldo());;
  }

}