package java8.date_and_time;

import java.time.LocalDate;

public class LocalDatePractice {
    public static void main(String[] args) {
        //now
        LocalDate now = LocalDate.now();

        System.out.println(now);
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.atStartOfDay());
        System.out.println(now.getEra());
        //custom
        LocalDate custom = LocalDate.of(1997,12,17);
        System.out.println(custom);
        System.out.println(custom.getChronology());
    }
}
