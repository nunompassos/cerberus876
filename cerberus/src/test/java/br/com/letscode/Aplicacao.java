package br.com.letscode;

import java.util.HashMap;
import java.math.BigDecimal;

public class Aplicacao {

    static HashMap<Integer, Conta> contas = new HashMap<Integer, Conta>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("================================");
        System.out.println("        EXECUTANDO TESTES       ");
        System.out.println("================================");
        System.out.println();
        System.out.println(" » Instanciando 5 contas");
        ContaCC c1001 = new ContaCC(1001, TipoCliente.PF, new BigDecimal("0.00"));
        ContaCP c1002 = new ContaCP(1002, new BigDecimal("0.00"));
        ContaCI c1003 = new ContaCI(1003, TipoCliente.PF, new BigDecimal("0.00"));
        ContaCC c1004 = new ContaCC(1004, TipoCliente.PJ, new BigDecimal("0.00"));
        ContaCI c1005 = new ContaCI(1005, TipoCliente.PJ, new BigDecimal("0.00"));
        System.out.println();
		System.out.println(" » Persistindo no HashMap");
        contas.put(c1001.getNumeroConta(), c1001);
		contas.put(c1002.getNumeroConta(), c1002);
		contas.put(c1003.getNumeroConta(), c1003);
		contas.put(c1004.getNumeroConta(), c1004);
		contas.put(c1005.getNumeroConta(), c1005);
        verHashMap();
		System.out.println(" » Depositando R$ 1000,00");
		c1001.depositar(new BigDecimal("1000"));
		c1002.depositar(new BigDecimal("1000"));
		c1003.depositar(new BigDecimal("1000"));
		c1004.depositar(new BigDecimal("1000"));
		c1005.depositar(new BigDecimal("1000"));
		verHashMap();
		System.out.println(" » Sacando R$ 100,00");
		c1001.sacar(new BigDecimal("100"));
		c1002.sacar(new BigDecimal("100"));
		c1003.sacar(new BigDecimal("100"));
		c1004.sacar(new BigDecimal("100"));
		c1005.sacar(new BigDecimal("100"));
		verHashMap();
		System.out.println(" » Sacando R$ 950,00");
		c1001.sacar(new BigDecimal("950"));
		c1002.sacar(new BigDecimal("950"));
		c1003.sacar(new BigDecimal("950"));
		c1004.sacar(new BigDecimal("950"));
		c1005.sacar(new BigDecimal("950"));
		verHashMap();
		System.out.println(" » Transferindo R$ 100,00");
		System.out.println(" Conta 1001 => 1004");
        c1001.transferir(new BigDecimal("100"), c1004);
		verHashMap();
		System.out.println(" » Transferindo R$ 100,00");
		System.out.println(" Conta 1001 => 1002");
        c1001.transferir(new BigDecimal("100"), c1002);
		verHashMap();
		System.out.println(" » Transferindo R$ 100,00");
		System.out.println(" Conta 1004 => 1001");
        c1004.transferir(new BigDecimal("100"), c1001);
		verHashMap();
		System.out.println(" » Investindo R$ 100,00");
		System.out.println(" Conta 1001 => 1003");
        c1001.investir(new BigDecimal("100"), c1003);
		verHashMap();
		System.out.println(" » Investindo R$ 100,00");
		System.out.println(" Conta 1004 => 1005");
        c1004.investir(new BigDecimal("100"), c1005);
		verHashMap();
        System.out.println(" » Simulando Rendimento");
        simulaCiclo();
        verHashMap();
		System.out.println("================================");
    }

    public static void verHashMap() {
        System.out.println();
        for (int i = 1001; i < contas.size() + 1001; i++) {
            System.out.print(" " + contas.get(i).getNumeroConta() + " ");
            System.out.print(contas.get(i).getTipoConta() + " ");
            System.out.print(contas.get(i).getTipoCliente() + " ");
            System.out.println(contas.get(i).getSaldoConta("R$ #,##0.00"));
        }
        System.out.println();
    }

    public static void simulaCiclo() {
        for (int i = 1001; i < contas.size() + 1001; i++) {
            contas.get(i).render();
        }
    }

}
