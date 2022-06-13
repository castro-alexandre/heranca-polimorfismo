import java.math.BigDecimal;

public class ContaInvestimentoPJ extends ContaCorrentePJ {
    
    private static int numClientes = 0;
    final private BigDecimal TAXA_RENDIMENTO = ContaInvestimento
                                                        .getTaxaRendimento()
                                                        .add(new BigDecimal("0.02"));

    public BigDecimal getTaxaRendimento() {
        return TAXA_RENDIMENTO;
    }

    public ContaInvestimentoPJ (PessoaJuridica cliente) {
        super.setCliente(cliente);
        super.setCodigoConta(++ContaInvestimentoPJ.numClientes);
        super.setSaldo(new BigDecimal("0"));
    }

    @Override
    public BigDecimal getSaldo() {
        BigDecimal resultado = super.getSaldo().multiply(TAXA_RENDIMENTO);
        return resultado;
    }
}
