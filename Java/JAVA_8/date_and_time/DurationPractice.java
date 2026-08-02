package java8.date_and_time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DurationPractice {
    public static void main(String[] args) {
        Instant start  = Instant.now();
        int sum=0;
        for(int i =0;i<1234567;i++){
            if(i%3==0 && i%2==0 && i!=0 && i%5==0)sum+=i;
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println(duration);
        Duration duration1 = Duration.of(2, ChronoUnit.MILLIS);
        System.out.println(duration1);
        System.out.println(duration.compareTo(duration1));
    }
}
