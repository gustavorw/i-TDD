package gratificações;

public class Desempenho extends Gratificacao{
    @Override
    public double calculaGratificacao( double salario) {
        return salario * 0.05;
    }
}
