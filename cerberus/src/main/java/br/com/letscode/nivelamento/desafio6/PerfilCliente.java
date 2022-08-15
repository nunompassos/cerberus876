package br.com.letscode.nivelamento.desafio6;

import java.util.ArrayList;
import java.util.List;

public abstract class PerfilCliente {

    List<Investimento> carteiraInvestimentos = new ArrayList<Investimento>();

    public List<Investimento> getCarteiraInvestimentos() {
        return carteiraInvestimentos;        
    }
    
}


class ClienteArrojado extends PerfilCliente {
    public void contratarInvestimento(RendaVariavel investimento) {
        super.carteiraInvestimentos.add(investimento);
    }
}


class ClienteModerado extends PerfilCliente {
    
}


class ClienteConservador extends PerfilCliente {
    public void contratarInvestimento(RendaFixa investimento) {
        super.carteiraInvestimentos.add(investimento);
    }
}
