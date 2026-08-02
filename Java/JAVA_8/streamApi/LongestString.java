package java8.streamApi;

import java.util.*;
import java.util.stream.*;
public class LongestString {
    public static void main(String[] args) {
        List<String> al = Arrays.asList("Nitesh","Choudhary","is","a","backend","developer");
        int length=al.stream().map(String::length).reduce(Integer.MIN_VALUE,Integer::max);
        System.out.println("length: " + length);
    }
}
