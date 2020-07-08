package cargos;

public class Gerente extends Empregado {

    public Gerente(String nome) {
        setNome(nome);
        setSalario(4000);
    }


    @Override
    public void exibirInfor() {
        System.out.println(getNome() + " " + "      Gerente        " + getSalario() + "R$      " + quantidadeDeGratificoes() + "                  " + calcularValorTotalDasGratificoes() + "                " + getValorVencimentoMensal());
    }

    @Override
    public String toString() {
        return "Gerente";
    }
}
