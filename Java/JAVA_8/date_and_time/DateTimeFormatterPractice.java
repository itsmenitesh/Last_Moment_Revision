package java8.date_and_time;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterPractice {
    public static void main(String[] args) {
        String data = "2024-03-05 11:45:00+05:30";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(data,formatter);
        System.out.println(zonedDateTime);
    }

}
/*
Letter Description
G Era designator
y Year
M Month in year
w Week in year
D Day count in year
d Day of the month
F Day of the week in month
E Day name in the week
u Day number of week
a AM or PM marker
H Hour in day (0~23)
m Minute in hour
s Second in minute
S Millisecond
z Time zone
X ISO 8601 time zone
 */