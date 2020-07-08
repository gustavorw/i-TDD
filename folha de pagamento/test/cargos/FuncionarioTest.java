package cargos;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FuncionarioTest {
    Funcionario funcionario;

    @Before
    public void init(){
        funcionario = new Funcionario("Gustavo");
    }

    @Test
    public void testAdicionarDuasGratificacoes(){
        funcionario.adicionarGratificacaoHoraExtra(10);
        funcionario.adicionarGratificacaoDesempenho();
        assertEquals(2, funcionario.quantidadeDeGratificoes());
    }

    @Test
    public void testUmaGratificacaoHoraExtra(){
        funcionario.adicionarGratificacaoHoraExtra(10);
        double valor = funcionario.calcularValorTotalDasGratificoes();
        assertTrue(25.0 == valor);
    }

    @Test
    public void testUmaGratificacaoDesempenho(){

    }

}