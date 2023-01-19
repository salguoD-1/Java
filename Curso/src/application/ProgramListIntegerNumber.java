package application;

import java.util.ArrayList;
import java.util.List;

public class ProgramListIntegerNumber {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // Adicionando elementos a lista com o método add()
        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Anna");
        // Adicionando um elemento em uma posição já ocupada
        // O elemento não é prejudicado, ele eleva o seu índice em uma unidade
        list.add(2, "Marco");

        // Exibindo o tamanho da lista com o método size()
        System.out.println("List size: " + list.size() + " elements");

        // Usando um laço for each para percorrer os elementos da lista
        for (String value: list) {
            System.out.println(value);
        }

        System.out.println("-Removendo usuários-");

        // Removendo elementos usando seu valor, índice ou predicado
        list.remove(1); // Remove o Alex
        list.remove("Anna"); // Remove a Anna

        // Removendo por predicado
        // x é do tipo string, analisa se o primeiro caractere é M
        list.removeIf(x -> x.charAt(0) == 'M'); // Função lambda

        System.out.println("Usuários ativos: " + list);

        // Exibe o índice do elemento passado como argumento usando o método indexOf()
        System.out.println("Index of Bob: " + list.indexOf("Bob"));
        // Quando o elemento não existe, retorna -1
        System.out.println("Index of PessoaX: " + list.indexOf("PessoaX"));

    }
}
