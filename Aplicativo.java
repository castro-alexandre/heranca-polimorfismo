// Para que fiquem claras as respostas, haverá um comentário explicativo
// anterior às declarações dos comandos.

import java.math.BigDecimal;

public class Aplicativo {

    public static void main(String[] args) {
        
        // É possível criar dois tipos de pessoas. Pessoa física e pessoa jurídica
        System.out.println("É possível criar dois tipos de pessoas. Pessoa física e pessoa jurídica");
        PessoaFisica cliente1 = new PessoaFisica("Francisco Alexandre de Melo Castro", "1234");
        PessoaJuridica cliente2 = new PessoaJuridica("Lets Code", "4321");
        
        // Os clientes podem abrir conta
        System.out.println("Os clientes podem abrir conta");
        ContaCorrente cc = cliente1.abreContaCorrente();
        ContaCorrentePJ ccPJ = cliente2.abreContaCorrente();
        System.out.println("");
        
        // Testemos o DEPÓSITO nas contas
        System.out.println("Testemos o DEPÓSITO nas contas");
        cc.deposita(new BigDecimal("1000"));
        ccPJ.deposita(new BigDecimal("10000"));
        System.out.println("");

        // não é possível fazer depósitos negativos
        System.out.println("não é possível fazer depósitos negativos");
        cc.deposita(new BigDecimal("-10"));
        ccPJ.deposita(new BigDecimal("-10"));
        System.out.println("");

        // Obtendo o SALDO de cada conta
        System.out.println("Obtendo o SALDO de cada conta");
        System.out.printf("Conta corrente de %s com saldo = %3.2f.%n", cc.getCliente().getNome(), cc.getSaldo());
        System.out.printf("Conta corrente de %s com saldo = %3.2f.%n", ccPJ.getCliente().getNome(), ccPJ.getSaldo());
        System.out.println("");

        // Testando o saque e conferindo as taxas diferentes para PF e PJ
        System.out.println("Testando o saque e conferindo as taxas diferentes para PF e PJ");
        cc.saca(new BigDecimal("100"));
        System.out.printf("Depois de um saque de 100 reais na cc de PF, o novo saldo = %3.2f.%n", cc.getSaldo());
        ccPJ.saca(new BigDecimal("1000"));
        System.out.printf("Depois de um saque de 1000 reais na cc de PJ, o novo saldo = %3.2f.%n", ccPJ.getSaldo());
        System.out.printf("O saldo de 8995 resulta da taxa de 0,5%s sobre o saque.%n%n", '%');

        // Testando a transferência de 1000 reais da conta PJ para conta PF
        System.out.println("Testando a transferência de 1000 reais da conta PJ para conta PF");
        ccPJ.transfere(new BigDecimal("1000"), cc);
        System.out.printf("O saldo da cc PF = %3.2f.%n", cc.getSaldo());
        System.out.printf("e o sado da ccPJ = %3.2f.%n", ccPJ.getSaldo());
        System.out.println("este saldo também prova a taxação para transferência em conta de PJ");
        System.out.println("Implementei adicionalmente que o valor taxado vai para um atributo estático da classe Banco.");
        System.out.printf("logo o saldo sobre movimentação financeira em contas PF = %3.2f.%n%n", Banco.getSaldo());

        // Testando a abertura de contas poupança e investimento para pessoa física.
        System.out.println("Testando a abertura de contas poupança e investimento para pessoa física.");
        ContaPoupanca cp = cliente1.abreContaPoupanca();
        ContaInvestimento ci = cliente1.abreContaInvestimento();
        System.out.println(cp);
        System.out.println(ci);
        System.out.println("");

        // Testando a possibilidade de abertura de conta investimento
        // e a impossibilidade de abertura de conta poupança por PJ
        System.out.println("Testando a possibilidade de abertura de conta investimento e a impossibilidade de abertura de conta poupança por PJ");
        ContaInvestimentoPJ cij = cliente2.abreContaInvestimento();
        // ContaPoupanca cpTeste = new ContaPoupanca(cliente2);
        System.out.println(cij);
        System.out.println("");
        
        // Investindo 100 reais na conta investimento. O investimento pode ser realizado pela conta corrente através do método investe,
        // mas pode ser realizado por qualquer conta através de uma transferência normal.
        System.out.println("Investindo 100 reais na conta investimento. O investimento pode ser realizado pela conta corrente através do método investe");
        System.out.println("mas pode ser realizado por qualquer conta através de uma transferência normal.");
        cc.investe(new BigDecimal("100"));
        ccPJ.investe(new BigDecimal("100"));

        // Testando o rendimento das contas investimento para conta investimento PF e conta investimento PJ
        System.out.println("\nTestando o rendimento das contas investimento para conta investimento PF e conta investimento PJ");
        System.out.println(ci.getSaldo());
        System.out.println(cij.getSaldo());
    }
}
