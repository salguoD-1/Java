package app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Program {
    public static void main(String[] args) {
        // NOTA: PARA TRANSFORMAR DATA-HORA GLOBAL PARA LOCAL, É NECESSÁRIO INFORMAR
        // O TIMEZONE.
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

        // Converte uma data-hora global para uma data-hora local considerando o timezone da máquina.
        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        // Horário local de portugal
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        // Pega a data-hora local do sistema em relação a um fuso horário
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        // Pega a data-hora local do sistema em relação a um fuso horário
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        // Pegando o dia, mês e ano de uma data-local
        System.out.println("d04 dia = " + d04.getDayOfMonth());
        System.out.println("d04 mês = " + d04.getMonthValue());
        System.out.println("d04 ano = " + d04.getYear());

        System.out.println("d05 hora = " + d05.getHour());
        System.out.println("d05 minutos  = " + d05.getMinute());
        System.out.println("d05 segundos = " + d05.getSecond());
    }
}