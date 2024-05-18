package com.adega.api.service.gestao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface AjusteDetempo {

     static LocalDate inicioDeMes(LocalDate l) {

        String local = l.toString();
        int year = Integer.parseInt(local.split("-")[0]);
        int month = Integer.parseInt(local.split("-")[1]);
        return LocalDate.of(year, month, 1);
    }

     static LocalDate fimDeMes(LocalDate l) {
        return inicioDeMes(l.plusMonths(1)).minusDays(1);
    }
     static LocalDate IncioDeAno(LocalDate l) {

        String local = l.toString();
        int ano = Integer.parseInt(local.split("-")[0]);
        return LocalDate.of(ano, 1, 1);
    }

     static LocalDate fimDeAno(LocalDate l) {
        String local = l.toString();
        int ano = Integer.parseInt(local.split("-")[0]);
        return LocalDate.of(ano, 12, 31);

    }
    static String formatandoData(LocalDate l) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        return  l.format(formatter);
    }
}