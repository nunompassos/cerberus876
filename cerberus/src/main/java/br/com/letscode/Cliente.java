package br.com.letscode;

public abstract class Cliente {

    private int descontoDiaria;
    private int minimoDias;

    public Cliente(int descontoDiaria, int minimoDias) {
        this.descontoDiaria = descontoDiaria;
        this.minimoDias = minimoDias;
    }

    public int getDescontoDiaria() {
        return descontoDiaria;
    }

    public int getMinimoDias() {
        return minimoDias;
    }

}
