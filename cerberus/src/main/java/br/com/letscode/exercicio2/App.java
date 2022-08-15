package br.com.letscode.exercicio2;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        
        new QueryBuilder().select().from("tabela_cliente").where("tabela_cliente.nome = Cleberson")
        .and("tabela_cliente.idade > 18").or("tabela_cliente.cidade = barcelona").imprimeQuery();

        System.out.println();

        new Calculadora().adicionar(10.0).subtrair(4.5).multiplicar(0.0).dividir(0.0).imprimeResultado();
    }
    
    
}

class QueryBuilder {

    private String query = "";

    public QueryBuilder select() {
        this.query = query + "SELECT *";
        return this;
    }

    public QueryBuilder from(String table) {
        this.query = query + " FROM " + table;
        return this;
    }

    public QueryBuilder where(String where) {
        this.query = query + " WHERE " + where;
        return this;
    }

    public QueryBuilder and(String and) {
        this.query = query + " AND " + and;
        return this;
    }

    public QueryBuilder or(String or) {
        this.query = query + " OR " + or;
        return this;
    }

    public void imprimeQuery() {
        System.out.println(this.query);
    }
}

class Calculadora {
    private double resultado;
    private String visor = "   0.0";

    public Calculadora adicionar(double numero) {
        this.resultado += numero;
        this.visor = visor + "\n + " + numero;
        return this;
    }

    public Calculadora subtrair(double numero) {
        this.resultado -= numero;
        this.visor = visor + "\n - " + numero;
        return this;
    }

    public Calculadora multiplicar(double numero) {
        this.visor = visor + "\n * " + numero;
        this.resultado *= numero;
        return this;
    }

    public Calculadora dividir(double numero) {
        try {
            this.resultado /= numero;
            this.visor = visor + "\n / " + numero;
        } catch (ArithmeticException e) {
            e.getMessage();
        }
        return this;
    }

    public void imprimeResultado() {
        System.out.println(visor + "\n = " + this.resultado);
    }
}
