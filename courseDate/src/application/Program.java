package application;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {

    public static void main(String[] args) {

        DateTimeFormatter fmt7 =DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt6 =DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        /*no caso do instant, que depende do fuso horario, eu preciso informar qual o fuso horario q sera usado.

        * o withZone é um metodo que eh utilizado para especificar qual o fuso horario que eu vou utilizar
        ZodeId.systemDefault() pega o fuso horario do computador do usuario*/
        DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt3 = DateTimeFormatter.ISO_INSTANT;



        //para instanciar o 'agora' eu crio um objeto do tipo Localdate (proprio do Java) e chamo o metodo '.now()'
        LocalDate d01 = LocalDate.now();
        //local com hora

        //GMT com hora
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        LocalDate d04 = LocalDate.parse("2022-04-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-04-20T01:30:26");
        Instant d06 = Instant.parse("2022-04-20T01:30:26Z");
        Instant d07 = Instant.parse("2022-04-20T01:30:26-03:00");

        LocalDate d08 = LocalDate.parse("20/07/2022", fmt7);
        LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt6);



        System.out.println(d01);
        System.out.println(d02);
        System.out.println(d03);
        System.out.println(d04);
        System.out.println(d05);
        System.out.println(d06);
        System.out.println(d07);
        System.out.println(d08);
        System.out.println(d09);

        System.out.println(d08.format(fmt7));
        System.out.println(fmt7.format(d08));

        System.out.println(d09.format(fmt6));
        System.out.println(fmt6.format(d09));

        System.out.println(fmt5.format(d06));

        System.out.println(d05.format(fmt4));

        System.out.println(fmt3.format(d06));

        System.out.println("-------------transformando global em local --------------------------");

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));

        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));


        System.out.println(r1);
        System.out.println(r2);
        System.out.println();
        System.out.println(r3);
        System.out.println(r4);


        System.out.println("-------------Obtendo dados de uma data-hora local --------------------------");

        System.out.println("d04 dia = " + d04.getDayOfMonth());
        System.out.println("d04 dia = " + d04.getMonthValue());
        System.out.println("d04 dia = " + d04.getYear());
        System.out.println();

        System.out.println("d05 hora : " + d05.getHour());
        System.out.println("d05 hora : " + d05.getMinute());

        System.out.println("------------- Calculos com data-hora --------------------------");

        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nextWeek = d04.plusDays(7);

        System.out.println("pastWeek: " + pastWeekLocalDate);
        System.out.println("nextWeek: " + nextWeek);
        System.out.println();
        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime nextWeekTime = d05.plusDays(7);

        System.out.println("pastWeek: " + pastWeekLocalDateTime);
        System.out.println("nextWeek: " + nextWeekTime);
        System.out.println();
        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekInstant: " + pastWeekInstant);
        System.out.println("nextWeekInstant: " + nextWeekInstant);

        System.out.println("------------- Descobrindo a duração --------------------------");

        Duration t1 = Duration.between(pastWeekLocalDateTime, d05);
        Duration t2 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());//o atStart.
        //eh para converter para DateTime comecando do inicio do dia... basta lembrar q LocalDate n tem hora
        Duration t3 = Duration.between(pastWeekInstant, d06);
        Duration t4 = Duration.between(d06, pastWeekInstant);


        System.out.println("t1 dias = " + t1.toDays());
        System.out.println();
        System.out.println("t2 dias = " + t2.toDays());
        System.out.println();
        System.out.println("t3 dias = " + t3.toDays());
        System.out.println();
        System.out.println("t4 dias = " + t4.toDays());




    }
}
