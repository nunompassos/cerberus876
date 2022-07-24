package Cliente;

import java.math.BigDecimal;

import TiposDeAplicacoes.Tesouro;

public class Moderado extends PerfilCliente {
    private String perfil;
    BigDecimal saldo = new BigDecimal("0");

    public Moderado(String nome) {
        super(nome);
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public BigDecimal investirTesouro(BigDecimal valor) {
        Tesouro tesouro = new Tesouro();
        tesouro.investirTesouro(valor);
        return saldo;
    }
}
