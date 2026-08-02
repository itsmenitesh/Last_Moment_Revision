package java8.date_and_time;

import java.time.LocalTime;

public class LocalTimePractice {
    public static void main(String[] args) {
        //now
        LocalTime now = LocalTime.now();
        System.out.println(now);
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());
        System.out.println(now.getClass());

        //custom
        LocalTime custom = LocalTime.of(10,25,25);
        System.out.println(custom);

        //others
        if(now.isAfter(custom))System.out.println("Hello Nitesh");
    }
}
