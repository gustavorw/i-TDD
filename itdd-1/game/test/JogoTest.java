import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JogoTest {
        /*
     - Testes ganhador diagonais
     - Testes ganhador linhas e colunas
     - tem dois jogadores
     - simbolos diferentes
     - tem dois jogadores
     - valida jogada
     - tabuleiro vazio
     */

    Jogo jogo;

    @Before
    public void init() {
        jogo = new Jogo();

    }

    @Test
    public void testPodeIniciarJogo(){
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        assertTrue(jogo.podeInicar());
    }

    @Test
    public void testPodeIniciarJogoSimbolosIguais() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.x);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        assertFalse(jogo.podeInicar());
    }

    @Test
    public void testPodeIniciarJogoSemUmJogador(){
        Jogador j1 = new Jogador("Gustavo", Simbolo.x);
        jogo.adicionarJogadores(j1, null);
        assertFalse(jogo.podeInicar());
    }

    @Test
    public void testPodeIniciarJogoComTabuleiroNaoVazio(){
        Jogador j1 = new Jogador("Gustavo", Simbolo.x);
        jogo.adicionarJogada(0,j1);
        assertFalse(jogo.podeInicar());
    }


    @Test
    public void testJogadaValida(){
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        assertTrue(jogo.adicionarJogada(0, j1));
    }

    @Test
    public void testJogadaInvalida() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        assertFalse(jogo.adicionarJogada(10, j1));
    }

    @Test
    public void testJogadaInvalidaNoMesmoLugar() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        jogo.adicionarJogada(8, j1);
        assertFalse(jogo.adicionarJogada(8, j1));
    }


    @Test
    public void testGanhadorDiagonalPrimaria() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        jogo.adicionarJogada(0, j1);
        jogo.adicionarJogada(1, j2);
        jogo.adicionarJogada(4, j1);
        jogo.adicionarJogada(6, j2);
        jogo.adicionarJogada(8, j1);

        assertEquals("Jogador: Gustavo ganhou", jogo.jogoTemGanhador());
    }

    @Test
    public void testGanhadorDiagonalSecundaria() {

        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        jogo.adicionarJogada(2, j1);
        jogo.adicionarJogada(1, j2);
        jogo.adicionarJogada(4, j1);
        jogo.adicionarJogada(8, j2);
        jogo.adicionarJogada(6, j1);

        assertEquals("Jogador: Gustavo ganhou", jogo.jogoTemGanhador());
    }

    @Test
    public void testGanhadorLinhaUm() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        jogo.adicionarJogada(0, j1);
        jogo.adicionarJogada(3, j2);
        jogo.adicionarJogada(1, j1);
        jogo.adicionarJogada(5, j2);
        jogo.adicionarJogada(2, j1);
        assertEquals("Jogador: Gustavo ganhou", jogo.jogoTemGanhador());
    }

    @Test
    public void testGanhadorLinhaDois() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        jogo.adicionarJogada(3, j1);
        jogo.adicionarJogada(0, j2);
        jogo.adicionarJogada(4, j1);
        jogo.adicionarJogada(6, j2);
        jogo.adicionarJogada(5, j1);
        assertEquals("Jogador: Gustavo ganhou", jogo.jogoTemGanhador());
    }

    @Test
    public void testGanhadorLinhaTres() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        jogo.adicionarJogada(6, j1);
        jogo.adicionarJogada(0, j2);
        jogo.adicionarJogada(7, j1);
        jogo.adicionarJogada(3, j2);
        jogo.adicionarJogada(8, j1);
        assertEquals("Jogador: Gustavo ganhou", jogo.jogoTemGanhador());
    }

    @Test
    public void testGanhadorColunaUm() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        jogo.adicionarJogada(0, j1);
        jogo.adicionarJogada(8, j2);
        jogo.adicionarJogada(3, j1);
        jogo.adicionarJogada(7, j2);
        jogo.adicionarJogada(6, j1);
        assertEquals("Jogador: Gustavo ganhou", jogo.jogoTemGanhador());
    }

    @Test
    public void testGanhadorColunaDois() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        jogo.adicionarJogada(1, j1);
        jogo.adicionarJogada(0, j2);
        jogo.adicionarJogada(4, j1);
        jogo.adicionarJogada(6, j2);
        jogo.adicionarJogada(7, j1);
        assertEquals("Jogador: Gustavo ganhou", jogo.jogoTemGanhador());
    }

    @Test
    public void testGanhadorColunaTres() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        jogo.adicionarJogada(2, j1);
        jogo.adicionarJogada(0, j2);
        jogo.adicionarJogada(5, j1);
        jogo.adicionarJogada(6, j2);
        jogo.adicionarJogada(8, j1);
        assertEquals("Jogador: Gustavo ganhou", jogo.jogoTemGanhador());
    }

    @Test
    public void testNaoTemGanhadorPorNaoTerAcabado() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        jogo.adicionarJogada(7, j1);
        jogo.adicionarJogada(0, j2);
        jogo.adicionarJogada(5, j1);
        jogo.adicionarJogada(6, j2);
        jogo.adicionarJogada(8, j1);
        assertEquals("Jogo não acabou", jogo.jogoTemGanhador());
    }

    @Test
    public void testResultadoDoJogoDeuVelha() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        jogo.adicionarJogada(0, j1);
        jogo.adicionarJogada(2, j2);
        jogo.adicionarJogada(1, j1);
        jogo.adicionarJogada(3, j2);
        jogo.adicionarJogada(5, j1);
        jogo.adicionarJogada(4, j2);
        jogo.adicionarJogada(6, j1);
        jogo.adicionarJogada(7, j2);
        jogo.adicionarJogada(8, j1);
        assertEquals("Deu velha", jogo.jogoTemGanhador());
    }

    @Test
    public void testResultadoDoJogoNaotemJogadasSuficientes() {
        Jogador j1 = new Jogador("Gustavo", Simbolo.o);
        Jogador j2 = new Jogador("bianca", Simbolo.x);
        jogo.adicionarJogadores(j1, j2);
        jogo.adicionarJogada(0, j1);
        jogo.adicionarJogada(2, j2);
        jogo.adicionarJogada(1, j1);
        jogo.adicionarJogada(3, j2);
        assertEquals("Não tem jogadas suficientes para se ter um vencedor", jogo.jogoTemGanhador());
    }


}