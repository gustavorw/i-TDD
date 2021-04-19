package gratuities;

public class ExtraHour extends Gratification {
    private int hour;

    public ExtraHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public double calculatesBonus(double salary) {
        return salary * 0.001 * this.hour;
    }

    @Override
    public String toString() {
        return "Hora extra ";
    }
}
