package cargos;

public class Gerente extends Trabalhador {

    public Gerente(String nome) {
        setNome(nome);
        setSalario(4000);

    }

    @Override
    public void exibirInfor() {
        System.out.println(getNome() + " " + "      Gerente        " + getSalario() + "R$      " + quantidadeDeGratificoes() + "                  " + calcularValorTotalDasGratificoes() + "                " + getValorVencimentoMensal());
    }
}
