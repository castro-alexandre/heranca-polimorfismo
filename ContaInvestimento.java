import java.math.BigDecimal;

public class ContaInvestimento extends Conta {
    
    private static int numClientes = 0;
    final private static BigDecimal TAXA_RENDIMENTO = new BigDecimal("1");

    public ContaInvestimento(PessoaFisica cliente) {
        super.setCliente(cliente);
        super.setCodigoConta(++ContaInvestimento.numClientes);
        super.setSaldo(new BigDecimal("0"));
    }

    public BigDecimal rendimento() {
        BigDecimal resultado = super.getSaldo().multiply(TAXA_RENDIMENTO);
        return resultado;
    }

    public static BigDecimal getTaxaRendimento() {
        return TAXA_RENDIMENTO;
    }
}
