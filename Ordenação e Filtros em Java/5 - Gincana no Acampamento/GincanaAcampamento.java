import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GincanaAcampamento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quantidadeEntradas = 0;

        while( (quantidadeEntradas = sc.nextInt()) !=0) {
            sc.nextLine();
            List<Participante> participantes = new ArrayList<>();
            for(int i=0; i < quantidadeEntradas; i++) { 
                String[] nomeFicha = sc.nextLine().split(" ");
                participantes.add(new Participante(nomeFicha[0], Integer.parseInt(nomeFicha[1])));
            }

            int index=0;
            int valorFicha = participantes.get(index).ficha;
            while(participantes.size() != 1) {
                index = valorFicha % 2 == 0 ?  Math.floorMod(index - valorFicha, participantes.size()) : 
                                               Math.floorMod(valorFicha + index, participantes.size());
                valorFicha = participantes.get(index).ficha;
                participantes.remove(index);
                index = valorFicha % 2 == 0 ? index : Math.floorMod(index - 1, participantes.size());
            }

            System.out.println("Vencedor(a): " + participantes.get(0).nome);
        }
    }

    static class Participante {
        public Participante(String nome, int ficha) {
            this.nome = nome;
            this.ficha = ficha;
        }

        public String nome;
        public int ficha;
    }
}