package app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DataHoraCustomizado {
    public static void main(String[] args) {
        LocalDate d04 = LocalDate.parse("2023-02-08");
        LocalDateTime d05 = LocalDateTime.parse("2023-02-08T14:52:36");
        Instant d06 = Instant.parse("2023-02-08T14:52:39Z");

        // Formata a saída da nossa data para dia/mês/ano
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Formata a saída da nossa data para dia/mês/ano hora/minutos
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        // Formata a saída da nossa data para dia/mês/ano hora/minutos
        // Além disso, trabalha com o fuso horario global, com o método systemDefault.
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        // Exibe o resultado formatado
        System.out.println("d04 = " + d04.format(fmt1));
        System.out.println("d05 = " + d05.format(fmt2));
        // Usamos o fmt3 direto pois a classe Instant não possui o método format.
        System.out.println("d06 = " + fmt3.format(d06));
    }
}
