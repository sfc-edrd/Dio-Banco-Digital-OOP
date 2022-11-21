package local.lab.learning.dio.BancoDigitalOOP.entidades;

import org.junit.jupiter.api.*;

import javax.naming.directory.InvalidSearchFilterException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BancoTest
{
    Banco banco;
    Conta conta;
    Cliente cliente;

    public BancoTest()
    {
        banco = new Banco("Itaú");
        conta = new ContaCorrente();
        cliente = new Cliente("Edimilson Ávila");
    }

    @Test
    @Order(1)
    @DisplayName("Testa a adição de conta ao banco")
    void adicionarConta()
    {
        assertTrue(banco.obterTodasAsContas().isEmpty());
        banco.adicionarConta(conta);
        assertTrue(!banco.obterTodasAsContas().isEmpty());
    }

    @Test
    @Order(2)
    @DisplayName("Testa lista de contas do banco")
    void obterTodasAsContas()
    {
        assertTrue(banco.obterTodasAsContas().contains(conta));
        assertTrue(banco.obterTodasAsContas().size() == 1);
    }

    @Test
    @Order(3)
    @DisplayName("Testa obtençao de contas do banco por Agencia e Numero")
    void obterContaPorAgenciaENumero()
    {
        assertDoesNotThrow(() -> banco.obterContaPorAgenciaENumero(conta.obterAgencia(), conta.obterConta()));
        assertThrows(InvalidSearchFilterException.class, () -> banco.obterContaPorAgenciaENumero(999, conta.obterConta()));
    }

    @Test
    @Order(4)
    @DisplayName("Testa remocao da conta do banco")
    void removerConta()
    {
        assertDoesNotThrow(() -> banco.removerConta(conta));
        assertTrue(banco.obterTodasAsContas().isEmpty());
    }
}