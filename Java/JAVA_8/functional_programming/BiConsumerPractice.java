package java8.functional_programming;

import java.util.function.BiConsumer;

/*
    BiConsumer is designed for scenarios where you need to perform an action or operation
    that consumes two inputs but does not produce any output. It's similar to Consumer,
    which accepts a single argument, but extends it to accept two arguments. This is helpful
    when you want to perform side effects, such as printing, logging, or updating state,
    based on two input values.
*/

public class BiConsumerPractice {
    public static void main(String[] args) {
        //example 1
        BiConsumer<String,String> biConsumer = (x,y)->System.out.println(x+" "+y);
        biConsumer.accept("Nitesh","Choudhary");

        //example 2
        // Define the first BiConsumer to print the values
        BiConsumer<Integer, String> printValues = (num, str) ->
                System.out.println("Number: " + num + ", String: " + str);

        // Define the second BiConsumer to increment the number and print
        BiConsumer<Integer, String> incrementAndPrint = (num, str) -> {
            num++;
            System.out.println("Incremented Number: " + num + ", String: " + str);
        };

        // Compose the BiConsumers using andThen
        BiConsumer<Integer, String> combinedConsumer = printValues.andThen(incrementAndPrint);

        // Test the composed BiConsumer
        combinedConsumer.accept(5, "Hello");

    }
}
