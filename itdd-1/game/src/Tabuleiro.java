import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tabuleiro {
    private Map<Integer, Jogador> tabuleiro;
    private List<Integer> registroDeJogadas;

    public Tabuleiro() {
        tabuleiro = new HashMap<>();
        registroDeJogadas = new ArrayList<>();
    }

    public boolean adicionarJogada(int posicao, Jogador jogador) {
        if (posicaoValida(posicao)) {
            tabuleiro.put(posicao, jogador);
            registroDeJogadas.add(posicao);
            return true;
        }
        return false;
    }

    private boolean posicaoValida(int posicao) {
        if (posicao < 0 || posicao >= 9) {
            return false;
        } else if (registroDeJogadas.contains(posicao)) {
            return false;
        }
        return true;
    }

    public void reiniciarTabuleiro() {
        tabuleiro.clear();
        registroDeJogadas.clear();
    }

    public boolean estaVazio(){
        return tabuleiro.isEmpty();
    }


    private boolean verificaPosicoes(int posicaoUm, int posicaoDois, int posicaoTres) {
        if (posicaoEstaVazia(posicaoUm) && posicaoEstaVazia(posicaoDois) && posicaoEstaVazia(posicaoTres)) {
            return true;
        }
        return false;
    }

    public void imprimirTabuleiro() {
        System.out.println(buscarSimboloEm(0) + "|" + buscarSimboloEm(1) + "|" + buscarSimboloEm(2));
        System.out.println("_______");
        System.out.println(buscarSimboloEm(3) + "|" + buscarSimboloEm(4) + "|" + buscarSimboloEm(5));
        System.out.println("_______");
        System.out.println(buscarSimboloEm(6) + "|" + buscarSimboloEm(7) + "|" + buscarSimboloEm(8));
    }

    private boolean posicaoEstaVazia(int posicao) {
        return tabuleiro.get(posicao) != null;
    }

    private String buscarSimboloEm(int posicao) {
        return !posicaoEstaVazia(posicao) ? " " : tabuleiro.get(posicao).buscarSimbolo().toString();
    }

    public Jogador verificaSePossuiGanhador() {
        if (temGanhadorDiagonalPrimaria()) {
            return tabuleiro.get(0);
        } else if (temGanhadorDiagonalSecundaria()) {
            return tabuleiro.get(2);
        } else if (temGanhadorLinhaUm()) {
            return tabuleiro.get(0);
        } else if (temGanhadorLinhaDois()) {
            return tabuleiro.get(3);
        } else if (temGanhadorLinhaTres()) {
            return tabuleiro.get(6);
        } else if (temGanhadorColunaUm()) {
            return tabuleiro.get(0);
        } else if (temGanhadorColunaDois()) {
            return tabuleiro.get(1);
        } else if (temGanhadorColunaTres()) {
            return tabuleiro.get(2);
        }
        return null;
    }



    /*

        Verificação de quando o jogador ganha

    */

    private boolean temGanhadorDiagonalPrimaria() {
        if (verificaPosicoes(0, 4, 8)) {
            if (tabuleiro.get(0).buscarSimbolo() == tabuleiro.get(4).buscarSimbolo() &&
                    tabuleiro.get(4).buscarSimbolo() == tabuleiro.get(8).buscarSimbolo()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean temGanhadorDiagonalSecundaria() {
        if (verificaPosicoes(2, 4, 6)) {
            if (tabuleiro.get(2).buscarSimbolo() == tabuleiro.get(4).buscarSimbolo() &&
                    tabuleiro.get(4).buscarSimbolo() == tabuleiro.get(6).buscarSimbolo()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean temGanhadorLinhaUm() {
        if (verificaPosicoes(0, 1, 2)) {
            if (tabuleiro.get(0).buscarSimbolo() == tabuleiro.get(1).buscarSimbolo() &&
                    tabuleiro.get(1).buscarSimbolo() == tabuleiro.get(2).buscarSimbolo()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean temGanhadorLinhaDois() {
        if (verificaPosicoes(3, 4, 5)) {
            if (tabuleiro.get(3).buscarSimbolo() == tabuleiro.get(4).buscarSimbolo() &&
                    tabuleiro.get(4).buscarSimbolo() == tabuleiro.get(5).buscarSimbolo()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean temGanhadorLinhaTres() {
        if (verificaPosicoes(6, 7, 8)) {
            if (tabuleiro.get(6).buscarSimbolo() == tabuleiro.get(7).buscarSimbolo() &&
                    tabuleiro.get(7).buscarSimbolo() == tabuleiro.get(8).buscarSimbolo()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean temGanhadorColunaUm() {
        if (verificaPosicoes(0, 3, 6)) {
            if (tabuleiro.get(0).buscarSimbolo() == tabuleiro.get(3).buscarSimbolo() &&
                    tabuleiro.get(3).buscarSimbolo() == tabuleiro.get(6).buscarSimbolo()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean temGanhadorColunaDois() {
        if (verificaPosicoes(1, 4, 7)) {
            if (tabuleiro.get(1).buscarSimbolo() == tabuleiro.get(4).buscarSimbolo() &&
                    tabuleiro.get(4).buscarSimbolo() == tabuleiro.get(7).buscarSimbolo()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean temGanhadorColunaTres() {
        if (verificaPosicoes(2, 5, 8)) {
            if (tabuleiro.get(2).buscarSimbolo() == tabuleiro.get(5).buscarSimbolo() &&
                    tabuleiro.get(5).buscarSimbolo() == tabuleiro.get(8).buscarSimbolo()) {
                return true;
            }
            return false;
        }
        return false;
    }


}

