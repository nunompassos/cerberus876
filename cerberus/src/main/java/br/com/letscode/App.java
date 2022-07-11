package br.com.letscode;

import java.math.BigDecimal;

import br.com.letscode.clientes.Cliente;
import br.com.letscode.clientes.ClientePF;
import br.com.letscode.clientes.ClientePJ;
import br.com.letscode.clientes.TipoDeEmpresa;
import br.com.letscode.contas.ContaCorrente;
import br.com.letscode.contas.ContaInvestimento;
import br.com.letscode.contas.ContaPoupanca;

public class App {
    public static void main( String[] args ) {
        // Definições
        Cliente luany = new ClientePF("Luany", "12345678900", 22);
        ClientePF rick = new ClientePF("Rick", "12345671241", 22);
        Cliente pyc = new ClientePJ("PYC", "92901501858152", TipoDeEmpresa.SA);
        
        ContaCorrente contaDaLuany = new ContaCorrente(luany);
        ContaInvestimento contaDoKennedy = new ContaInvestimento(pyc);
        ContaPoupanca contaDoRick = new ContaPoupanca(rick);

        // Operações
        contaDaLuany.depositar(1000);
        contaDoKennedy.depositar(1000);
        contaDoRick.depositar(1000);

        contaDaLuany.sacar(BigDecimal.valueOf(150));
        contaDoKennedy.transferir(BigDecimal.valueOf(100), contaDaLuany);
        contaDoKennedy.investir();
        contaDoRick.renderJuros();

        contaDaLuany.consultarSaldo();
        contaDoKennedy.consultarSaldo();
        contaDoRick.consultarSaldo();
    }
}
