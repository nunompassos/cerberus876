package br.com.letscode.nivelamento;

public class Sorveteria {
    
    public static void main(String[] args) {
        Sorveteria fabrica = new Sorveteria();
        
        final Sorvete massaNoCopoMorango = fabrica.criarSorvete(TipoSorvete.COPO, "Morango");
        final Sorvete palitoChocolate = fabrica.criarSorvete(TipoSorvete.PALITO, "Chocolate");
        final Sorvete massaNaCasquinhaBaunilha = fabrica.criarSorvete(TipoSorvete.CONE, "Baunilha");
        
        massaNoCopoMorango.degustar();
        palitoChocolate.degustar();
        massaNaCasquinhaBaunilha.degustar();
    }
    
    public Sorvete criarSorvete(TipoSorvete tipoSorvete, String sabor) {
        return new Sorvete(tipoSorvete, sabor);
    }
}

enum TipoSorvete {
    COPO,
    PALITO,
    CONE;
}

class Sorvete {

    private TipoSorvete tipoSorvete;
    private String sabor;

    public Sorvete(TipoSorvete tipoSorvete, String sabor) {
        this.tipoSorvete = tipoSorvete;
        this.sabor = sabor;
    }

    public void degustar() {
        System.out.println("Este sorvete de massa no " + this.tipoSorvete + " é do sabor de " + this.sabor + ".");
    }

}


