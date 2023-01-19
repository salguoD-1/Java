package application;

public class ProgramForEach {
    public static void main(String[] args) {
        // Instânciamos um array de Strings e inicializamos com 3 valores
        String[] vect = new String[] {"Maria", "Bob", "Alex"};

        // Tipo de dado dos elementos - Nome(Apelido) : nome da coleção(vect)
        for (String nome : vect) {
            System.out.println(nome);
        }


    }
}
