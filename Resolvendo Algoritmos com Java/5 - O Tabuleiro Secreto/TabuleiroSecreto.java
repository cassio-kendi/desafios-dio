import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dimensao = sc.nextInt();
        int operacoes = sc.nextInt();
        int[][] tabuleiro = new int[dimensao][dimensao];
        sc.nextLine();

        while(sc.hasNextLine()) {
            String[] operacao = sc.nextLine().split(" ");
            int linhaOuColuna = Integer.parseInt(operacao[1]) - 1;
            switch(operacao[0]){
                case "1":
                    for(int i=0; i < dimensao; i++)
                        tabuleiro[linhaOuColuna][i] = Integer.parseInt(operacao[2]);
                    break;
                case "2":
                    for(int i=0; i < dimensao; i++)
                        tabuleiro[i][linhaOuColuna] = Integer.parseInt(operacao[2]);
                    break;
                case "3":
                    System.out.println(valorMaisFrequente(tabuleiro[linhaOuColuna]));
                    break;
                case "4":
                    int[] coluna = new int[dimensao];
                    for(int i=0; i < dimensao; i++)
                        coluna[i] = tabuleiro[i][linhaOuColuna];
                    System.out.println(valorMaisFrequente(coluna));
                    break;
            }
        }
    }

    public static int valorMaisFrequente(int[] arr) {
        Map<Integer, Integer> frequenciaValores = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            frequenciaValores.putIfAbsent(arr[i], 0);
            frequenciaValores.put(arr[i], frequenciaValores.get(arr[i]) + 1);
        }

        return maiorValorEntreMaisRepetidos(frequenciaValores);
    }

    public static Integer maiorValorEntreMaisRepetidos(Map<Integer, Integer> frequenciaValores) {
        List<Integer> maioresRepeticoes = new ArrayList<Integer>();
        Integer maiorRepeticao = Collections.max(frequenciaValores.values());
        List<Integer> chaves = new ArrayList<Integer>(frequenciaValores.keySet());
        for (Integer chave : chaves) {
            Integer valorRepeticao = frequenciaValores.get(chave);
            if (valorRepeticao >= maiorRepeticao) {
                maioresRepeticoes.add(chave);
            }
        }
        Integer maiorNumeroComMaiorRepeticao = Collections.max(maioresRepeticoes);
        return maiorNumeroComMaiorRepeticao;
    }
}