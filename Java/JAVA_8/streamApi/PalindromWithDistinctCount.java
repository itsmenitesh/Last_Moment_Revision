package java8.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class PalindromWithDistinctCount {
    public static void main(String[] args) {
        List<String> al = List.of("hello", "world", "madam", "level", "noon", "jahaj");
        List<String> palindrom = al.stream().filter(str -> isPalindrom(str)).collect(Collectors.toList());

        palindrom.forEach(str -> {
            long dist = str.chars().distinct().count();
            System.out.println(str + " : " + dist);
        });
    }

    public static boolean isPalindrom(String str) {
        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
