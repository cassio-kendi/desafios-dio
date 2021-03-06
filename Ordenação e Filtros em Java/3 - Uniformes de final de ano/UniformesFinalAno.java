import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UniformesFinalAno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidadeListas = sc.nextInt();
        sc.nextLine();
        List<Uniforme> uniformes = new ArrayList<>();

        for(int i=0; i < quantidadeListas; i++) {
            String nomeAluno = sc.nextLine();
            String[] corTamanho = sc.nextLine().split(" ");
            String cor = corTamanho[0];
            String tamanho = corTamanho[1];
            uniformes.add(new Uniforme(cor, tamanho, nomeAluno));
        }

        Comparator<Uniforme> compararUniformes = Comparator
                                                .comparing(Uniforme::getCor)
                                                .thenComparing(Uniforme::getTamanho, Comparator.reverseOrder())
                                                .thenComparing(Uniforme::getNomeAluno);

        uniformes.stream().sorted(compararUniformes).forEach(System.out::println);
    }

    static class Uniforme {
        private String cor;
        private String tamanho;
        private String nomeAluno;

        public Uniforme(String cor, String tamanho, String nomeAluno) {
            this.cor = cor;
            this.tamanho = tamanho;
            this.nomeAluno = nomeAluno;
        }

        public String getCor() {
            return this.cor;
        }

        public String getTamanho() {
            return this.tamanho;
        }

        public String getNomeAluno() {
            return this.nomeAluno;
        }

        @Override
        public String toString() {
            return getCor() + " " + getTamanho() + " " + getNomeAluno();
        }
    }
}