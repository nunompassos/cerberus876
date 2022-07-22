package br.com.letscode.nivelamento;

import java.util.Random;

public class Loteamento {
    
    public static void main(String[] args) {
        
        Lotes lotes = new Lotes(5, 5);
        // lotes.mostrarLotes();
        lotes.venderLotes();
        lotes.mostrarLotes();
        lotes.contabilizarLotesVendidos();
        System.out.println(lotes.getLotesVendidos());

    }
}

class Lotes {

    private int[][] lotes;
    private int largura;
    private int comprimento;
    private int lotesVendidos;

    public Lotes(int largura, int comprimento) {
        this.largura = largura;
        this.comprimento = comprimento;
        this.lotes = new int[this.largura][this.comprimento];
        this.lotesVendidos = 0;
    }

    public int getLotesVendidos() {
        return this.lotesVendidos;
    }

    public void mostrarLotes() {
        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.comprimento; j++) {
                System.out.printf(" %d ", lotes[i][j]);
            }
            System.out.println();
        }
    }

    public void venderLotes() {
        Random random = new Random();
        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.comprimento; j++) {
                this.lotes[i][j] = random.nextInt(2);
            }
        }
    }

    public void contabilizarLotesVendidos() {
        for (int i = 0; i < this.largura-1; i++) {
            for (int j = 0; j < this.comprimento-1; j++) {                
                
            }
        }
    }



}
