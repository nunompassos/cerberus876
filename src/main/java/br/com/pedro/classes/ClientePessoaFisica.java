package br.com.pedro.classes;

public class ClientePessoaFisica extends Cliente {
    
    private String cpf;
    private EstadoCivil estadoCivil;

    public ClientePessoaFisica(String nome, String cpf, EstadoCivil estadoCivil) throws ClienteException {
        super(nome);
        if (cpf == null) {
            throw new ClienteException("CPF não pode ser null");
        }
        if (estadoCivil == null) {
            throw new ClienteException("Estado Civíl não pode ser null");
        }
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
    }

    public String getCpf() {
        return cpf;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public enum EstadoCivil {
        SOLTEIRO("Solteiro(a)"),
        CASADO("Casado(a)"),
        DIVORCIADO("Divorciado(a)"),
        VIUVO("Viuvo(a)");

        private String estadoCivil;

        private EstadoCivil(String estadoCivil) {
            this.estadoCivil = estadoCivil;
        }

        @Override
        public String toString() {
            return estadoCivil;
        }
    }
}
