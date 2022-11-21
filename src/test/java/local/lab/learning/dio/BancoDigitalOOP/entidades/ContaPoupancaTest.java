package local.lab.learning.dio.BancoDigitalOOP.entidades;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContaPoupancaTest
{
    Conta conta1;
    Cliente cliente1;
    Conta conta2;
    Cliente cliente2;

    public ContaPoupancaTest()
    {
        cliente1 = new Cliente("   Ramon Perez   ");
//        conta1 = new ContaPoupanca(cliente1);
        cliente2 = new Cliente("   Iggor Lopez   ");
//        conta2 = new ContaPoupanca(cliente2);

    }

    @Order(1)
    @Test
    @DisplayName("Testa criaçao de conta Poupanca")
    void testeContaPoupanca()
    {
        assertEquals("0.00", conta1.obterSaldo());
        assertTrue(conta1.imprimirExtrato().toLowerCase().contains("poupanca"));
    }

    @Order(2)
    @Test
    @DisplayName("Testa a operação de deposito")
    void testeDepositoContaPoupanca()
    {
        conta1.depositar(100);
        assertEquals("100.00", conta1.obterSaldo());
    }

    @Order(3)
    @Test
    @DisplayName("Testa a operação de saque")
    void testeSaqueContaPoupanca()
    {
        conta1.sacar(50);
        assertEquals("50.00", conta1.obterSaldo());
    }

    @Order(4)
    @Test
    @DisplayName("Testa a operação de transferencia")
    void testeTransferenciaContaPoupanca()
    {
        conta2.depositar(50);
        conta1.transferir(20, conta2);

        assertEquals("70.00", conta2.obterSaldo());
        assertEquals("30.00", conta1.obterSaldo());
    }
}