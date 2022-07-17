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
import br.com.mybank.models.conta.ContaInvestimento;
import br.com.mybank.models.conta.ContaPoupanca;
import br.com.mybank.models.exceptions.MensagemErro;

@TestMethodOrder(OrderAnnotation.class)
public class ContaInvestimentoTest {
  public static ContaCorrente contaCorrente;
  public static ContaInvestimento contaInvestimento;
  public static ContaPoupanca contaPoupanca;
    
  @BeforeAll
  @DisplayName("Inicializa a conta com R$ 1000 de saldo")
  public static void  setup() throws MensagemErro{
    contaCorrente = new ContaCorrente("001", 111, new ClientePessoaFisica("Bernardo"));
    contaInvestimento = new ContaInvestimento("001", 111, new ClientePessoaJuridica("Ana"));
    contaPoupanca = new ContaPoupanca("001", 222, new ClientePessoaFisica("Eu"));
    contaCorrente.depositar(new BigDecimal("1000.00")); 
    contaInvestimento.depositar(new BigDecimal("1000.00"));
    contaPoupanca.depositar(new BigDecimal("1000.00"));
      
  }

  @Test
  @DisplayName("Investir saldo conta corrente")
  @Order(1)
  public void testInvestirContaCorrente() throws MensagemErro{
    contaCorrente.investir();
    assertTrue(contaCorrente.getSaldo().compareTo(new BigDecimal("1020.00")) == 0);
  }

  @Test
  @DisplayName("Investir saldo conta investimento")
  @Order(2)
  public void testInvestirContaInvestimento() throws MensagemErro{
    contaInvestimento.investir();
    assertTrue(contaInvestimento.getSaldo().compareTo(new BigDecimal("1040.00")) == 0);
  }


  @Test
  @DisplayName("Investir saldo conta poupanca")
  @Order(3)
  public void testInvestirContaPoupanca() throws MensagemErro{
    contaPoupanca.investir();
    assertTrue(contaPoupanca.getSaldo().compareTo(new BigDecimal("1015.00")) == 0);
  }

  // @BeforeEach
  // public void initEach(TestInfo testInfo){
  //     System.out.println(testInfo.getDisplayName());
  // }

  @AfterEach
  public void endEach(TestInfo testInfo){
      System.out.println(testInfo.getDisplayName());
      System.out.println("Saldo Conta corrente " + contaCorrente.getSaldo());
      System.out.println("Saldo Conta poupanca " + contaPoupanca.getSaldo());
      System.out.println("Saldo Conta investimento " + contaInvestimento.getSaldo());

  }
}
