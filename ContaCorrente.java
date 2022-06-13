import java.math.BigDecimal;

public class ContaCorrente extends Conta implements Investimento {

    private static int numClientes = 0;
    private boolean poupanca;
    private boolean investimento;
    private ContaPoupanca cp;
    private ContaInvestimento ci;

    public ContaCorrente(PessoaFisica cliente) {
        super.setCliente(cliente);
        super.setCodigoConta(++ContaCorrente.numClientes);
        super.setSaldo(new BigDecimal("0"));
        cp = new ContaPoupanca(cliente);
        ci = new ContaInvestimento(cliente);
    }

    @Override
    public void investe(BigDecimal valor) {
        super.transfere(valor, this.ci);
    }

    public boolean isPoupanca() {
        return this.poupanca;
    }

    public boolean getPoupanca() {
        return this.poupanca;
    }

    public void setPoupanca(boolean poupanca) {
        this.poupanca = poupanca;
    }

    public boolean isInvestimento() {
        return this.investimento;
    }

    public boolean getInvestimento() {
        return this.investimento;
    }

    public void setInvestimento(boolean investimento) {
        this.investimento = investimento;
    }

    public ContaPoupanca getCp() {
        return this.cp;
    }

    public void setCp(ContaPoupanca cp) {
        this.cp = cp;
    }

    public ContaInvestimento getCi() {
        return this.ci;
    }

    public void setCi(ContaInvestimento ci) {
        this.ci = ci;
    }    
}
