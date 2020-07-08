package cargos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GerenteTest {
    Gerente gerente;

    @Before
    public void setUp() throws Exception {
        gerente = new Gerente("Gustavo");
    }


    @Test
    public void testSalario(){
        double salario = gerente.getSalario();
        assertTrue(4000.0 == salario);
    }

    @Test
    public void testCalculaUmaGratificacaoHoraExtra(){
        gerente.adicionarGratificacaoHoraExtra(10);
        double valor = gerente.calcularValorTotalDasGratificoes();
        assertTrue(valor == 40.0);
    }

    @Test
    public void testCalculaUmaGratificacaoDesempenho(){

        gerente.adicionarGratificacaoDesempenho();
        double valor = gerente.calcularValorTotalDasGratificoes();
        assertTrue(valor == 200.0);
    }

    @Test
    public void testCalculaComDuasGratificacoesDiferentes(){

        gerente.adicionarGratificacaoDesempenho();
        gerente.adicionarGratificacaoHoraExtra(10);
        double valor = gerente.calcularValorTotalDasGratificoes();

        assertTrue(valor == 240.0);
    }

    @Test
    public void testCalculaGratificacaoSemNenhumaGratificacao(){
        double valor = gerente.calcularValorTotalDasGratificoes();
        assertTrue(valor == 0.0);
    }

    @After
    public void tearDown() throws Exception {

    }
}