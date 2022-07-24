package Cliente;
public abstract class PerfilCliente {
    private String nome;

    public PerfilCliente(String nome){
        this.nome = nome;
    }

    public String getNome() {
      return nome;
    }
  
    public void setNome(String nome) {
      this.nome = nome;
    }
  
    @Override
    public String toString() {
      return this.nome;
    }
}
