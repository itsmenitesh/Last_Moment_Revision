package java8.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Factorial {
    public static void main(String[] args) {
        List<Integer> al = Arrays.asList(1, 2, 5, 7, 8, 9, 10);
        List<Integer> factor = al.stream().map(n -> isFactor(n)).collect(Collectors.toList());
        System.out.println("factor: " + factor);
    }

    public static int isFactor(int n) {
        if (n == 1) return 1;
        return n * isFactor(n - 1);
    }
}
