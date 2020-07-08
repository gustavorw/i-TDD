import cargos.Funcionario;
import cargos.Gerente;
import cargos.Empregado;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
    private List<Empregado> empregados;

    public Memoria() {
        empregados = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        empregados.add(funcionario);
    }

    public void adicionarGerente(Gerente gerente) {
        empregados.add(gerente);
    }

    public Empregado buscarEmpregado(String nome) {
        for (Empregado tr : empregados) {
            if (tr.getNome().equals(nome)) {
                return tr;
            }
        }
        return null;
    }

    public boolean apagarEmpregado(String nome) {
        Empregado tr = buscarEmpregado(nome);
        if (tr == null) {
            System.out.println("Trabalhador com esse nome não existe");
            return false;
        }
        empregados.remove(tr);
        return true;
    }

    public void exibirFolhadePagamento() {
        System.out.println("NOME        |     CARGO    | SALÁRIO | QT.GRATIFICAÇÕES | VALOR GRATIFICAÇÕES | V.MENSAL");
        for (Empregado tr : empregados) {
            tr.exibirInfor();
        }

    }

}
