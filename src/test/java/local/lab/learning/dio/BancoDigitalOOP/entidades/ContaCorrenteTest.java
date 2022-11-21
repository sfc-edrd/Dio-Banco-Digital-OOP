package local.lab.learning.dio.BancoDigitalOOP.entidades;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContaCorrenteTest
{
    Conta conta1;
    Cliente cliente1;
    Conta conta2;
    Cliente cliente2;

    public ContaCorrenteTest()
    {
        cliente1 = new Cliente("   Ramon Perez   ");
        conta1 = new ContaCorrente();
//        cliente2 = new Cliente("   Iggor Lopez   ");
        conta2 = new ContaCorrente();

    }

    @Order(1)
    @Test
    @DisplayName("Testa criaçao de conta corrente")
    void testeContaCorrente()
    {
        assertEquals("0.00", conta1.obterSaldo());
        assertTrue(conta1.imprimirExtrato().toLowerCase().contains("corrente"));
    }

    @Order(2)
    @Test
    @DisplayName("Testa a operação de deposito")
    void testeDepositoContaCorrente()
    {
        conta1.depositar(100);
        assertEquals("100.00", conta1.obterSaldo());
    }

    @Order(3)
    @Test
    @DisplayName("Testa a operação de saque")
    void testeSaqueContaCorrente()
    {
        conta1.sacar(50);
        assertEquals("50.00", conta1.obterSaldo());
    }

    @Order(4)
    @Test
    @DisplayName("Testa a operação de transferencia")
    void testeTransferenciaContaCorrente()
    {
        conta2.depositar(50);
        conta1.transferir(20, conta2);

        assertEquals("70.00", conta2.obterSaldo());
        assertEquals("30.00", conta1.obterSaldo());
    }

    @Order(5)
    @Test
    @DisplayName("Testa a associação de cliente à conta")
    void testaAssociacaoCliente()
    {
        assertNull(conta1.obterClienteAssociado());
        conta1.associarClienteAConta(cliente1);
        assertNotNull(conta1.obterClienteAssociado());
    }
}