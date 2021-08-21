//interfaces Funcionais Utilizadas
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Metodos{

    private Metodos(){}        //classe nao deve ser instanciada

    public static Function<Funcionario, Double> obterSalario = funcAtual ->
        funcAtual.getSalario();

    public static BinaryOperator<Double> somatorioSalarios = (salarioAtual, acum) ->
        acum += salarioAtual;

    public static Predicate<Funcionario> isMenorQueMedia = funcAtual -> 
        funcAtual.getSalario() < funcAtual.getMediaSalarial();

    public static Predicate<Funcionario> isMaiorQueMedia = funcAtual ->
        funcAtual.getSalario() > funcAtual.getMediaSalarial();

    public static Comparator<Funcionario> maiorSalario = (func1, func2) -> {
        
        if(func1.getSalario() > func2.getSalario()){
            return 1;
        }
        else if(func1.getSalario() < func2.getSalario()){
            return -1;
        }
        else{
            return 0;
        }
    };
}