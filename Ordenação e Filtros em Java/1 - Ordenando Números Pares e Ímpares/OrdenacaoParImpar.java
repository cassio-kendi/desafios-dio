import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenacaoParImpar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();

        while (sc.hasNextInt()) {
            int entrada = sc.nextInt();
            if (entrada % 2 == 0) pares.add(entrada);
            else impares.add(entrada);
        }

        pares.stream().sorted().forEach(System.out :: println);
        impares.stream().sorted(Collections.reverseOrder()).forEach(System.out :: println);
    }
}