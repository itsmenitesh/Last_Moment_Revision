package java8.date_and_time;

import java.time.LocalDateTime;

public class LocalDate_TimePractice {

    public static void main(String[] args) {
        //now
        LocalDateTime now= LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.toLocalDate());
        System.out.println(now.toLocalTime());
        System.out.println(now.minusMonths(1000));

        //custom
        LocalDateTime custom = LocalDateTime.of(1997,12,17,9,0);
        System.out.println(custom);
    }
}
