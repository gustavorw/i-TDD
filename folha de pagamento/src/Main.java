import positions.*;

import java.util.Scanner;

public class Main {
    static Memory memory = new Memory();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // uma demostração das funções via console

        int op = 0;
        int op2 = 0;
        String name = "";
        do {
            memory.menu();
            System.out.print("Digite uma opção:");
            op = input.nextInt();

            switch (op) {
                case 1:
                    memory.menuWorker();
                    System.out.print("Digite uma opção:");
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
                        do {
                            menuWorker();
                            System.out.print("Digite uma opção:");
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
                                    worker.showGratuities();
                                    System.out.print("Digite o index da gratificação que quer excluir:");
                                    index = input.nextInt();
                                    worker.removeGratification(index);
                                    break;
                                case 4:
                                    System.out.print("Digite o novo nome:");
                                    name = input.next();
                                    worker.setName(name);
                                    break;
                                case 5:
                                    double salary;
                                    System.out.println("Digite novo salário:");
                                    salary = input.nextDouble();
                                    worker.setSalary(salary);
                                    break;
                            }
                        } while (op2 != 0);
                    }
                    break;

            }


        } while (op != 0);
    }

    static public void addWorker(String name, int type) {
        switch (type) {
            case 1:
                memory.addManager(new Manager(name));
                System.out.println("Gerente adicionado");
                break;
            case 2:
                memory.addEmployee(new Employee(name));
                System.out.println("Funcionario adicionado");
                break;
            default:
                System.out.println("Opção não existe");
        }
    }

    static public Worker searchWorker(String name) {
        return memory.searchWorker(name);
    }

    static public void menuWorker() {
        System.out.println("Menu do Administrador usuário");
        System.out.println("1 - adicionar gratificão Desempenho");
        System.out.println("2 - adicionar gratificão Hora extra");
        System.out.println("3 - remover gratificação");
        System.out.println("4 - alterar nome");
        System.out.println("5 - alterar salário");
        System.out.println("0 - sair");
    }
}
