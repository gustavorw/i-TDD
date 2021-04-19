public class Jogador {
    private String nome;
    private Simbolo simbolo;

    public Jogador(String nome, Simbolo simbolo){
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public Simbolo buscarSimbolo() {
        return simbolo;
    }
    public String buscarNome(){
        return nome;
    }
}
