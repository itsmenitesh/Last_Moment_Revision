package java8.date_and_time;

import com.sun.tools.javac.Main;

import java.time.LocalDate;
import java.time.Period;

public class PeriodPractice {
    public static void main(String[] args) {
        LocalDate born = LocalDate.of(1997,10,17);
        LocalDate today = LocalDate.now();
        Period period = Period.between(born,today);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(period.getChronology());
        System.out.println(period.getChronology());

    }
}
