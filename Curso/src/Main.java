public class Main {
    public static void main(String[] args) {
        String original1 = "OI, EU ESTOU EM MAIÚSCULO!";

        // Exibe o resultado convertido para minúsculo
        System.out.println(original1.toLowerCase());

        String original2 = "oi, eu estou em minúsculo!";

        // Exibe o resultado convertido para maiúsculo
        System.out.println(original2.toUpperCase());

        String original3 = "   Oi, eu tenho espaços em branco nas laterais!  ";

        // Exibe o resultado sem os espaços em branco
        System.out.println(original3.trim());

        // Cria uma substring começando no caractere de índice 4
        String original4 = original1.substring(4);
        System.out.println(original4);

        // Cria uma substring começando no índice 4 e terminando no índice 12
        String original5 = original1.substring(4, 12);
        System.out.println(original5);

        // Substituir os caracteres E por X
        String original6 = original1.replace('E', 'X');
        System.out.println(original6);

        // Armazena a posição de determinada frase e exibe o resultado
        int original7 = original1.indexOf("ESTOU");
        System.out.println(original7);

        // A função split() separa uma string em substrings que são armazeandas em arrays
        String s = "Potato Apple Lemon";
        // Armazenamos os três valores no array usando a função split que
        // separa por espaços em branco
        String[] arr = s.split(" ");

        // Exibindo os valores
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);

    }
}