import java.util.Scanner;

public class CombinacaoStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        while(sc.hasNextLine()) {
            String[] entrada = sc.nextLine().split(" ");
            String str1 = entrada[0];
            String str2 = entrada[1];
            String sobra = "";
            int shortestLenght = str1.length() < str2.length() ? str1.length() : str2.length();
            if (str1.length() != str2.length()) {
                sobra = str1.length() > str2.length() ? str1.substring(str2.length()) : str2.substring(str1.length());
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0; i < shortestLenght*2; i++) {
                stringBuilder.append((i%2 == 0) ? str1.charAt(i/2) : str2.charAt(i/2));
            }
            System.out.println(stringBuilder.toString() + sobra);
        }
    }
}