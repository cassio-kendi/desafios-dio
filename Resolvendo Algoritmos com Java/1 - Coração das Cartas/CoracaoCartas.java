import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoracaoCartas {

    static Map<String, Boolean> resultadosSalvos = new HashMap<>(); 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer cartasPorPilha = 0;

        while((cartasPorPilha= Integer.valueOf(sc.nextLine())) != 0) {

            int[][] pilhas = new int[cartasPorPilha][3];
            int topoPilha1 = -1;
            int topoPilha2 = -1;
            int topoPilha3 = -1;

            for(int i=0; i< cartasPorPilha; i++){
                String[] proximasCartas = sc.nextLine().split(" ");
                Integer cartaPilha1 = Integer.valueOf(proximasCartas[0]);
                Integer cartaPilha2 = Integer.valueOf(proximasCartas[1]);
                Integer cartaPilha3 = Integer.valueOf(proximasCartas[2]);
                if(cartaPilha1 % 3 != 0) {
                  pilhas[++topoPilha1][0] = cartaPilha1;
                }
                if(cartaPilha2 % 3 != 0) {
                  pilhas[++topoPilha2][1] = cartaPilha2;
                }
                if(cartaPilha3 % 3 != 0){ 
                  pilhas[++topoPilha3][2] = cartaPilha3;
                }
            }
            System.out.println(isJogoPossivel(pilhas, topoPilha1, topoPilha2, topoPilha3) ? "1" : "0");
        }
    }

    static boolean isJogoPossivel(int[][] pilhas, int topoPilha1, int topoPilha2, int topoPilha3) {
        if(topoPilha1 == -1 && topoPilha2 == -1 && topoPilha3 == -1)
            return true;
        
        boolean isPossivel = false;
        String chave = "p1:" + String.valueOf(topoPilha1) + "p2:" +String.valueOf(topoPilha2) + "p3:" +String.valueOf(topoPilha3);

        if(topoPilha1 > -1 && topoPilha2 > -1 && (pilhas[topoPilha1][0] + pilhas[topoPilha2][1]) % 3 == 0){
            isPossivel |= isJogoPossivel(pilhas, topoPilha1 - 1, topoPilha2 -1, topoPilha3);
            resultadosSalvos.putIfAbsent(chave, isPossivel);
        }

        if(!isPossivel && topoPilha1 > -1 && topoPilha3 > -1 && (pilhas[topoPilha1][0] + pilhas[topoPilha3][2]) % 3 == 0) {
            isPossivel |= isJogoPossivel(pilhas, topoPilha1 - 1, topoPilha2, topoPilha3 - 1);
            resultadosSalvos.putIfAbsent(chave, isPossivel);
        }

        if(!isPossivel && topoPilha2 > -1 && topoPilha3 > -1 && (pilhas[topoPilha2][1] + pilhas[topoPilha3][2]) % 3 == 0){
            isPossivel |= isJogoPossivel(pilhas, topoPilha1, topoPilha2 - 1, topoPilha3 - 1);
            resultadosSalvos.putIfAbsent(chave, isPossivel);
        }

        if(!isPossivel && topoPilha1 > -1 && topoPilha2 > -1 && topoPilha3 > -1 && (pilhas[topoPilha1][0] + pilhas[topoPilha2][1] + pilhas[topoPilha3][2]) % 3 == 0){
            isPossivel |= isJogoPossivel(pilhas, topoPilha1 - 1, topoPilha2 - 1, topoPilha3 - 1);
            resultadosSalvos.putIfAbsent(chave, isPossivel);
        }
        
        return isPossivel;
    }
}