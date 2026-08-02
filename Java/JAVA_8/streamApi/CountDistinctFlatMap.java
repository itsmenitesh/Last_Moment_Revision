package java8.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class CountDistinctFlatMap {
    public static void main(String[] args) {
        List<List<Integer>> al = Arrays.asList(
            Arrays.asList(1, 8, 5, 4, 1, 2, 4),
            Arrays.asList(3, 4, 5, 3, 5, 8, 6, 4, 8),
            Arrays.asList(10, 2, 0, 23, 0, 1, 5, 58, 1, 0, 5, 7, 0, 2, 4, 0, 36, 4, 0, 5, 10, 5),
            Arrays.asList(55, 545, 47, 785, 2124, 87, 4, 248, 75, 2, 12, 10, 0, 524, 0, 152, 4784, 20, 20)
        );

        List<Integer> dist = al.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());

        System.out.println(dist);
    }
}
