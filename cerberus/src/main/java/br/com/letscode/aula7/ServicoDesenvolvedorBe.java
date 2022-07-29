package br.com.letscode.aula7;

public class ServicoDesenvolvedorBe extends ServicoDesenvolvedor{

    public ServicoDesenvolvedorBe(DesenvolvedorBe desenvolvedor) {
        super(desenvolvedor);
    }

    @Override
    public void desenvolvedorATrabalhar(){
        desenvolvedor.programar(4);
    }
}
