import java.util.Scanner;

public class MenorEPosicao {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int N = leitor.nextInt();
        int menor = Integer.MAX_VALUE, posMenor = 0, entrada;
        for (int i = 0; i < N; i++) {
            entrada = leitor.nextInt();
            if (entrada < menor) {
                menor = entrada;
                posMenor = i;
            }
        }
        System.out.println("Menor valor: " + menor);
        System.out.println("Posicao: " + posMenor);
    }

}