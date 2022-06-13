import java.math.BigDecimal;

public class Banco {
    
    private static BigDecimal saldo = new BigDecimal("0");

    public static BigDecimal getSaldo() {
        return saldo;
    }

    public static void setSaldo(BigDecimal saldo) {
        Banco.saldo = saldo;
    }
}
