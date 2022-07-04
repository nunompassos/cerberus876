package br.com.letscode;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Pessoa p = new Pessoa();
        // p.setNome("João Pedro");
        // p.setIdade(20);
        // p.setGenero(Genero.M);
        // p.setEndereco("Sobradinho-DF");
        // p.setAltura(BigDecimal.valueOf(1.75));
        // p.setPeso(BigDecimal.valueOf(65));
        // p.setEstadoCivil(EstadoCivil.SOLTEIRO);
        Pessoa p = new Pessoa("João Pedro", 20, Genero.M, "Sobradinho-DF", EstadoCivil.SOLTEIRO,
                BigDecimal.valueOf(1.75), BigDecimal.valueOf(65));
    }
}
