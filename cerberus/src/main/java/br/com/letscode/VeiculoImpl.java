package br.com.letscode;

import java.util.Objects;

public class VeiculoImpl implements Veiculo, Pessoa {
    private String cor;
    private int potencia;
    private int ano;
    private TipoVeiculo tipo;
    private Marca marca;
    private String modelo;
    private int numeroRodas;
    private String placa;

    public VeiculoImpl() {

    }

    public VeiculoImpl(String cor, int potencia, int ano, TipoVeiculo tipo, Marca marca, String modelo, int numeroRodas, String placa) {
        this.cor = cor;
        this.potencia = potencia;
        this.ano = ano;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroRodas = numeroRodas;
        this.placa = placa;
    }

    public int getNumeroRodas() {
        return this.numeroRodas;
    }

    public void setNumeroRodas(int numeroRodas) {
        if (numeroRodas < 1 ) {
            System.out.println("Numero inválido");
            return;
        }
        if (this.tipo != null) {
            if (this.tipo.getMinRodas() > numeroRodas || this.tipo.getMaxRodas() < numeroRodas) {
                System.out.println("Número de rodas inválido para o tipo de veiculo:");
                System.out.println(this.tipo + ": entre " + this.tipo.minRodas + " e " + this.tipo.maxRodas + " rodas!");
                return;
            }
        }
        this.numeroRodas = numeroRodas;
    }

    public String getCor() {
        return cor;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getAno() {
        return ano;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setTipo(TipoVeiculo tipo) {
        if (this.numeroRodas > 0) {
            if (tipo.minRodas > this.numeroRodas || tipo.maxRodas < this.numeroRodas) {
                System.out.println("O tipo de veiculo não é válido para o número de rodas definidas");
                System.out.println(this.numeroRodas + " rodas definidas, o tipo " + tipo + " permite entre " + tipo.getMinRodas() + " e " + tipo.getMaxRodas() + " rodas!");
                return;
            }
        }
        this.tipo = tipo;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    void ligarRadio() {
        System.out.println("A tocar musica");
    }
    public final void buzinar() {
        System.out.println("AAAAAAAAAAAAAAAA");
    }

    @Override
    public void ligarRadio(String s) {

    }

    @Override
    public void ligarMotor() {

    }

    public void buzinar(String s, int x) {
        System.out.println(s);
    }

    public void buzinar(int x, String s) {

    }

    @Override
    public void andar(int km) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VeiculoImpl veiculoImpl = (VeiculoImpl) o;
        return potencia == veiculoImpl.potencia &&
            ano == veiculoImpl.ano &&
            numeroRodas == veiculoImpl.numeroRodas &&
            Objects.equals(cor, veiculoImpl.cor) &&
            Objects.equals(tipo, veiculoImpl.tipo) &&
            Objects.equals(modelo, veiculoImpl.modelo) &&
            Objects.equals(placa, veiculoImpl.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cor, potencia, ano, tipo, modelo, numeroRodas, placa);
    }

    public enum Marca {
        BMW,
        MERCEDES,
        FORD,
        RENAULT,
        TESLA,
        VW;
    }

    public enum TipoVeiculo {
        MOTA (2, 3),
        AUTOMOVEL(4, 4),
        ONIBUS(4, 6);

        private int minRodas;
        private int maxRodas;

        TipoVeiculo(int minRodas, int maxRodas) {
            this.minRodas = minRodas;
            this.maxRodas = maxRodas;
        }

        public int getMinRodas() {
            return minRodas;
        }

        public void setMinRodas(int minRodas) {
            this.minRodas = minRodas;
        }

        int getMaxRodas() {
            return maxRodas;
        }
    }
}

