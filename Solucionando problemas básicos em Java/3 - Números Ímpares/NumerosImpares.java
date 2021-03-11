import java.util.Scanner;

public class NumerosImpares {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num = entrada.nextInt();
        for (int i = 1; i <= num; i = i + 2) { 
            System.out.println(i);
        }
    }

}