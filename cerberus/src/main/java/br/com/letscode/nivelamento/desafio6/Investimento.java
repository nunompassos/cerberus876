package br.com.letscode.nivelamento.desafio6;

public interface Investimento {

}


abstract class RendaFixa implements Investimento {

}

class Tesouro extends RendaFixa {

}

class CDB extends RendaFixa {
    
}


abstract class RendaVariavel implements Investimento {
    
}

class Acao extends RendaVariavel {

}

class FundoImobiliario extends RendaVariavel {
    
}
