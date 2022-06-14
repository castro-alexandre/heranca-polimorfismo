public class PessoaFisica extends Pessoa implements AbrirConta {

    private String cpf;
    private ContaCorrente cc;

    public PessoaFisica(String nome, String cpf) {
        super.setNome(nome);
        this.cpf = cpf;
    }

    @Override
    public ContaCorrente abreContaCorrente() {
        this.cc = new ContaCorrente(this);
        System.out.printf("Conta corrente de número %d aberta com sucesso.%n", cc.getCodigoConta());
        return this.cc;
    }

    public ContaPoupanca abreContaPoupanca() {
        if (this.cc.isPoupanca()) {
            ContaPoupanca cpo = new ContaPoupanca(this);
            System.out.println("Nova conta poupanca foi criada");
            return cpo;
        }
        this.cc.setPoupanca(true);
        System.out.printf("Conta poupança de número %d está ativa.%n", this.cc.getCp().getCodigoConta());
        return this.cc.getCp();
    }

    @Override
    public ContaInvestimento abreContaInvestimento() {
        if (this.cc.isInvestimento()) {
            ContaInvestimento cio = new ContaInvestimento(this);
            System.out.println("Nova conta investimento foi criada");
            return cio;
        }
        this.cc.setInvestimento(true);
        System.out.printf("Conta investimento de número %d está ativa.%n", this.cc.getCi().getCodigoConta());
        return this.cc.getCi();
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ContaCorrente getCc() {
        return this.cc;
    }

    public void setCc(ContaCorrente cc) {
        this.cc = cc;
    }
}
