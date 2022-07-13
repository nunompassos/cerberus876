package br.com.letscode;

public interface Veiculo {

    String TIPO_DE_VEICULO = "Terrestre";

    void buzinar();

    void ligarRadio(String s);

    void ligarMotor();

    default void andar(int km) {
        System.out.println("Andei " + km + " km!");
    }

}
