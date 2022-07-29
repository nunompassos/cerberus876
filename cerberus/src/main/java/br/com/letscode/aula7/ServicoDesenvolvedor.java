package br.com.letscode.aula7;

public class ServicoDesenvolvedor {

    Desenvolvedor desenvolvedor;

    public ServicoDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public void desenvolvedorATrabalhar(){
        desenvolvedor.programar(4);
    }
}
