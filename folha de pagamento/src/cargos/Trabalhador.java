package cargos;

import gratificações.Desempenho;
import gratificações.Gratificacao;
import gratificações.HoraExtra;

import java.util.ArrayList;
import java.util.List;

abstract public class Trabalhador {
    private String nome;
    private double salario;
    private List<Gratificacao> gratificacoes;
    private double valorVencimentoMensal;
    private double valorDasGratificacoes;

    Trabalhador(){
        gratificacoes = new ArrayList<>();
        valorDasGratificacoes = 0.0;
        valorVencimentoMensal = 0.0;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getValorVencimentoMensal() {
        double valor = getSalario() + getValorDasGratificacoes();
        setValorVencimentoMensal(valor);
        return valorVencimentoMensal;
    }

    public void setValorVencimentoMensal(double valorVencimentoMensal) {
        this.valorVencimentoMensal = valorVencimentoMensal;
    }

    public double getValorDasGratificacoes() {
        return valorDasGratificacoes;
    }

    public void setValorDasGratificacoes(double valorDasGratificacoes) {
        this.valorDasGratificacoes = valorDasGratificacoes;
    }

    public void adicionarGratificacaoHoraExtra(int horas) {
        HoraExtra horaExtra = new HoraExtra(horas);
        horaExtra.setSalario(getSalario());
        gratificacoes.add(horaExtra);
    }

    public void adicionarGratificacaoDesempenho() {
        Desempenho desempenho = new Desempenho();
        desempenho.setSalario(getSalario());
        gratificacoes.add(desempenho);
    }

    public double calcularValorTotalDasGratificoes() {
        double valorTotalGratificacoes = 0.0;
        for (Gratificacao gratificacao : gratificacoes) {
            if (gratificacao instanceof HoraExtra)
                valorTotalGratificacoes += gratificacao.calculaGratificacao();
            if (gratificacao instanceof Desempenho)
                valorTotalGratificacoes += gratificacao.calculaGratificacao();
        }
        setValorDasGratificacoes(valorTotalGratificacoes);
        return valorTotalGratificacoes;
    }

    public int quantidadeDeGratificoes(){
        return gratificacoes.size();
    }

    abstract public void exibirInfor();
}
