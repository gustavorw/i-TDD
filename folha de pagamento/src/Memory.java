import positions.Employee;
import positions.Manager;
import positions.Worker;
import java.util.ArrayList;
import java.util.List;

public class Memory {
    private List<Worker> workers;

    public Memory() {
        workers = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        workers.add(employee);
    }

    public void addManager(Manager manager) {
        workers.add(manager);
    }

    public int sizedWorkers(){
        return workers.size();
    }

    public Worker searchWorker(String name) {
        for (Worker tr : workers) {
            if (tr.getName().equals(name.toLowerCase())) {
                return tr;
            }
        }
        return null;
    }

    public boolean deleteWorker(String name) {
        Worker tr = searchWorker(name);
        if (tr == null) {
            System.out.println("Trabalhador com esse nome não existe");
            return false;
        }
        workers.remove(tr);
        return true;
    }

    public void showPayLeaf() {
        System.out.println("NOME        |     CARGO    | SALÁRIO | QT.GRATIFICAÇÕES | VALOR GRATIFICAÇÕES | V.MENSAL");
        for (Worker tr : workers) {
            tr.displayInformation();
        }

    }

    public void menu(){
        System.out.println("Bem vindos ao sistema de folha de pagamento");
        System.out.println("1 - cadastrar Trabalhador");
        System.out.println("2 - imprimir folha de pagamento");
        System.out.println("3 - buscar Trabalhador");
        System.out.println("0 - sair");
    }

    public void menuWorker(){
        System.out.println("1 - adicionar Gerente");
        System.out.println("2 - adicionar Funcionário");
    }

}
