package gratificações;

public class Desempenho extends Gratificacao{
    @Override
    public double calculaGratificacao() {
        return getSalario() * 0.05;
    }
}
