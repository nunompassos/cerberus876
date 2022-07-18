package br.com.letscode;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Veiculo automovel = new Automovel();
        Veiculo mota = new Mota();
        System.out.println(usadoOuNovo(mota.getIsUsed()));
        mota.usouUmaVez();
        mota.giraAChave();
        System.out.println(usadoOuNovo(mota.getIsUsed()));
        mota.acelera();
        System.out.println();
        System.out.println(usadoOuNovo(automovel.getIsUsed()));
        automovel.usouUmaVez();
        automovel.giraAChave();
        System.out.println(usadoOuNovo(automovel.getIsUsed()));
        automovel.acelera();
    }

    static String usadoOuNovo(boolean bool) {
        return bool ? "Usado" : "Novo";
    }
}
