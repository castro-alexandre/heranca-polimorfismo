import java.math.BigDecimal;

public class ContaCorrentePJ extends Conta implements Investimento {

    private static int numClientes = 0;
    private boolean investimento;
    private ContaInvestimentoPJ ci;
    final private BigDecimal TAXA = new BigDecimal("0.005");

    public ContaCorrentePJ() {}
    
    public ContaCorrentePJ (PessoaJuridica cliente) {
        super.setCliente(cliente);
        super.setCodigoConta(++ContaCorrentePJ.numClientes);
        super.setSaldo(new BigDecimal("0"));
        this.ci = new ContaInvestimentoPJ(cliente);
    }
    
    @Override
    public boolean saca(BigDecimal valor) {
        BigDecimal valorCorrigido = valor.multiply(new BigDecimal("1").add(TAXA));
        if (valorCorrigido.compareTo(super.getSaldo()) == 0 || valorCorrigido.compareTo(super.getSaldo()) == -1) {
            super.setSaldo(super.getSaldo().subtract(valorCorrigido));
            Banco.setSaldo(Banco.getSaldo().add(valor.multiply(TAXA)));
            return true;
        }
        return false;
    }

    @Override
    public void investe(BigDecimal valor) {
        super.transfere(valor, this.ci);
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

    public ContaInvestimentoPJ getCi() {
        return this.ci;
    }

    public void setCi(ContaInvestimentoPJ ci) {
        this.ci = ci;
    }

    public BigDecimal getTAXA() {
        return this.TAXA;
    }

}
