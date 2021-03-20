import java.util.Scanner;

public class HashMagico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantidadeCasos = sc.nextInt();

        for(int i=0; i < quantidadeCasos; i++) {
            int quantidadeLinhas = sc.nextInt();
            sc.nextLine();

            int hash = 0;
            for(int j=0; j < quantidadeLinhas; j++) {
                String linha = sc.nextLine();
                for(int k=0; k < linha.length(); k++) {
                    hash += k + j + linha.charAt(k) - 'A';
                }
            }

            System.out.println(hash);
        }
    }
}