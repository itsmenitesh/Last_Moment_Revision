package java8.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByStringAccordingLength {
    public static void main(String[] args) {
                List<String> al = List.of("hello", "world", "madam", "level", "noon", "jahaj");

                Map<Integer,List<String>> map = al.stream().collect(Collectors.groupingBy(String::length));

                map.forEach((count,val)->{
                    System.out.println(count + " " + val);

                });

    }
}
