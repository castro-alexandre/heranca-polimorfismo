import java.math.BigDecimal;

public abstract class Conta {
    private Pessoa cliente;
    private int codigoConta;
    private BigDecimal saldo;

    public boolean saca(BigDecimal valor) {
        if (valor.compareTo(saldo) == 0 || valor.compareTo(saldo) == -1) {
            this.saldo = this.saldo.subtract(valor);
            return true;
        }
        return false;
    }

    public void deposita(BigDecimal valor) {
        if (valor.compareTo(new BigDecimal("0")) == 1) {
            this.saldo = this.saldo.add(valor);
            System.out.printf("Depósito de %3.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Não é possível fazer um depósito com valor nulo ou negativo.");
        }
    }

    public void transfere(BigDecimal valor, Conta contaDestino) {
        try {
            if (this.saca(valor)) {
                contaDestino.deposita(valor);
                System.out.printf("Transferência de %3.2f para conta %d realizada com sucesso.%n", valor, contaDestino.getCodigoConta());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Pessoa getCliente() {
        return this.cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public int getCodigoConta() {
        return this.codigoConta;
    }

    public void setCodigoConta(int codigoConta) {
        this.codigoConta = codigoConta;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "{" +
            " cliente='" + getCliente() + "'" +
            ", codigoConta='" + getCodigoConta() + "'" +
            ", saldo='" + getSaldo() + "'" +
            "}";
    }

}
