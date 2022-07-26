package br.com.letscode.aula6.bancario;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import br.com.letscode.aula6.bancario.contas.ContaSacavel;

public class ServicoSacarAppBancaria {
    private final Map<Integer, ContaSacavel> contas = new HashMap<>();

    public Integer adicionarConta(ContaSacavel conta) {
        Integer numeroConta = contas
            .keySet()
            .stream()
            .max(Comparator.naturalOrder())
            .orElse(0) + 1;
        contas.put(numeroConta, conta);
        return numeroConta;
    }

    public BigDecimal sacarConta(Integer numeroConta, BigDecimal valor) {
        return contas.get(numeroConta).sacar(valor);
    }


}
