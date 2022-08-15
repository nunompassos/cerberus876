package br.com.letscode.nivelamento;

public class DescontoProgressivo {

    public static void main(String[] args) {
        Pedido pedido = new Pedido(10);
    
        Double descontoConcedido = pedido.calcularDesconto();

        String msg = String.format("Quantidade de itens no pedido: %d.\nDesconto concedido: %.2f %%.",
                                     pedido.getItens(), descontoConcedido * 100);
        System.out.println(msg);
    }

}

class Pedido {

    private int itens;

    public Pedido(int itens) {
        this.itens = itens;
    }

    public int getItens() {
        return itens;
    }

    public Double calcularDesconto() {
        Double desconto;
            if (this.itens < 5) {
                desconto = 0.00;
            } else if (this.itens < 10) {
                desconto = 0.05;
            } else if (this.itens < 15) {
                desconto = 0.08;
            } else {
                desconto = 0.10;
            }
        return desconto;
    }
}
