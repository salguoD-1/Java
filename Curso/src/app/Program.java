package app;

// API que trabalha com datas
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {
        // Instaciamos a classe LocalDate usando o método now()
        LocalDate d01 = LocalDate.now();
        // Exibe a data local
        // 2023-01-27
        System.out.println(d01);

        // Insanciamos a classe LocalDateTime pegando o tempo local
        LocalDateTime d02 = LocalDateTime.now();
        // Exibe a data local + horário local
        // 2023-01-27T12:59:01.638310
        System.out.println(d02);

        // Instaciamos a classe Instant usando o método now()
        Instant d03 = Instant.now();
        // Exibe a data e a hora + time zone(Z = Data hora GMT(Londres))
        // 2023-01-27T16:00:31.064068Z
        System.out.println(d03);

        // Criamos uma data usando o modelo ISO 8601
        LocalDate d04 = LocalDate.parse("2023-01-27");
        System.out.println(d04);

        // Criamos uma data usando o modelo ISO 8601
        LocalDateTime d05 = LocalDateTime.parse("2023-01-27T13:30:25");
        System.out.println(d05);

        // A classe DateTimeFormatter disponibiliza o método ofPattern
        // que permite especificar como a data será formatada
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyy");
        LocalDate d06 = LocalDate.parse("31/01/2023", fmt1);
        System.out.println(d06);

        // Formatando a saída de uma data
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime d07 = LocalDateTime.parse("31/01/2023 16:20", fmt2);
        // Resultado: 2023-01-31T16:20
        System.out.println(d07);

        // Método of() permite formatar a saída da data
        LocalDate d08 = LocalDate.of(2023, 01, 31);
        System.out.println(d08);

        LocalDateTime d09 = LocalDateTime.of(2023, 01, 31, 22, 20);
        System.out.println(d09);
    }
}
