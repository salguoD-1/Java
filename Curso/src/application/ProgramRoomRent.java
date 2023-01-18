package application;

import entities.Room;

import java.util.Locale;
import java.util.Scanner;

public class ProgramRoomRent {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String clientName;
        String clientEmail;
        int clientRoom;
        int totalOfRooms;

        int[] room = new int[10];
        Room[] rentRoom = new Room[10];

        System.out.print("How many rooms will be rented? ");
        totalOfRooms = sc.nextInt();
        // Limpa o buffer do teclado
        sc.nextLine();

        for (int i = 0; i < totalOfRooms; i++) {
            System.out.printf("%nRent #%d%n", i + 1);
            System.out.print("Name: ");
            clientName = sc.nextLine();
            System.out.print("Email: ");
            clientEmail = sc.nextLine();
            System.out.print("Room: ");
            clientRoom = sc.nextInt();
            sc.nextLine();
            // Criamos uma instância da classe Room e inicializamos o contrutor
            rentRoom[clientRoom] = new Room(clientName, clientEmail, clientRoom);
        }

        // Analisa se a instância na posição j está vazia
        System.out.printf("%nBusy rooms:%n");
        for (int j = 0; j < 10; j++) {
            if (rentRoom[j] != null) {
                System.out.println(rentRoom[j]);
            }
        }
    }
}
