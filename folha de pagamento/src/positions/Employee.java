package positions;

public class Employee extends Worker {

    public Employee(String nome) {
        setName(nome);
        setSalary(2500);
    }

    @Override
    public void showInformation() {
        System.out.println(getName() + " " + "         funcionário      " + getSalary() + "R$     " + amountOfGratuities() + "                 " + calculateTotalGratificationsAmount() + "                 " + getMonthlySalaryAmount());
    }

    @Override
    public String toString() {
        return "Funcionário";
    }
}
