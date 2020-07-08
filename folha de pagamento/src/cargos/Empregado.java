package cargos;

import gratificações.Desempenho;
import gratificações.Gratificacao;
import gratificações.HoraExtra;

import java.util.ArrayList;
import java.util.List;

abstract public class Empregado {
    private String nome;
    private double salario;
    private List<Gratificacao> gratificacoes;
    private double valorVencimentoMensal;
    private double valorDasGratificacoes;

    Empregado(){
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
        gratificacoes.add(horaExtra);
    }

    public void adicionarGratificacaoDesempenho() {
        Desempenho desempenho = new Desempenho();
        gratificacoes.add(desempenho);
    }

    public double calcularValorTotalDasGratificoes() {
        double valorTotalGratificacoes = 0.0;
        for (Gratificacao gratificacao : gratificacoes) {
            if (gratificacao instanceof HoraExtra)
                valorTotalGratificacoes += gratificacao.calculaGratificacao(getSalario());
            if (gratificacao instanceof Desempenho)
                valorTotalGratificacoes += gratificacao.calculaGratificacao(getSalario());
        }
        setValorDasGratificacoes(valorTotalGratificacoes);
        return valorTotalGratificacoes;
    }

    public int quantidadeDeGratificoes(){
        return gratificacoes.size();
    }

    public void exibirGratificacoes(){
        int index = 0;
        for(Gratificacao gratificacao: gratificacoes){
            System.out.println(index +" "+ gratificacao.toString() + "  " +gratificacao.calculaGratificacao(getSalario()));
        }
    }

    public void removerGratificacao(int index) {
        try {
            Gratificacao aux = gratificacoes.get(index);
            gratificacoes.remove(aux);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Não existe essa gratificação");
        }

    }

    abstract public void exibirInfor();



}
