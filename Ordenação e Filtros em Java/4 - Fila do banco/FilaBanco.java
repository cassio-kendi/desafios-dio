import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilaBanco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidadeEntradas = sc.nextInt();

        for(int i=0; i < quantidadeEntradas; i++) {
            int quantidadePessoas = sc.nextInt();
            sc.nextLine();
            String[] filaString = sc.nextLine().split(" "); 
            List<Integer> fila = Arrays.asList(filaString).stream().map(Integer::valueOf).collect(Collectors.toList());
            List<Integer> filaOrdenada = new ArrayList<>(fila);
            Collections.sort(filaOrdenada, Collections.reverseOrder());

            int pessoasMesmaOrdem = 0;
            for(int j=0; j < quantidadePessoas; j++) {
                if(fila.get(j) == filaOrdenada.get(j)) 
                    pessoasMesmaOrdem++;
            }

            System.out.println(pessoasMesmaOrdem);
        }

    }
}