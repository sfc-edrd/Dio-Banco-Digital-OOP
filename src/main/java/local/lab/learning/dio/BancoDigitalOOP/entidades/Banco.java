package local.lab.learning.dio.BancoDigitalOOP.entidades;

import javax.naming.directory.InvalidSearchFilterException;
import java.util.HashSet;
import java.util.Set;

public class Banco
{
    private String nome;
    private static Set<Conta> contasDoBanco;

    public Banco(String nome)
    {
        this.nome = nome;
        contasDoBanco = new HashSet<>();
    }

    public String obterNome()
    {
        return (nome);
    }

    public Set<Conta> obterTodasAsContas()
    {
        return (contasDoBanco);
    }

    public Conta obterContaPorAgenciaENumero(int agencia, int numero)
            throws InvalidSearchFilterException
    {
        return (contasDoBanco.stream()
                .filter(c -> c.obterAgencia() == agencia && c.obterConta() == numero)
                .findFirst()
                .orElseThrow(() -> new InvalidSearchFilterException("Conta nao localizada")));
    }

    public void adicionarConta(Conta conta)
    {
        contasDoBanco.add(conta);
    }

    public void removerConta(Conta conta)
            throws InvalidSearchFilterException
    {
        contasDoBanco.remove(obterContaPorAgenciaENumero(conta.obterAgencia(), conta.obterConta()));
    }
}