import java.util.*;

public class Jogo {
    private int quantidadeJogadas;
    private Tabuleiro tabuleiro;
    private Jogador jogadorUm;
    private Jogador jogadorDois;

    Jogo(Jogador jogadorUm, Jogador jogadorDois){
        quantidadeJogadas = 0;
        tabuleiro = new Tabuleiro();
        this.jogadorUm = jogadorUm;
        this.jogadorDois = jogadorDois;

    }

    Jogo(){
        quantidadeJogadas = 0;
        tabuleiro = new Tabuleiro();
    }

    public void adicionarJogadores(Jogador j1, Jogador j2){
        jogadorUm = j1;
        jogadorDois = j2;
    }

    public boolean podeInicar(){
        if(jogadorUm == null || jogadorDois == null)
            return false;
        else if(jogadorUm.buscarSimbolo() == jogadorDois.buscarSimbolo()){
            return false;
        }

        return tabuleiro.estaVazio();
    }

    public boolean adicionarJogada(int posicao, Jogador jogador){
      if(tabuleiro.adicionarJogada(posicao, jogador)){
          quantidadeJogadas += 1;
          return true;
      }
      return false;
    }

    public void reiniciarJogo(){
        tabuleiro.reiniciarTabuleiro();
        quantidadeJogadas = 0;
    }

    public String jogoTemGanhador(){
        if(quantidadeJogadas >= 5){
            return buscarResultadoJogo();
        }
        return "Não tem jogadas suficientes para se ter um vencedor";
    }

    public void statusTabuleiro(){
        tabuleiro.imprimirTabuleiro();
    }


    private String buscarResultadoJogo(){
        if(tabuleiro.verificaSePossuiGanhador() != null){
            return "Jogador: "+ tabuleiro.verificaSePossuiGanhador().buscarNome() + " ganhou";
        }
        if(quantidadeJogadas == 9){
            return "Deu velha";
        }
        return "Jogo não acabou";
    }




}
