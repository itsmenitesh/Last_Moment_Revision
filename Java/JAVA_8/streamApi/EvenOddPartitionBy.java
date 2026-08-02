package java8.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class EvenOddPartitionBy {
    public static void main(String[] args) {
        List<Integer> al = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25);

        Map<Boolean, List<Integer>> check = al.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));

        List<Integer> even = check.get(true);
        List<Integer> odd = check.get(false);

        System.out.println("even -> " + even);
        System.out.println("odd -> " + odd);
    }
}
