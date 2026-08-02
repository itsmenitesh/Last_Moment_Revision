package java8.date_and_time;

import java.time.Instant;

public class InstantPractice {
    public static void main(String[] args) {
        //before
        long before=System.currentTimeMillis();
        System.out.println(before);
        //now
        Instant now = Instant.now();
        System.out.println(now);
    }
}
