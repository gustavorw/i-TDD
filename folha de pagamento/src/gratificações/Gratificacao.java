package gratificações;

public abstract class Gratificacao {
    private double salario;

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public double calculaGratificacao(){
        return 0.0;
    }

}
