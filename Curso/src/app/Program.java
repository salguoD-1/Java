package app;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Program {
    public static void main(String[] args) {
        // NOTA: PARA TRANSFORMAR DATA-HORA GLOBAL PARA LOCAL, É NECESSÁRIO INFORMAR
        // O TIMEZONE.
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

        // Usamos o objeto d04 com o método minusDay que subtrai os dias passados por argumento
        LocalDate pastWeekLocalDate = d04.minusDays(7);
        // Armazena o valor do objeto d04 + 7 dias
        LocalDate nextWeekLocal = d04.plusDays(7);

        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocal = " + nextWeekLocal);

        // Adiciona/subtrai as datas + hora.
        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);

        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);

        // Usamos o método minus e plus seguido da classe ChronoUnit e a constante DAYS.
        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);

        // Usamos a classe duration para saber a duração entre duas data-horas
        // com o método between que recebe dois parametros.
        Duration t1 = Duration.between(pastWeekLocalDateTime, d05);
        // Exibe o resultado da diferença em dias
        System.out.println("t1 = " + t1.toDays());

        // Método atStartOfDay converte de LocalDate para LocalDateTime quando der meia noite
        Duration t2 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
        System.out.println("t2 = " + t2.toDays());

        Duration t3 = Duration.between(pastWeekInstant, d06);
        System.out.println("t3 = " + t3.toDays());
    }
}