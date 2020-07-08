package gratificações;

public class HoraExtra extends Gratificacao {
    private int horas;

    public HoraExtra(int horas) {
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public double calculaGratificacao() {
        return getSalario() * 0.001 * this.horas;
    }


}
