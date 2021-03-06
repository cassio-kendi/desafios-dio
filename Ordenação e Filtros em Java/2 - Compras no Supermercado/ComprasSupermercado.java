import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ComprasSupermercado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidadeListas = sc.nextInt();

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            List<String> lista = Arrays.asList(linha.split(" "));
            System.out.println(lista.stream().distinct().sorted().collect(Collectors.joining(" ")));
        }
    }
}