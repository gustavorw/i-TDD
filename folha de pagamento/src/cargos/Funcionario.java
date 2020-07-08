package cargos;

public class Funcionario extends Empregado {

    public Funcionario(String nome) {
        setNome(nome);
        setSalario(2500);
    }

    @Override
    public void exibirInfor() {
        System.out.println(getNome() + " " + "         funcionário      " + getSalario() + "R$     " + quantidadeDeGratificoes() + "                 " + calcularValorTotalDasGratificoes() + "                 " + getValorVencimentoMensal());
    }

    @Override
    public String toString() {
        return "Funcionário";
    }
}
