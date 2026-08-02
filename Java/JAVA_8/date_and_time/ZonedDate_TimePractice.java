package java8.date_and_time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedDate_TimePractice {
    public static void main(String[] args) {
        //now
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
       Set<String> allZoned= ZoneId.getAvailableZoneIds();
       allZoned.forEach(System.out::println);

       //custom
        ZonedDateTime custom = ZonedDateTime.of(1997,12,17,9,00,00,00,ZoneId.of("Asia/Calcutta"));
        System.out.println(custom);

        //by particular zone
        ZonedDateTime india = ZonedDateTime.now(ZoneId.of("Asia/Calcutta"));
        System.out.println(india);
        ZonedDateTime newYour = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(newYour);

    }
}
