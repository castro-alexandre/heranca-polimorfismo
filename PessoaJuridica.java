public class PessoaJuridica extends Pessoa {

    private String cnpj;
    private ContaCorrentePJ cc;

    public PessoaJuridica(String nome, String cnpj) {
        super.setNome(nome);
        this.cnpj = cnpj;
    }

    @Override
    public ContaCorrentePJ abreContaCorrente() {
        this.cc = new ContaCorrentePJ(this);
        System.out.printf("Conta corrente de número %d aberta com sucesso.%n", cc.getCodigoConta());
        return this.cc;
    }

    @Override
    public ContaInvestimentoPJ abreContaInvestimento() {
        if (this.cc.isInvestimento()) {
            ContaInvestimentoPJ cio = new ContaInvestimentoPJ(this);
            System.out.println("Nova conta investimento foi criada");
            return cio;
        }
        this.cc.setInvestimento(true);
        System.out.printf("Conta investimento de número %d está ativa.%n", this.cc.getCi().getCodigoConta());
        return this.cc.getCi();
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ContaCorrentePJ getCc() {
        return this.cc;
    }

    public void setCc(ContaCorrentePJ cc) {
        this.cc = cc;
    }
}
