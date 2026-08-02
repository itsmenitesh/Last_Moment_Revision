package java8.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class distinctCount {
    public static void main(String[] args) {
        List<String> al = List.of("hello", "world", "madam", "level", "noon", "jahaj");
       al.forEach(str->{
       long disticnt=     str.chars().distinct().count();
            System.out.println(str+" : "+disticnt);
        });
        
    }}