import cargos.Funcionario;
import cargos.Gerente;
import cargos.Trabalhador;

import java.util.ArrayList;
import java.util.List;
public class Memoria {
   private List<Trabalhador> trabalhadores;

   public Memoria(){
       trabalhadores = new ArrayList<>();
   }

   public void adicionarFuncionario(Funcionario funcionario){
       trabalhadores.add(funcionario);
   }

   public void adicionarGerente(Gerente gerente){
       trabalhadores.add(gerente);
   }

   public Trabalhador buscarTrabalhador(String nome){
       for (Trabalhador tr : trabalhadores){
           if(tr.getNome().equals(nome)){
               return tr;
           }
       }
       return null;
   }

   public boolean apagarTrabalhador(String nome){
       Trabalhador tr = buscarTrabalhador(nome);
       if(tr == null){
           System.out.println("Trabalhador com esse nome não existe");
           return false;
       }
       trabalhadores.remove(tr);
       return true;
   }

   public void exibirFolhadePagamento(){
       System.out.println("NOME        |     CARGO    | SALÁRIO | QT.GRATIFICAÇÕES | VALOR GRATIFICAÇÕES | V.MENSAL");
       for(Trabalhador tr: trabalhadores){
           tr.exibirInfor();
       }

   }

}
