package Cliente;

import java.math.BigDecimal;

import TiposDeAplicacoes.CDB;
import TiposDeAplicacoes.Tesouro;

public class Conservador extends PerfilCliente {
    private String perfil;
    BigDecimal saldo = new BigDecimal("0");

    public Conservador(String nome) {
        super(nome);
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public BigDecimal investirCDB(BigDecimal valor) {
        CDB cdb = new CDB();
        saldo = cdb.investirCDB(valor);
        return saldo;
    }

    public BigDecimal investirTesouro(BigDecimal valor) {
        Tesouro tesouro = new Tesouro();
        tesouro.investirTesouro(valor);
        return saldo;
    }

}
