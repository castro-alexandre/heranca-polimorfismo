import java.math.BigDecimal;

public class ContaPoupanca extends Conta implements Investimento {
    
    private static int numClientes = 0;
    final private BigDecimal TAXA_RENDIMENTO = new BigDecimal("0.005");

    public ContaPoupanca(PessoaFisica cliente) {
        super.setCliente(cliente);
        super.setCodigoConta(++ContaPoupanca.numClientes);
        super.setSaldo(new BigDecimal("0"));
    }

    @Override
    public void investe(BigDecimal valor) {
        super.setSaldo(valor);
    }

    public BigDecimal rendimento() {
        BigDecimal resultado = super.getSaldo().multiply(TAXA_RENDIMENTO);
        return resultado;
    }
}
