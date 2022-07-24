package Cliente;

import java.math.BigDecimal;

import TiposDeAplicacoes.Acao;
import TiposDeAplicacoes.FundoImobiliario;

public class Arrojado extends PerfilCliente {
    private String perfil;
    BigDecimal saldo = new BigDecimal("0");

    public Arrojado(String nome) {
        super(nome);
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public BigDecimal investirAcao(BigDecimal valor) {
        Acao acao = new Acao();
        saldo = acao.investirAcao(valor);
        return saldo;
    }

    public BigDecimal investirFundoImobiliario(BigDecimal valor) {
        FundoImobiliario fi = new FundoImobiliario();
        saldo = fi.investirFundoImobiliario(valor);
        return saldo;
    }
}
