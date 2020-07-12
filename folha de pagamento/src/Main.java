import positions.*;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager("Gustavo");
        Employee employee = new Employee("João");
        manager.addPerformanceBonus();
        manager.addOvertimeBonus(10);

        Memory memory = new Memory();
        memory.addEmployee(employee);
        memory.addManager(manager);

        Worker worker = memory.searchWorker("Gustavo");
        worker.displayGratuities();


        worker.removeGratification(0);
    }
}
