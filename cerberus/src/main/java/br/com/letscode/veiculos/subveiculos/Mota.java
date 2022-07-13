package br.com.letscode.veiculos.subveiculos;

import br.com.letscode.Veiculo;
import br.com.letscode.VeiculoImpl;

public class Mota implements Veiculo {

    public void ligarRadio() {
        System.out.println("Não tenho rádio");
    }

    @Override
    public void buzinar() {
        System.out.println("PIIIIIIIIIIII");
    }

    public void ligarRadio(String s) {
        System.out.println("Não tenho radio!");
    }

    @Override
    public void ligarMotor() {
        System.out.println("VRUM");
    }

    public void buzinar(String s, int x) {
        System.out.println(s);
    }

}
