public class Funcionario {

    private String nome;
    private double salario;

    private static double mediaSalarial;

    Funcionario(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
        mediaSalarial = 0;
    }

    Funcionario(){
        
    }

    public String getNome(){
        return this.nome;
    }

    public double getSalario(){
        return this.salario;
    }

    public void setMediaSalarial(double mediaSal){
        mediaSalarial = mediaSal;
    }
    public double getMediaSalarial(){
        return mediaSalarial;
    }

    public String toString(){
        return String.format("Nome: %s -> Salario: R$%.2f",this.nome, this.salario);
    }
}
