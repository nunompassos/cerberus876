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
import br.com.mybank.models.cliente.ClientePessoaJuridica;
import br.com.mybank.models.conta.ContaCorrente;
import br.com.mybank.models.conta.ContaPoupanca;
import br.com.mybank.models.exceptions.MensagemErro;

@TestMethodOrder(OrderAnnotation.class)
public class ContaTransferenciaTest {
  public static ContaCorrente contaCorrente;
  public static ContaPoupanca contaPoupanca;
    
  @BeforeAll
  @DisplayName("Inicializa a conta com R$ 1000 de saldo")
  public static void  setup() throws MensagemErro{
      contaCorrente = new ContaCorrente("001", 111, new ClientePessoaJuridica("Bernardo"));
      contaPoupanca = new ContaPoupanca("001", 222, new ClientePessoaFisica("Ana"));
      contaCorrente.depositar(new BigDecimal("1000.00")); 
      contaPoupanca.depositar(new BigDecimal("1000.00"));  
  }

  @Test
  @DisplayName("Transfere da poupança R$ 100.00 para a corrente")
  @Order(1)
  public void testDeposito() throws MensagemErro{
    contaCorrente.transferir(new BigDecimal("100.00"), contaPoupanca);
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
      System.out.println("Saldo Conta poupanca " + contaPoupanca.getSaldo());;
  }

  
}
