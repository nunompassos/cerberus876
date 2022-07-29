package br.com.letscode.aula7;

public class DesenvolvedorReact implements DesenvolvedorFE{
    @Override
    public void programar(int horas) {
        System.out.println("Escrevi código React durante " + horas + " horas");
    }

    @Override
    public void desenhaEcra() {
        System.out.println("Estou a desenhar um ecrã");
    }
}
