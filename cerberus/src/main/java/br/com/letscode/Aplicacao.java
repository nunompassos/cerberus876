package br.com.letscode;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Aplicacao {

    public static void main(String[] args) {

        Cliente cPF = new ClientePF();
        Cliente cPJ = new ClientePJ();

        Veiculo vP = new VeiculoPequeno();
        Veiculo vM = new VeiculoMedio();
        Veiculo vS = new VeiculoSUV();

        Aluguel cPFvP4d = new Aluguel(cPF, vP, 4);
        Aluguel cPFvP5d = new Aluguel(cPF, vP, 5);
        Aluguel cPFvM4d = new Aluguel(cPF, vM, 4);
        Aluguel cPFvM5d = new Aluguel(cPF, vM, 5);
        Aluguel cPFvS4d = new Aluguel(cPF, vS, 4);
        Aluguel cPFvS5d = new Aluguel(cPF, vS, 5);
        Aluguel cPJvP2d = new Aluguel(cPJ, vP, 2);
        Aluguel cPJvP3d = new Aluguel(cPJ, vP, 3);
        Aluguel cPJvM2d = new Aluguel(cPJ, vM, 2);
        Aluguel cPJvM3d = new Aluguel(cPJ, vM, 3);
        Aluguel cPJvS2d = new Aluguel(cPJ, vS, 2);
        Aluguel cPJvS3d = new Aluguel(cPJ, vS, 3);

        System.out.println();
        System.out.println("Projeto Final BE-JV-003");
        System.out.println();

        testarAluguel(cPFvP4d);
        testarAluguel(cPFvP5d);
        testarAluguel(cPFvM4d);
        testarAluguel(cPFvM5d);
        testarAluguel(cPFvS4d);
        testarAluguel(cPFvS5d);
        testarAluguel(cPJvP2d);
        testarAluguel(cPJvP3d);
        testarAluguel(cPJvM2d);
        testarAluguel(cPJvM3d);
        testarAluguel(cPJvS2d);
        testarAluguel(cPJvS3d);

    }

    private static void testarAluguel(Aluguel aluguel) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DecimalFormat dp = new DecimalFormat("#0");
        System.out.println("Diárias: " + aluguel.getDias());
        if (aluguel.getCliente().getClass() == ClientePF.class) {
            System.out.println("Cliente: PF");
        } else {
            System.out.println("Cliente: PJ");
        }
        if (aluguel.getVeiculo().getClass() == VeiculoPequeno.class) {
            System.out.println("Veículo: Pequeno");
        } else if (aluguel.getVeiculo().getClass() == VeiculoMedio.class) {
            System.out.println("Veículo: Médio");
        } else {
            System.out.println("Veículo: SUV");
        }
        BigDecimal semDesconto = aluguel.getVeiculo().getPrecoBaseDiaria()
                .multiply(BigDecimal.valueOf(aluguel.getDias()));
        BigDecimal comDesconto = aluguel.calcula();
        BigDecimal desc = comDesconto.divide(semDesconto);
        desc = BigDecimal.valueOf(1).subtract(desc);
        desc = desc.multiply(BigDecimal.valueOf(100));
        System.out.println("Valor Total: R$ " + df.format(semDesconto));
        System.out.println("Valor Calculado: R$ " + df.format(comDesconto) + " (" + dp.format(desc) + "%)");
        System.out.println();
    }

}
