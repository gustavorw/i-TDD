package positions;

public class Manager extends Worker {

    public Manager(String nome) {
        setName(nome);
        setSalary(4000);
    }


    @Override
    public void showInformation() {
        System.out.println(getName() + " " + "      Gerente        " + getSalary() + "R$      " + amountOfGratuities() + "                  " + calculateTotalGratificationsAmount() + "                " + getMonthlySalaryAmount());
    }

    @Override
    public String toString() {
        return "Gerente";
    }
}
