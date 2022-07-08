package br.com.letscode;

import br.com.letscode.model.Aluno;
import br.com.letscode.model.EstadoCivil;
import br.com.letscode.model.Professor;
import br.com.letscode.model.Sexo;

public class App
{
    public static void main(String[] args) {

        // System.out.println("Hello, world! Vamos cadastrar você. Vem cá...");

        // System.out.print("Nome: ");
        // String nome = new Scanner(System.in).nextLine();
        // System.out.print("Idade: ");
        // Integer idade = new Scanner(System.in).nextInt();
        // System.out.println("Sexo: 1 - Feminino | 2 - Masculino");
        

        Aluno aluno = new Aluno("Creiton", 33, Sexo.MASCULINO, "endereco", 
        EstadoCivil.SOLTEIRO, 1.75, 82.0, 123456, 2022, 6);

        Professor professor = new Professor("mestre kami", 358);

        professor.matricular();
        professor.iniciarAula();
        professor.partiuRecreio();

        System.out.println("\n\n");
        
        // System.out.println(aluno.toString());

        aluno.matricular();
        aluno.iniciarAula();
        aluno.partiuRecreio();
    }

}
