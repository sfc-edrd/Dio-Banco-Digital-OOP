package local.lab.learning.dio.BancoDigitalOOP.entidades;

import javax.naming.directory.InvalidSearchFilterException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cliente
{
    private String nome;

    public Cliente(String nome)
    {
        this.nome = nome.trim();
    }

    public String obterNome()
    {
        return (nome);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return obterNome().equals(cliente.obterNome());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this);
    }

    @Override
    public String toString()
    {
        return (String.format("Cliente:\t\t%s", nome));
    }
}
