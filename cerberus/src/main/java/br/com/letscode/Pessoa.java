package br.com.letscode;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Pessoa implements Cloneable, Serializable, Comparable<Pessoa> {

    private String nome;
    private String apelido;
    private int cpf;
    private final LocalDateTime dataNascimento;

    public Pessoa(final String _nome, final String _apelido, final LocalDateTime _dataNascimento) {
        this.nome = _nome;
        this.apelido = _apelido;
        if (_dataNascimento.isAfter(LocalDateTime.now())) {
            throw new InvalidParameterException();
        }
        this.dataNascimento = _dataNascimento;
    }

    public String getNomeCompleto() {
        return nome + apelido;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public long getIdade() {
        return Duration
            .between(this.dataNascimento, LocalDateTime.now())
            .get(ChronoUnit.YEARS);
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public int getCpf() {
        return cpf;
    }

    protected void criarCartão(int _cpf) {
        if (this.cpf != 0) {
            throw new InvalidParameterException();
        }
        this.cpf = _cpf;
    }

    public Pessoa clone() throws CloneNotSupportedException {
        return (Pessoa) super.clone();
    }

    public Pessoa criarClone() throws CloneNotSupportedException {
        return this.clone();
    }

    @Override
    public String toString() {
        return "Eu chamo-me " + this.nome + " " + this.apelido + " e tenho " + this.getIdade() + " anos."
            + (this.cpf != 0 ? " O meu CPF é: " + this.cpf : "");
    }

    @Override
    public int compareTo(Pessoa o) {
        return this.nome.compareTo(o.getNomeCompleto());
    }
}