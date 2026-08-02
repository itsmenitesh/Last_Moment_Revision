package java8.streamApi;

import java.util.*;
import java.util.stream.*;
public class GroupByFirstLetter {
    public static void main(String[] args) {
        List<String> al = Arrays.asList("Nitesh","Choudhary","is","a","backend","developer","admin","admin","back");
        Map<Character,List<String>> group = al.stream().collect(Collectors.groupingBy(str->str.charAt(0)));
        System.out.println(group);
    }
}
