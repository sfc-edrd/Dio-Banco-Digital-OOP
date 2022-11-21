package local.lab.learning.dio.BancoDigitalOOP.entidades;

import java.lang.ref.Cleaner;
import java.util.Objects;

public abstract class Conta
{
    protected static final int AGENCIA_DEFAULT = 2761;
    protected static int AUTO_INCREMENTADOR_CONTA = 1;

    protected int agencia;
    protected int conta;
    protected double saldo;

    protected Cliente cliente;

    public Conta()
    {
        agencia = AGENCIA_DEFAULT;
        conta = AUTO_INCREMENTADOR_CONTA++;
        saldo = 0;
        this.cliente = null;
    }

    public void sacar(double valor)
    {
        System.out.printf("Realizando saque no valor: R$%.2f", valor);
        System.out.printf("Saldo atual da conta: %.2f", saldo);
        if (valor <= saldo && valor > 0)
        {
            this.saldo -= valor;
            System.out.printf("Novo Saldo atual da conta: %.2f", saldo);
            return ;
        }
        System.out.printf("Valor solicitado menor ou igual a zero ou saldo insuficiente");
    }

    public void depositar(double valor)
    {
        System.out.printf("Realizando deposito no valor: R$%.2f", valor);
        System.out.printf("Saldo atual da conta: %.2f", saldo);
        if (valor > 0)
        {
            this.saldo += valor;
            System.out.printf("Novo Saldo atual da conta: %.2f", saldo);
            return ;
        }
        System.out.printf("Valor depositado menor ou igual a zero");

    }

    public void transferir(double valor, Conta contaDestino)
    {
        System.out.printf("Realizando tranferencia no valor: R$%.2f", valor);
        System.out.printf("Agencia de destino: %d", contaDestino.obterAgencia());
        System.out.printf("Conta de destino: %d", contaDestino.obterAgencia());
        System.out.printf("Saldo atual da conta de destino: %s", contaDestino.obterSaldo());
        if (this.saldo >= valor)
        {
            sacar(valor);
            contaDestino.depositar(valor);
            System.out.printf("Novo saldo da conta de destino: %s", contaDestino.obterSaldo());
            return ;
        }
        System.out.printf("Saldo insuficiente para a movimentação");
    }

    public int obterAgencia()
    {
        return (agencia);
    }

    public int obterConta()
    {
        return (conta);
    }

    public String obterSaldo()
    {
        return (String.format("%.2f", saldo));
    }

    public void associarClienteAConta(Cliente cliente)
    {
        if (Objects.isNull(obterClienteAssociado()))
        {
            this.cliente = cliente;
            System.out.printf("Cliente associado com sucesso");
            return ;
        }
        System.out.printf("Conta já associada ao cliente: ", cliente.obterNome());
    }

    public Cliente obterClienteAssociado()
    {
        return (cliente);
    }

    public String imprimirExtrato()
    {
        StringBuilder ret;

        ret = new StringBuilder();
        ret.append(String.format("\n+=== Extrato de Conta %s === \n", obterTipoDeConta(this.getClass().getName())));
        ret.append(String.format("| Agencia:\t\t%d\n" ,obterAgencia()));
        ret.append(String.format("| Conta:\t\t%d\n", obterConta()));
        ret.append(String.format("| Saldo:\t\t%s\n", obterSaldo()));
        ret.append(String.format("| %s\n", cliente));
        ret.append(String.format("+================================+\n"));

        return (ret.toString());
    }

    private String obterTipoDeConta(String className)
    {
        if (className.toLowerCase().contains("corrente"))
            return ("Corrente");
        if (className.toLowerCase().contains("poupanca"))
            return ("Poupanca");
        throw new IllegalArgumentException("Tipo de conta desconhecido");
    }
}
