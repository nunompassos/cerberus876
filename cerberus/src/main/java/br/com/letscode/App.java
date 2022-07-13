package br.com.letscode;

public class App 
{
    public static void main( String[] args )
    {
        Professor professor = new Professor("Nuno", "Portugal");
        Aluno aluno = new Aluno("Albert Einstein");

        professor.prepararMaterial();
        aluno.prepararMaterial();
        System.out.println();

        professor.chegarAEscola();
        aluno.chegarAEscola();
        System.out.println();

        String materia = "Física";
        professor.comecarAula(materia);
        aluno.comecarAula(materia);
        System.out.println();

        professor.marcarPresenca();
        aluno.marcarPresenca();
        System.out.println();


    }
}
