import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    //metodo que transforma as linhas dos arquivos numa lista de objetos do tipo Funcionario
    public static List<Funcionario> organizaRegistros(List<String> dadosFuncionarios) throws IOException {

        List<Funcionario> listaFuncionarios = new ArrayList<>();
        String nome = "", salario = "";

        for(int i = 0; i < dadosFuncionarios.size(); i++){
            if(i % 2 == 0){
                nome = dadosFuncionarios.get(i);
            }
            else{
                salario = dadosFuncionarios.get(i);
                salario = salario.replace(",", ".");
                listaFuncionarios.add(new Funcionario(nome, Double.parseDouble(salario)));
            }
        }

        return listaFuncionarios;
    }

    public static void main(String[] args) {

        String caminho;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o path(caminho) do arquivo: ");
        caminho = entrada.next();

        entrada.close();

        Path arquivo = Paths.get(caminho);
        if(Files.exists(arquivo)){

            try{
                List<String> dadosFuncionarios = Files.readAllLines(arquivo);
                List<Funcionario> listaFuncionarios = organizaRegistros(dadosFuncionarios);

                Double total = listaFuncionarios.stream().map(Metodos.obterSalario).reduce(0.0, Metodos.somatorioSalarios);
                Double mediaSalarial = total / listaFuncionarios.size();

                System.out.printf("\nMedia salarial Da empresa: R$%.2f",mediaSalarial);
                new Funcionario().setMediaSalarial(mediaSalarial);

                System.out.println("\n\nFuncionarios com ganhos inferiores a media salarial\n");
                listaFuncionarios.stream().filter(Metodos.isMenorQueMedia).forEach(System.out::println);

                System.out.println("\nFuncionarios com ganhos superiores a media salarial\n");
                listaFuncionarios.stream().filter(Metodos.isMaiorQueMedia).forEach(System.out::println);

                System.out.println("\nFuncionario Com maior salario\n");
                System.out.println(listaFuncionarios.stream().max(Metodos.maiorSalario).get());

                System.out.println("\nFuncionario Com menor salario\n");
                System.out.println(listaFuncionarios.stream().min(Metodos.maiorSalario).get());

            }
            catch(Exception erro){
                System.out.println("\nERRO NA ABERTURA DO ARQUIVO");
            }
        }
        else{
            System.out.println("\nARQUIVO NAO ENCONTRADO!!!");
        }
    }
}
