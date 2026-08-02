package java8.streamApi;

import java.util.*;
import java.util.stream.Collectors;
public class SumSquareofEvenNumber {

    public static void main(String[] args) {
        List<Integer> al = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> even = al.stream().filter(i-> i % 2==0).collect(Collectors.toList());
        long sum = even.stream().mapToInt(i ->i*i).sum();
        System.out.println("sum = " + sum);

        //or 2nd method 
        int sums = al.stream().filter(i->i%2==0).mapToInt(i->i*i).sum();
        System.out.println(sums);
    }
}