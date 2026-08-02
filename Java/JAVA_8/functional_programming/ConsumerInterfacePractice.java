package java8.functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfacePractice {
    public static void main(String[] args) {
        //first example
        Consumer<String> consumer = x-> System.out.println(x);
        consumer.accept("Nitesh");

        //second example
        Consumer<List<Integer>> listConsumer = x->{
            for(Integer i: x){
                System.out.println(i+100);
            }
        };
        listConsumer.accept(Arrays.asList(1,5,7,8,9,8,7,4,5,8,2));


    }


}
