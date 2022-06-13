public abstract class Pessoa {

    private String nome;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract Conta abreContaCorrente();

    public abstract Conta abreContaInvestimento();
}
