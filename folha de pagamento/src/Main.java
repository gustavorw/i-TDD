import positions.*;

import java.util.Scanner;

public class Main {
    static Memory memory = new Memory();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int op = 0;
        int op2 = 0;
        String name = "";
        do {
            memory.menu();
            op = input.nextInt();

            switch (op) {
                case 1:
                    memory.menuWorker();
                    op2 = input.nextInt();
                    System.out.println("Digite um nome:");
                    name = input.next();
                    addWorker(name, op2);
                    break;
                case 2:
                    memory.showPayLeaf();
                    break;
                case 3:
                    System.out.println("Digite um nome:");
                    name = input.next();
                    Worker worker = searchWorker(name);
                    if (worker != null) {
                        menuGratifications();
                        op2 = input.nextInt();
                        switch (op2) {
                            case 1:
                                worker.addPerformanceBonus();
                                break;
                            case 2:
                                int hour;
                                System.out.println("Digite a quantidade de horas:");
                                hour = input.nextInt();
                                worker.addOvertimeBonus(hour);
                                break;
                            case 3:
                                int index;
                                worker.displayGratuities();
                                index = input.nextInt();
                                worker.removeGratification(index);
                                break;
                        }
                    }
                    break;

            }


        } while (op != 0);
    }

    static public void addWorker(String name, int type) {
        switch (type) {
            case 1:
                memory.addManager(new Manager(name));
            case 2:
                memory.addEmployee(new Employee(name));
            default:
                System.out.println("Opção não existe");
        }
    }

    static public Worker searchWorker(String name) {
        return memory.searchWorker(name);
    }

    static public void menuGratifications() {
        System.out.println("1 - adicionar gratificão Desempenho");
        System.out.println("2 - adicionar gratificão Hora extra");
        System.out.println("3 - remover gratificação");
    }
}
