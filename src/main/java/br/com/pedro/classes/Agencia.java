package br.com.pedro.classes;

import java.util.HashMap;
import java.util.Map;

public class Agencia {

    private int numeroAgencia;
    private String nomeAgencia;
    private Map<Integer, Conta> contas = new HashMap<>();
    private static Map<Integer, Agencia> agencias = new HashMap<>();

    public Agencia(int numeroAgencia, String nomeAgencia) throws AgenciaException {
        if (numeroAgencia < 1) {
            throw new AgenciaException("Número da agência precisa ser maior que zero");
        }
        if (nomeAgencia == null) {
            throw new AgenciaException("Nome da agência não pode ser null");
        }
        if (Agencia.agenciaExiste(numeroAgencia)) {
            throw new AgenciaException("Agencia já existente");
        }
        this.numeroAgencia = numeroAgencia;
        this.nomeAgencia = nomeAgencia;
        Agencia.agencias.put(numeroAgencia, this);
    }

    public static Agencia getAgencia(int numeroAgencia) {
        return agencias.get(numeroAgencia);
    }

    public static boolean agenciaExiste(int numeroAgencia) {
        return agencias.containsKey(numeroAgencia);
    }

    public void adicionarConta(Conta conta) {
        this.contas.put(conta.getNumeroConta(), conta);
    }

    public boolean contaExiste(int numeroConta) {
        return contas.containsKey(numeroConta);
    }

    public Conta getConta(int numeroConta) {
        return this.contas.get(numeroConta);
    }

    public int getNumero() {
        return numeroAgencia;
    }

    public void setNumero(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNome() {
        return nomeAgencia;
    }

    public void setNome(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    @Override
    public String toString() {
        return "Agência: " + this.numeroAgencia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomeAgencia == null) ? 0 : nomeAgencia.hashCode());
        result = prime * result + numeroAgencia;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Agencia other = (Agencia) obj;
        if (nomeAgencia == null) {
            if (other.nomeAgencia != null)
                return false;
        } else if (!nomeAgencia.equals(other.nomeAgencia))
            return false;
        if (numeroAgencia != other.numeroAgencia)
            return false;
        return true;
    }
}
