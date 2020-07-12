package positions;
import gratuities.Performace;
import gratuities.Gratification;
import gratuities.ExtraHour;
import java.util.ArrayList;
import java.util.List;

abstract public class Worker {
    private String name;
    private double salary;
    private List<Gratification> gratuities;
    private double monthlySalaryAmount;
    private double gratuityValue;

    Worker(){
        gratuities = new ArrayList<>();
        gratuityValue = 0.0;
        monthlySalaryAmount = 0.0;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getMonthlySalaryAmount() {
        double valor = getSalary() + getGratuityValue();
        setMonthlySalaryAmount(valor);
        return monthlySalaryAmount;
    }

    public void setMonthlySalaryAmount(double monthlySalaryAmount) {
        this.monthlySalaryAmount = monthlySalaryAmount;
    }

    public double getGratuityValue() {
        return gratuityValue;
    }

    public void setGratuityValue(double gratuityValue) {
        this.gratuityValue = gratuityValue;
    }

    public void addOvertimeBonus(int hour) {
        ExtraHour extraHour = new ExtraHour(hour);
        gratuities.add(extraHour);
    }

    public void addPerformanceBonus() {
        Performace performace = new Performace();
        gratuities.add(performace);
    }

    public double calculateTotalGratificationsAmount() {
        double totalAmountOfGratuities = 0.0;
        for (Gratification gratification : gratuities) {
            if (gratification instanceof ExtraHour)
                totalAmountOfGratuities += gratification.calculatesBonus(getSalary());
            if (gratification instanceof Performace)
                totalAmountOfGratuities += gratification.calculatesBonus(getSalary());
        }
        setGratuityValue(totalAmountOfGratuities);
        return totalAmountOfGratuities;
    }

    public int amountOfGratuities(){
        return gratuities.size();
    }

    public void displayGratuities(){
        int index = 0;
        for(Gratification gratification : gratuities){
            System.out.println(index +" "+ gratification.toString() + "  " + gratification.calculatesBonus(getSalary()));
        }
    }

    public void removeGratification(int index) {
        try {
            Gratification aux = gratuities.get(index);
            gratuities.remove(aux);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Não existe essa gratificação");
        }

    }

    abstract public void displayInformation();



}
